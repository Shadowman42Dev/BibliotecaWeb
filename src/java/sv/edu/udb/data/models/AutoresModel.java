/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;

import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.pojos.Autores;
import sv.edu.udb.data.Conexion;

/**
 *
 * @author renea
 */
public class AutoresModel {
    Conexion conexion;
    static ArrayList<Autores> autores = new ArrayList<>();

    public void getAutores() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from autores"));
            while (conexion.getRs().next()) {
                autores.add(new Autores(
                        conexion.getRs().getInt(1),
                        conexion.getRs().getString(2),
                        conexion.getRs().getDate(3),
                        conexion.getRs().getDate(4))
                );
            }
            conexion.desconectar();
            conexion.cerrarRs();
        } catch (SQLException e) {
            System.out.println("ocurrio un error \n" + e.getMessage());
        }
    }
    
    public Autores find(int id){
        getAutores();
        for (Autores autor : autores) {
            if (autor.getId() == id) {
                return autor;
            }
        }
        return null;        
    }
    
    public boolean insertar(Autores autor){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into autores values (?, ?, ?)");
            conexion.getPst().setString(1, autor.getNombre());
            conexion.getPst().setDate(2, autor.getFechaNacimiento());
            conexion.getPst().setDate(3, autor.getFechaDefuncion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getAutores();
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
    
    public boolean actualizar(Autores autor){
        try {
            conexion = new Conexion();
            conexion.setPst("update autores set nombre = ?, fechanacimiento = ?, fechadefuncion = ? where id = ?");
            conexion.getPst().setInt(4, autor.getId());
            conexion.getPst().setString(1, autor.getNombre());
            conexion.getPst().setDate(2, autor.getFechaNacimiento());
            conexion.getPst().setDate(3, autor.getFechaDefuncion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getAutores();
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
            conexion.setPst("delete from autores where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getAutores();
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