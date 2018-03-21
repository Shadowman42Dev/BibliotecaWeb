/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.Reservaciones;
/**
 *
 * @author renea
 */
public class ReservacionesModel {
    Conexion conexion;
    static ArrayList<Reservaciones> reservaciones = new ArrayList<>();
    
    public void getReservaciones() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from reservaciones"));
            while (conexion.getRs().next()) {
                reservaciones.add(new Reservaciones(
                        conexion.getRs().getInt(1),
                        new UsuariosModel().find(conexion.getRs().getInt(2)),
                        new LibrosModel().find(conexion.getRs().getInt(3)),
                        conexion.getRs().getDate(4),
                        conexion.getRs().getDate(5))                
                );
            }
            conexion.desconectar();
            conexion.cerrarRs();
        } catch (SQLException e) {
            System.out.println("ocurrio un error \n" + e.getMessage());
        }
    }
    
    public Reservaciones find(int id){
        getReservaciones();
        for (Reservaciones reservacion : reservaciones) {
            if (reservacion.getId() == id) {
                return reservacion;
            }
        }
        return null;
    }
    
    public boolean insertar(Reservaciones reservacion){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into reservaciones values (?, ?, ?, ?)");
            conexion.getPst().setInt(1, reservacion.getUsuario().getId());
            conexion.getPst().setInt(2, reservacion.getLibro().getId());
            conexion.getPst().setDate(3, reservacion.getFechaPrestamo());
            conexion.getPst().setDate(4, reservacion.getFechaEntrega());            
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getReservaciones();
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
    
    public boolean actualizar(Reservaciones reservacion){
        try {
            conexion = new Conexion();
            conexion.setPst("update reservaciones set usuario = ?, libro = ?, fechaprestamo = ?, fechaentrega = ? where id = ?");
            conexion.getPst().setInt(5, reservacion.getId());
            conexion.getPst().setInt(1, reservacion.getUsuario().getId());
            conexion.getPst().setInt(2, reservacion.getLibro().getId());
            conexion.getPst().setDate(3, reservacion.getFechaPrestamo());
            conexion.getPst().setDate(4, reservacion.getFechaEntrega());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getReservaciones();
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
            conexion.setPst("delete from reservaciones where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getReservaciones();
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
