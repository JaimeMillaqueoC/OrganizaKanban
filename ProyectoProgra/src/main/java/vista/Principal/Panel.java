/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import modelo.Actividad;

/**
 *
 * @author analista.apoyo1
 */
public class Panel extends JPanel{
    
    private String tituloPanel;
    private int cantidadTareas;
    private ArrayList<Actividad> listaActividades;
    
    public Panel(String titulo, int cantidadTareas) {
        this.listaActividades = new ArrayList<>();
        this.cantidadTareas = cantidadTareas;
        this.tituloPanel = titulo;
        iniciarComponentes();
    }

    Panel() {}
   
    private void iniciarComponentes(){
        GridLayout distribucion = new GridLayout(cantidadTareas,1);
        this.setLayout(distribucion);
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), tituloPanel);
        this.setBorder(bordejpanel);
    }
    
    public void agregarLista(Actividad actividad){
        this.listaActividades.add(actividad);
        this.add(actividad);
        this.updateUI();
    }

    public void setListaActividades(ArrayList<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
        for(Actividad act : this.listaActividades) {
            this.add(act);
        }
        this.updateUI();
    }
    
    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }
    
    public String getTitulo(){
        return this.tituloPanel;
    }
}
