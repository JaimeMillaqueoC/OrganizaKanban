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
        this.name = new JLabel(nombre);
        this.duration = new JLabel(duracion);
        GridLayout distribucion = new GridLayout(3,1);
        this.setLayout(distribucion);
        this.add(name);
        this.add(duration);
        this.setBackground(Color.red);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }    
}
