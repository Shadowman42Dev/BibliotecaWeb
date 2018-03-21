/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.pojos;

import java.sql.Date;

/**
 *
 * @author renea
 */
public class Prestamos {
    private int id;
    private Usuarios usuario;
    private Libros libro;
    private Date fechaPrestamo;
    private Date fechaEntrega;
    private int prorroga;
    private double multa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getProrroga() {
        return prorroga;
    }

    public void setProrroga(int prorroga) {
        this.prorroga = prorroga;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }    

    public Prestamos(int id, Usuarios usuario, Libros libro, Date fechaPrestamo, Date fechaEntrega, int prorroga, double multa) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.prorroga = prorroga;
        this.multa = multa;
    }
}
