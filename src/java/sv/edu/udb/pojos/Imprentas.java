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
public class Imprentas {
    private int id;
    private String imprenta;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImprenta() {
        return imprenta;
    }

    public void setImprenta(String imprenta) {
        this.imprenta = imprenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Imprentas(int id, String imprenta, String descripcion) {
        this.id = id;
        this.imprenta = imprenta;
        this.descripcion = descripcion;
    }   
}