/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import static jdk.nashorn.internal.objects.NativeRegExp.test;

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
        agregarPaneles();
    }
    
    private void agregarPaneles(){
        JPanel prueba1 = new JPanel();
        prueba1.setBackground(Color.yellow);
        JPanel prueba2 = new JPanel();
        prueba2.setBackground(Color.blue);
        JPanel prueba3 = new JPanel();
        prueba3.setBackground(Color.red);
        JPanel prueba4 = new JPanel();
        prueba4.setBackground(Color.black);
        JPanel prueba5 = new JPanel();
        prueba5.setBackground(Color.yellow);
        JPanel prueba6 = new JPanel();
        prueba6.setBackground(Color.blue);
        JPanel prueba7 = new JPanel();
        prueba7.setBackground(Color.red);
        JPanel prueba8 = new JPanel();
        prueba8.setBackground(Color.black);
        
        this.add(prueba1);
        this.add(prueba2);
        this.add(prueba3);
        this.add(prueba4);
        this.add(prueba5);
        this.add(prueba6);
        this.add(prueba7);
        this.add(prueba8);
    }
    
    private void iniciarComponentes(){
        GridLayout distribucion = new GridLayout(cantidadTareas,1);
        this.setLayout(distribucion);
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), tituloPanel);
        this.setBorder(bordejpanel);
    }
}
