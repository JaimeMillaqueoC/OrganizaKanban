/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Estadisticas;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import vista.EditarPerfil.PanelEditar;

/**
 *
 * @author nicolas
 */
public class VentanaOtrasEstadisticas extends JFrame{
    
 private JPanel estadisticas, estadisticas2, estadisticas3;
    
    public VentanaOtrasEstadisticas() {
        this.inicializarComponentes();
        this.panelSuperior();
        this.panelCentral();
        this.panelInferior();
    }
    
    private void panelSuperior(){
        this.estadisticas = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Tus tiempos");
        this.estadisticas.setBorder(bordejpanel);
        this.add(this.estadisticas);
        this.setBackground(Color.gray);
    }
    private void panelCentral(){
        this.estadisticas2 = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Tus Mejoras");
        this.estadisticas2.setBorder(bordejpanel);
        this.add(this.estadisticas2);
        this.setBackground(Color.gray);
    }
    private void panelInferior(){
        this.estadisticas3 = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Tus Proyecciones");
        this.estadisticas3.setBorder(bordejpanel);
        this.add(this.estadisticas3);
        this.setBackground(Color.gray);
    }
    
    private void inicializarComponentes(){
        GridLayout distribucion = new GridLayout(1,3);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Estadisticas");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        
    }
}