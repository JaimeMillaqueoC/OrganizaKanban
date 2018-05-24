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
public class VentanaContacto extends JFrame{
    
private JPanel fotos, datos, codigoQR;
    
    public VentanaContacto() {
        this.inicializarComponentes();
        this.panelSuperior();
        this.panelCentral();
        this.panelInferior();
    }
    
    private void panelSuperior(){
        this.fotos = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Tus tiempos");
        this.fotos.setBorder(bordejpanel);
        this.add(this.fotos);
        this.setBackground(Color.gray);
    }
    private void panelCentral(){
        this.datos = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Tus Mejoras");
        this.datos.setBorder(bordejpanel);
        this.add(this.datos);
        this.setBackground(Color.gray);
    }
    private void panelInferior(){
        this.codigoQR = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Tus Proyecciones");
        this.codigoQR.setBorder(bordejpanel);
        this.add(this.codigoQR);
        this.setBackground(Color.gray);
    }
    
    private void inicializarComponentes(){
        GridLayout distribucion = new GridLayout(3,1);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Contacto");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        
    }
}