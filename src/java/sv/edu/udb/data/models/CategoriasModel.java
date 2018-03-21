/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;

import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.Categorias;

/**
 *
 * @author renea
 */
public class CategoriasModel {
    Conexion conexion;
    static ArrayList<Categorias> categorias = new ArrayList<>();
    
    public void getCategorias() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from categorias"));
            while (conexion.getRs().next()) {
                categorias.add(new Categorias(
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
    
    public Categorias find(int id){
        getCategorias();
        for (Categorias categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }
    
    public boolean insertar(Categorias categoria){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into categorias values (?, ?)");
            conexion.getPst().setString(1, categoria.getNombre());
            conexion.getPst().setString(2, categoria.getDescripcion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getCategorias();
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
    
    public boolean actualizar(Categorias categoria){
        try {
            conexion = new Conexion();
            conexion.setPst("update categorias set nombre = ?, descripcion = ? where id = ?");
            conexion.getPst().setInt(3, categoria.getId());
            conexion.getPst().setString(1, categoria.getNombre());
            conexion.getPst().setString(2, categoria.getDescripcion());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getCategorias();
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
            conexion.setPst("delete from categorias where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getCategorias();
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