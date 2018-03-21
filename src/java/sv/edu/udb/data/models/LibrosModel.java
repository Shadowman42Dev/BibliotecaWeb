/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data.models;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.data.Conexion;
import sv.edu.udb.pojos.Libros;

/**
 *
 * @author renea
 */
public class LibrosModel {
    Conexion conexion;
    static ArrayList<Libros> libros = new ArrayList<>();
    
        public void getLibros() {
        try {
            conexion = new Conexion();
            conexion.setRs(conexion.getSt().executeQuery("select * from libros"));
            while (conexion.getRs().next()) {
                libros.add(new Libros(
                        conexion.getRs().getInt(1),
                        new AutoresModel().find(conexion.getRs().getInt(2)),
                        conexion.getRs().getString(3),
                        new CategoriasModel().find(conexion.getRs().getInt(4)),
                        conexion.getRs().getInt(5),
                        new ImprentasModel().find(conexion.getRs().getInt(6)),
                        conexion.getRs().getString(7),
                        conexion.getRs().getString(8),
                        conexion.getRs().getString(9),
                        conexion.getRs().getString(10),
                        new EstadosModel().find(conexion.getRs().getInt(11))));
            }
            conexion.desconectar();
            conexion.cerrarRs();
        } catch (SQLException e) {
            System.out.println("ocurrio un error \n" + e.getMessage());
        }
    }
    
    public Libros find(int id){
        getLibros();
        for (Libros libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }
    
    public boolean insertar(Libros libro){
        try {
            conexion = new Conexion();
            conexion.setPst("insert into libros values (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)");
            conexion.getPst().setInt(1, libro.getAutor().getId());
            conexion.getPst().setString(2, libro.getTitulo());
            conexion.getPst().setInt(3, libro.getCategoria().getId());
            conexion.getPst().setInt(4, libro.getEdicion());
            conexion.getPst().setInt(5, libro.getImprenta().getId());
            conexion.getPst().setString(6, libro.getSinopsis());
            conexion.getPst().setString(7, libro.getIsbn());
            conexion.getPst().setString(8, libro.getObservaciones());
            conexion.getPst().setString(9, libro.getImagen());
            conexion.getPst().setInt(10, libro.getEstado().getId());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getLibros();
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
    
    public boolean actualizar(Libros libro){
        try {
            conexion = new Conexion();
            conexion.setPst("update libros set autor = ?, titulo = ?, categoria = ?, edicion = ?, imprenta = ?, sinopsis = ?, isbn = ?, observaciones = ?, imagen = ?, estado = ?  where id = ?");
            conexion.getPst().setInt(10, libro.getAutor().getId());
            conexion.getPst().setString(1, libro.getTitulo());
            conexion.getPst().setInt(2, libro.getCategoria().getId());
            conexion.getPst().setInt(3, libro.getEdicion());
            conexion.getPst().setInt(4, libro.getImprenta().getId());
            conexion.getPst().setString(5, libro.getSinopsis());
            conexion.getPst().setString(6, libro.getIsbn());
            conexion.getPst().setString(7, libro.getObservaciones());
            conexion.getPst().setString(8, libro.getImagen());
            conexion.getPst().setInt(9, libro.getEstado().getId());
            if (conexion.getPst().executeUpdate() > 0) {
                conexion.desconectar();
                conexion.cerrarRs();
                getLibros();
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
            conexion.setPst("delete from libros where id = ?");
            conexion.getPst().setInt(1, id);
            if(conexion.getPst().executeUpdate() > 0){
                conexion.desconectar();
                conexion.cerrarRs();
                getLibros();
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
