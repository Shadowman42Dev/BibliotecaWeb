/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.pojos;

/**
 *
 * @author renea
 */
public class LibrosTemas {
    private int id;
    private Libros libro;
    private Temas tema;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public Temas getTema() {
        return tema;
    }

    public void setTema(Temas tema) {
        this.tema = tema;
    }

    public LibrosTemas(int id, Libros libro, Temas tema) {
        this.id = id;
        this.libro = libro;
        this.tema = tema;
    }
}
