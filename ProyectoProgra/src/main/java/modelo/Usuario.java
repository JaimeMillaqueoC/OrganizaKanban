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
public class Usuario {
    
    private String primerNombre;
    private String apellidoMaterno;
    private String apellitoPaterno;
    private String universidad;
    private String rutaFoto;
    
    public Usuario() {
        this.primerNombre = "Nombre Usuario";
        this.apellidoMaterno = "Apellido 1";
        this.apellitoPaterno = "Apellido2";
        this.universidad = "Universidad de XX";
        this.rutaFoto = "Utilizables/fotoUser.png";
    }

    public Usuario(String primerNombre, String apellidoMaterno, String apellitoPaterno, String universidad, String rutaFoto) {
        this.primerNombre = primerNombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellitoPaterno = apellitoPaterno;
        this.universidad = universidad;
        this.rutaFoto = rutaFoto;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellitoPaterno() {
        return apellitoPaterno;
    }

    public void setApellitoPaterno(String apellitoPaterno) {
        this.apellitoPaterno = apellitoPaterno;
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
