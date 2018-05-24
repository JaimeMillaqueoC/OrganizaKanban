/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author analista.apoyo1
 */
public class Panel extends JPanel{
    
    private String tituloPanel;
    private int cantidadTareas;
    
    public Panel(String titulo, int cantidadTareas) {
        this.cantidadTareas = cantidadTareas;
        this.tituloPanel = titulo;
        iniciarComponentes();
    }
   
    private void iniciarComponentes(){
        GridLayout distribucion = new GridLayout(cantidadTareas,1);
        this.setLayout(distribucion);
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), tituloPanel);
        this.setBorder(bordejpanel);
    }
}
