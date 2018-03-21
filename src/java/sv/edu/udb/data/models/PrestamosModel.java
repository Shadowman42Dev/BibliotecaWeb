/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.Prestamos;

/**
 *
 * @author renea
 */
public class PrestamosModel {
    Conexion conexion;
    static ArrayList<Prestamos> prestamos = new ArrayList<>();
    
    public void getPrestamos() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from prestamos"));
            while (conexion.getRs().next()) {
                prestamos.add(new Prestamos(
                        conexion.getRs().getInt(1),
                        new UsuariosModel().find(conexion.getRs().getInt(2)),
                        new LibrosModel().find(conexion.getRs().getInt(3)),
                        conexion.getRs().getDate(4),
                        conexion.getRs().getDate(5),
                        conexion.getRs().getInt(6),
                        conexion.getRs().getDouble(7))                
                );
            }
            conexion.desconectar();
            conexion.cerrarRs();
        } catch (SQLException e) {
            System.out.println("ocurrio un error \n" + e.getMessage());
        }
    }
    
    public Prestamos find(int id){
        getPrestamos();
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getId() == id) {
                return prestamo;
            }
        }
        return null;
    }
    
    public boolean insertar(Prestamos prestamo){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into prestamos values (?, ?, ?, ?, ?, ?)");
            conexion.getPst().setInt(1, prestamo.getUsuario().getId());
            conexion.getPst().setInt(2, prestamo.getLibro().getId());
            conexion.getPst().setDate(3, prestamo.getFechaPrestamo());
            conexion.getPst().setDate(4, prestamo.getFechaEntrega());
            conexion.getPst().setInt(5, prestamo.getProrroga());
            conexion.getPst().setDouble(6, prestamo.getMulta());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getPrestamos();
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
    
    public boolean actualizar(Prestamos prestamo){
        try {
            conexion = new Conexion();
            conexion.setPst("update prestamos set usuario = ?, libro = ?, fechaprestamo = ?, fechaentrega = ?, prorrogra = ?, multa = ? where id = ?");
            conexion.getPst().setInt(7, prestamo.getId());
            conexion.getPst().setInt(1, prestamo.getUsuario().getId());
            conexion.getPst().setInt(2, prestamo.getLibro().getId());
            conexion.getPst().setDate(3, prestamo.getFechaPrestamo());
            conexion.getPst().setDate(4, prestamo.getFechaEntrega());
            conexion.getPst().setInt(5, prestamo.getProrroga());
            conexion.getPst().setDouble(6, prestamo.getMulta());            
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getPrestamos();
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
            conexion.setPst("delete from prestamos where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getPrestamos();
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
