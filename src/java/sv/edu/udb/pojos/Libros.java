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
public class Libros {
    private int id;
    private Autores autor;
    private String titulo;
    private Categorias categoria;
    private int edicion;
    private Imprentas imprenta;
    private String sinopsis;
    private String isbn;
    private String observaciones;
    private String imagen;
    private Estados estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public Imprentas getImprenta() {
        return imprenta;
    }

    public void setImprenta(Imprentas imprenta) {
        this.imprenta = imprenta;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Libros(int id, Autores autor, String titulo, Categorias categoria, int edicion, Imprentas imprenta, String sinopsis, String isbn, String observaciones, String imagen, Estados estado) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.categoria = categoria;
        this.edicion = edicion;
        this.imprenta = imprenta;
        this.sinopsis = sinopsis;
        this.isbn = isbn;
        this.observaciones = observaciones;
        this.imagen = imagen;
        this.estado = estado;
    }  
}
