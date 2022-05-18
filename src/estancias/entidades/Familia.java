/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.entidades;

/**
 *
 * @author Gustavo Torti
 */
public class Familia {
    private int idFamilia;
    private String nombre;
    private int edadMinima;
    private int edadMaxima;
    private int numDeHijos;
    private String email;
    private int idCasaFamilia;

    public Familia() {
    }

    public Familia( String nombre, int edadMinima, int edadMaxima, int numDeHijos, String email, int idCasaFamilia) {
        
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.numDeHijos = numDeHijos;
        this.email = email;
        this.idCasaFamilia = idCasaFamilia;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public int getNumDeHijos() {
        return numDeHijos;
    }

    public void setNumDeHijos(int numDeHijos) {
        this.numDeHijos = numDeHijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCasaFamilia() {
        return idCasaFamilia;
    }

    public void setIdCasaFamilia(int idCasaFamilia) {
        this.idCasaFamilia = idCasaFamilia;
    }

    @Override
    public String toString() {
        return "Familia{" + "idFamilia=" + idFamilia + ", nombre=" + nombre + ", edadMinima=" + edadMinima + ", edadMaxima=" + edadMaxima + ", numDeHijos=" + numDeHijos + ", email=" + email + ", idCasaFamilia=" + idCasaFamilia + '}';
    }
    
    
}
