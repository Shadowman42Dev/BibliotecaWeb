/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.Usuarios;
/**
 *
 * @author renea
 */
public class UsuariosModel {
    Conexion conexion;
    static ArrayList<Usuarios> usuarios = new ArrayList<>();
    
    public void getUsuarios() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from usuarios"));
            while (conexion.getRs().next()) {
                usuarios.add(new Usuarios(
                        conexion.getRs().getInt(1),
                        conexion.getRs().getString(2),
                        conexion.getRs().getString(3))
                );
            }
            conexion.desconectar();
            conexion.cerrarRs();
        } catch (SQLException e) {
            System.out.println("ocurrio un error \n" + e.getMessage());
        }
    }
    
    public Usuarios find(int id){
        getUsuarios();
        for (Usuarios usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    
    public boolean insertar(Usuarios usuario){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into usuarios values (?, SHA2(?))");
            conexion.getPst().setString(1, usuario.getUsuario());
            conexion.getPst().setString(2, usuario.getPass());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getUsuarios();
                return true;
            }else{
                conexion.desconectar();
                conexion.cerrarRs();
                return false;
            }            
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean actualizar(Usuarios usuario){
        try {
            conexion = new Conexion();
            conexion.setPst("update usuarios set usuario = ?, pass = SHA2(?) where id = ?");
            conexion.getPst().setInt(3, usuario.getId());
            conexion.getPst().setString(1, usuario.getUsuario());
            conexion.getPst().setString(2, usuario.getPass());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getUsuarios();
                return true;
            }else{
                conexion.desconectar();
                conexion.cerrarRs();
                return false;
            }            
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            conexion = new Conexion();
            conexion.setPst("delete from usuarios where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getUsuarios();
                return true;
            }else{
                conexion.desconectar();
                conexion.cerrarRs();
                return false;
            }            
        } catch (Exception e) {
            return false;
        }
    }
}
