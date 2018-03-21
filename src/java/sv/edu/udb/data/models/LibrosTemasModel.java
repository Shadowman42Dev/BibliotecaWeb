/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.LibrosTemas;
/**
 *
 * @author renea
 */
public class LibrosTemasModel {
    Conexion conexion;
    static ArrayList<LibrosTemas> librostemas = new ArrayList<>();
    
    public void getLibrosTemas() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from libros_temas"));
            while (conexion.getRs().next()) {
                librostemas.add(new LibrosTemas(
                        conexion.getRs().getInt(1),
                        new LibrosModel().find(conexion.getRs().getInt(2)),
                        new TemasModel().find(conexion.getRs().getInt(3)))
                );
            }
            conexion.desconectar();
            conexion.cerrarRs();
        } catch (SQLException e) {
            System.out.println("ocurrio un error \n" + e.getMessage());
        }
    }
    
    public LibrosTemas find(int id){
        getLibrosTemas();
        for (LibrosTemas librotemas : librostemas) {
            if (librotemas.getId() == id) {
                return librotemas;
            }
        }
        return null;
    }
    
    public boolean insertar(LibrosTemas librotemas){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into libros_temas values (?, ?)");
            conexion.getPst().setInt(1, librotemas.getLibro().getId());
            conexion.getPst().setInt(2, librotemas.getTema().getId());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getLibrosTemas();
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
    
    public boolean actualizar(LibrosTemas librotemas){
        try {
            conexion = new Conexion();
            conexion.setPst("update libros_temas set libro = ?, tema = ? where id = ?");
            conexion.getPst().setInt(3, librotemas.getId());
            conexion.getPst().setInt(1, librotemas.getLibro().getId());
            conexion.getPst().setInt(2, librotemas.getTema().getId());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getLibrosTemas();
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
            conexion.setPst("delete from libros_temas where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getLibrosTemas();
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
