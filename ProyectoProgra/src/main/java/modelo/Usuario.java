/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author nicolas
 */
public class Usuario implements java.io.Serializable{
    
    private String nombre;
    private String universidad;
    private String rutaFoto;
    
    public Usuario() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String primerNombre) {
        this.nombre = primerNombre;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
    
    
    
}
