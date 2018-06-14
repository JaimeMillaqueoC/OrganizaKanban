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
import vista.Principal.Panel;

/**
 *
 * @author analista.apoyo1
 */
public class RecuperadorActivdades {
    
    private Actividad actividadUno,actividadDos,actividadTres;
    private Panel panelTemporalUno, panelTemporalDos, panelTemporalTres;

    public RecuperadorActivdades(Panel panelTemporalUno, Panel panelTemporalDos, Panel panelTemporalTres) {
        this.panelTemporalUno = panelTemporalUno;
        this.panelTemporalDos = panelTemporalDos;
        this.panelTemporalTres = panelTemporalTres;
        agregarActvidades();
    }
    
    private void agregarActvidades() {
        try {
            String filaCaracteres;
            String archivoDatosUsuario = "Datos/actividadesUsuario.txt";
            
            FileReader lectorArchivoDatosUsuario = new FileReader(archivoDatosUsuario);
            BufferedReader bufferArchivoDatosUsuario = new BufferedReader(lectorArchivoDatosUsuario);
            
            while((filaCaracteres = bufferArchivoDatosUsuario.readLine())!= null) {
                String partesActividad[] =  filaCaracteres.split("&");
                if(partesActividad[2].equals(this.panelTemporalUno.getTitulo())){
                    this.actividadUno = new Actividad(partesActividad[0]);
                    this.actividadUno.setDescripcion(partesActividad[1]);
                    this.panelTemporalUno.agregarLista(this.actividadUno);
                }
                if(partesActividad[2].equals(this.panelTemporalDos.getTitulo())){
                    this.actividadDos = new Actividad(partesActividad[0]);
                    this.actividadDos.setDescripcion(partesActividad[1]);
                    this.panelTemporalDos.agregarLista(this.actividadDos);
                }
                if(partesActividad[2].equals(this.panelTemporalTres.getTitulo())){
                    this.actividadTres = new Actividad(partesActividad[0]);
                    this.actividadTres.setDescripcion(partesActividad[1]);
                    this.panelTemporalTres.agregarLista(this.actividadTres);
                    this.actividadTres = null;
                }
            }
            bufferArchivoDatosUsuario.close();
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.err.println("");
    }
    
    
    
    
}
