/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.Temas;
/**
 *
 * @author renea
 */
public class TemasModel {
    Conexion conexion;
    static ArrayList<Temas> temas = new ArrayList<>();
    
    public void getTemas() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from temas"));
            while (conexion.getRs().next()) {
                temas.add(new Temas(
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
    
    public Temas find(int id){
        getTemas();
        for (Temas tema : temas) {
            if (tema.getId() == id) {
                return tema;
            }
        }
        return null;
    }
    
    public boolean insertar(Temas tema){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into temas values (?, ?)");
            conexion.getPst().setString(1, tema.getTema());
            conexion.getPst().setString(2, tema.getDescripcion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getTemas();
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
    
    public boolean actualizar(Temas tema){
        try {
            conexion = new Conexion();
            conexion.setPst("update temas set tema = ?, descripcion = ? where id = ?");
            conexion.getPst().setInt(3, tema.getId());
            conexion.getPst().setString(1, tema.getTema());
            conexion.getPst().setString(2, tema.getDescripcion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getTemas();
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
            conexion.setPst("delete from temas where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getTemas();
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
