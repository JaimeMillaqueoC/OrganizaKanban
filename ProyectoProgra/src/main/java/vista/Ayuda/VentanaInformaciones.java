/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Ayuda;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author nicolas
 */
public class VentanaInformaciones extends JFrame{
    
private JPanel Indice, enlaces;
    
    public VentanaInformaciones() {
        this.inicializarComponentes();
        this.panelSuperior();
        this.panelCentral();
    }
    
    private void panelSuperior(){
        this.Indice = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Tus tiempos");
        this.Indice.setBorder(bordejpanel);
        this.add(this.Indice);
        this.setBackground(Color.gray);
    }
    private void panelCentral(){
        this.enlaces = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Tus Mejoras");
        this.enlaces.setBorder(bordejpanel);
        this.add(this.enlaces);
        this.setBackground(Color.gray);
    }
    
    private void inicializarComponentes(){
        GridLayout distribucion = new GridLayout(2,1);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Informaciones");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        
    }
}
