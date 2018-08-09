/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.util.Date;
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
    private final Color colorPre = Color.LIGHT_GRAY;;
    private Color color;
    
    private int segundosActividad;
    private int cantidadPomodorosHechos;
    private int cantidadDescanzosHechos;
    private boolean estado;
    private Date fecha;

    public Actividad() {
        agregarDatos();
    }

    
    public Actividad(String nombre) {
        this.nombre = nombre;
        this.estado = false;
        this.fecha = new Date();
        this.segundosActividad = 6897;
        this.Descripcion = "";
        agregarDatos();
    }

    private void agregarDatos() {
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "");
        this.setBorder(bordejpanel);
        this.pintarActividad();
        this.lblName = new JLabel(this.nombre);
        this.add(this.lblName);
    }
    
    private void pintarActividad(){
        if (this.color != null) {
            this.setBackground(this.color);
        }else
            this.setBackground(this.colorPre);
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

    public void setLblName(String lblName) {
        this.lblName.setText(lblName);
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

    public void setColor(Color color) {
        this.color = color;
        if (color != null) {
            this.setBackground(this.color);
        }
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    

    public Color getColorPre() {
        return colorPre;
    }

    public Color getColor(){
        return color;
    }
    /**
     * Comprara dos objetos Actividad, el actual y uno que recibe como parametro,
     * 
     * @param actividad
     * @return 
     */
    public boolean equals(Actividad actividad) {
        if (this.nombre.equals(actividad.getNombre())) {
            if (this.Descripcion.equals(actividad.getDescripcion())) {
                if (this.getBackground().getRGB() == actividad.getBackground().getRGB()) {
                    if (this.segundosActividad == actividad.getSegundosActividad()) {
                        if (this.cantidadPomodorosHechos == actividad.getCantidadPomodorosHechos()) {
                            if(this.cantidadDescanzosHechos == actividad.getCantidadDescanzosHechos()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * clona un objeto Actividad dentro de este objeto Actividad
     * @param act 
     */
    public void clonar(Actividad act){
        this.nombre = act.getNombre();
        this.Descripcion = act.getDescripcion();
        this.setColor(act.getBackground());
        this.lblName.setText(this.nombre);
        this.segundosActividad = act.getSegundosActividad();
        this.cantidadPomodorosHechos = act.getCantidadPomodorosHechos();
        this.cantidadDescanzosHechos = act.getCantidadDescanzosHechos();
    }
    
}
