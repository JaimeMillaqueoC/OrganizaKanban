/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author nicolas
 */
public class Actividad extends JPanel {
    
    private String nombre;
    private String duracion;
    
    private JLabel name, duration;
    
    public Actividad() {
    
    }

    public Actividad(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
        agregarDatos();
    }
    
    private void incializar() {
        this.setBackground(Color.gray);
    }

    private void agregarDatos() {       
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), this.nombre);
        this.setBorder(bordejpanel);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }    
}
