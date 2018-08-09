/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.Principal.Actividad;
import vista.Principal.Panel;

/**
 *
 * @author analista.apoyo1
 */
public class GestorEstadisticas {
    
    private GestionarActividades panelesActividades;
    
    private int tiempoTotalTrabajado;
    private int actividadesTerminadas;
    private int actividadesSinTerminar;
    private int cantidadActividadesTotales;
    private int cantidadActividadesPorHaer;
    private int cantidadActividadesHaciendo;
    private int cantidadActividadesHechas;
    
    private Panel panelPorHacer;
    private Panel panelHaciendo;
    private Panel panelHecho;
    
    public GestorEstadisticas(GestionarActividades panelesActividades) {
        this.panelesActividades = panelesActividades;
        this.cantidadActividadesTotales = 0;
        this.cantidadActividadesPorHaer = 0;
        this.cantidadActividadesHaciendo = 0;
        this.cantidadActividadesHechas = 0;
        extraerPaneles();
        ExtraerDatos();
        
    }

    private void extraerPaneles() {
        this.panelPorHacer = this.panelesActividades.getPanelPorHacer();
        this.panelHaciendo = this.panelesActividades.getPanelHaciendo();
        this.panelHecho = this.panelesActividades.getPanelHecho();
    }
    
    private void ExtraerDatos() {
        panelPorHacer.getListaActividades().forEach((Actividad actividad) -> {
            this.cantidadActividadesPorHaer++;
            this.tiempoTotalTrabajado = this.tiempoTotalTrabajado + actividad.getSegundosActividad();
            if(actividad.getEstado() == true){
                this.actividadesTerminadas = this.actividadesTerminadas + 1;
            }else{
                this.actividadesSinTerminar = this.actividadesSinTerminar + 1;
            }
            this.cantidadActividadesTotales++;
        });
        panelHaciendo.getListaActividades().forEach((Actividad actividad) -> {
            this.cantidadActividadesHaciendo++;
            this.tiempoTotalTrabajado = this.tiempoTotalTrabajado + actividad.getSegundosActividad();
            if(actividad.getEstado()== true){
                this.actividadesTerminadas = this.actividadesTerminadas + 1;
            }else{
                this.actividadesSinTerminar = this.actividadesSinTerminar + 1;
            }
            this.cantidadActividadesTotales++;
        });
        panelHecho.getListaActividades().forEach((Actividad actividad) -> {
            this.cantidadActividadesHechas++;
            this.tiempoTotalTrabajado = this.tiempoTotalTrabajado + actividad.getSegundosActividad();
            if(actividad.getEstado() == true){
                this.actividadesTerminadas = this.actividadesTerminadas + 1;
            }else{
                this.actividadesSinTerminar = this.actividadesSinTerminar + 1;
            }
            this.cantidadActividadesTotales++;
        });
    }

    public int getTiempoTotalTrabajado() {
        return tiempoTotalTrabajado;
    }

    public int getActividadesTerminadas() {
        return actividadesTerminadas;
    }

    public int getActividadesSinTerminar() {
        return actividadesSinTerminar;
    }

    public int getCantidadActividadesTotales() {
        return cantidadActividadesTotales;
    }

    public int getCantidadActividadesPorHaer() {
        return cantidadActividadesPorHaer;
    }

    public int getCantidadActividadesHaciendo() {
        return cantidadActividadesHaciendo;
    }

    public int getCantidadActividadesHechas() {
        return cantidadActividadesHechas;
    }

    
    
}
