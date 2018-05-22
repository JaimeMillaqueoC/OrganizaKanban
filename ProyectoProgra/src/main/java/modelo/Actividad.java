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
    private Double duracion;
    private String descripcion;
    
    private JLabel name, description, duration;
    

    public Actividad() {
        incializar();
    }

    public Actividad(String nombre, Double duracion, String Descripcion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.descripcion = Descripcion;
        agregarDatos();
    }
    
    private void incializar() {
        this.setBackground(Color.blue);
    }

    private void agregarDatos() {
        this.name = new JLabel(nombre);
        this.description = new JLabel(descripcion);
        this.duration = new JLabel(duracion.toString());
        GridLayout distribucion = new GridLayout(3,1);
        this.setLayout(distribucion);
        this.add(name);
        this.add(description);
        this.add(duration);
        this.setBackground(Color.red);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }    
}
