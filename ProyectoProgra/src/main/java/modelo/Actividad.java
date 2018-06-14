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
    private String Descripcion;
    private String duracion;

    private JLabel name;
    
    public Actividad(){}
  
    public Actividad(String nombre) {
        this.nombre = nombre;
        agregarDatos();
    }

    private void agregarDatos() {
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "");
        this.setBorder(bordejpanel);
        this.setBackground(Color.LIGHT_GRAY);
        this.name = new JLabel(this.nombre);
        this.add(this.name);
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    

}
