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
    private JLabel lblName;
    
    private int segundosActividad;
    private int cantidadPomodorosHechos;
    private int cantidadDescanzosHechos;

    public Actividad(String nombre, String Descripcion, int segundosActividad, int cantidadPomodorosHechos, int cantidadDescanzosHechos) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.segundosActividad = segundosActividad;
        this.cantidadPomodorosHechos = cantidadPomodorosHechos;
        this.cantidadDescanzosHechos = cantidadDescanzosHechos;
        agregarDatos();
    }

    
    
    
    public Actividad(String nombre) {
        this.nombre = nombre;
        this.Descripcion = "";
        agregarDatos();
    }

    private void agregarDatos() {
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "");
        this.setBorder(bordejpanel);
        this.setBackground(Color.LIGHT_GRAY);
        this.lblName = new JLabel(this.nombre);
        this.add(this.lblName);
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

    public JLabel getLblName() {
        return lblName;
    }
    
    public int getSegundosActividad() {
        return segundosActividad;
    }

    public void setSegundosActividad(int segundosActividad) {
        this.segundosActividad = segundosActividad;
    }
    
    public int getCantidadPomodorosHechos() {
        return cantidadPomodorosHechos;
    }

    public void setCantidadPomodorosHechos(int cantidadPomodorosHechos) {
        this.cantidadPomodorosHechos = cantidadPomodorosHechos;
    }

    public int getCantidadDescanzosHechos() {
        return cantidadDescanzosHechos;
    }

    public void setCantidadDescanzosHechos(int cantidadDescanzos) {
        this.cantidadDescanzosHechos = cantidadDescanzos;
    }
    
    
    public void clonar(Actividad act){
        this.Descripcion = act.getDescripcion();
        this.lblName = act.getLblName();
        this.nombre = act.getNombre();
    }

}
