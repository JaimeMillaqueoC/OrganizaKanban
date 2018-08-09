/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.principal.Actividad;
import vista.principal.Panel;

/**
 *
 * @author analista.apoyo1
 */
public class GestionarActividades {
    
    private Panel panelPorHacer;
    private Panel panelHaciendo;
    private Panel panelHecho;
    
    public GestionarActividades(Panel panelPorHacer, Panel panelHaciendo, Panel panelHecho) {
        this.panelPorHacer = panelPorHacer;
        this.panelHaciendo = panelHaciendo;
        this.panelHecho = panelHecho;
    }
    
    public Panel agregarActividadPanelPorHacer(Actividad actividad){
        this.panelPorHacer.agregarActividad(actividad);
        this.panelPorHacer.add(actividad);
        return this.panelPorHacer;
    }
    public Panel agregarActividadPanelHaciendo(Actividad actividad){
        this.panelHaciendo.agregarActividad(actividad);
        this.panelHaciendo.add(actividad);
        return this.panelHaciendo;
    }
    public Panel agregarActividadPanelHecho(Actividad actividad){
        this.panelHecho.agregarActividad(actividad);
        this.panelHecho.add(actividad);
        return this.panelHecho;
    }  
}
