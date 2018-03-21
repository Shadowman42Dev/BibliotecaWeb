/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.Imprentas;

/**
 *
 * @author renea
 */
public class ImprentasModel {
    Conexion conexion;
    static ArrayList<Imprentas> imprentas = new ArrayList<>();
    
    public void getImprentas() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from imprentas"));
            while (conexion.getRs().next()) {
                imprentas.add(new Imprentas(
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
    
    public Imprentas find(int id){
        getImprentas();
        for (Imprentas imprenta : imprentas) {
            if (imprenta.getId() == id) {
                return imprenta;
            }
        }
        return null;
    }
    
    public boolean insertar(Imprentas imprenta){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into imprentas values (?, ?)");
            conexion.getPst().setString(1, imprenta.getImprenta());
            conexion.getPst().setString(2, imprenta.getDescripcion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getImprentas();
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
    
    public boolean actualizar(Imprentas imprenta){
        try {
            conexion = new Conexion();
            conexion.setPst("update imprentas set nombre = ?, descripcion = ? where id = ?");
            conexion.getPst().setInt(3, imprenta.getId());
            conexion.getPst().setString(1, imprenta.getImprenta());
            conexion.getPst().setString(2, imprenta.getDescripcion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getImprentas();
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
            conexion.setPst("delete from imprentas where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getImprentas();
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
