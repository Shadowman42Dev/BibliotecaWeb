/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;

import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.Estados;

/**
 *
 * @author renea
 */
public class EstadosModel {
    Conexion conexion;
    static ArrayList<Estados> estados = new ArrayList<>();
    
    public void getEstados() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from estados"));
            while (conexion.getRs().next()) {
                estados.add(new Estados(
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
    
    public Estados find(int id){
        getEstados();
        for (Estados estado : estados) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        return null;
    }
    
    public boolean insertar(Estados estado){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into estados values (?, ?)");
            conexion.getPst().setString(1, estado.getNombre());
            conexion.getPst().setString(2, estado.getDescripcion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getEstados();
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
    
    public boolean actualizar(Estados estado){
        try {
            conexion = new Conexion();
            conexion.setPst("update estados set nombre = ?, descripcion = ? where id = ?");
            conexion.getPst().setInt(3, estado.getId());
            conexion.getPst().setString(1, estado.getNombre());
            conexion.getPst().setString(2, estado.getDescripcion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getEstados();
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
            conexion.setPst("delete from estados where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getEstados();
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
