/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.Principal.Panel;

/**
 *
 * @author analista.apoyo1
 */
public class GestionarActividades {
    
    private Actividad actividad;
    private Panel panel1,panel2,panel3;

    public GestionarActividades(Panel panel1, Panel panel2, Panel panel3) {
        this.panel1 = panel1;
        this.panel2 = panel2;
        this.panel3 = panel3;
    }
    
    public Panel agregarActividadPanelPorHacer(){
        this.panel1.add(this.actividad);
        return this.panel1;
    }
    public Panel agregarActividadPanelHaciendo(){
        this.panel2.add(this.actividad);
        return this.panel2;
    }
    public Panel agregarActividadPanelHecho(){
        this.panel3.add(this.actividad);
        return this.panel3;
    }
    
    public void agregarActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    
    
}
