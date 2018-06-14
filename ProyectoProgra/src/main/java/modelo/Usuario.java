/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolas
 */
public class Usuario {
    
    private String nombre;
    private String universidad;
    private String rutaFoto;
    
    public Usuario() {
        this.recuperarDatos();
    }

    public Usuario(String primerNombre, String apellidoMaterno, String apellitoPaterno, String universidad, String rutaFoto) {
        this.nombre = primerNombre;
        this.universidad = universidad;
        this.rutaFoto = rutaFoto;
    }
    
    private void recuperarDatos() {
        try {
            String filaCaracteres;
            String archivoDatosUsuario = "Datos/datosUsuario.txt";
            
            FileReader lectorArchivoDatosUsuario = new FileReader(archivoDatosUsuario);
            BufferedReader bufferArchivoDatosUsuario = new BufferedReader(lectorArchivoDatosUsuario);
            
            while((filaCaracteres = bufferArchivoDatosUsuario.readLine())!= null) {
                String partesFilaCaracteres[] =  filaCaracteres.split("&");
                this.nombre  = partesFilaCaracteres[0];
                this.universidad = partesFilaCaracteres[1];
                this.rutaFoto = partesFilaCaracteres[2];
            }
            bufferArchivoDatosUsuario.close();
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
