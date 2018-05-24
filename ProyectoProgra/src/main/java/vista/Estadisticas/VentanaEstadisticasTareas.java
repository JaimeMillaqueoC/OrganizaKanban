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

/**
 *
 * @author nicolas
 */
public class VentanaEstadisticasTareas extends JFrame{
    
    private JPanel estadisticas, estadisticas2, estadisticas3;
    
    public VentanaEstadisticasTareas() {
        this.inicializarComponentes();
        this.panelSuperior();
        this.panelCentral();
        this.panelInferior();
    }
    
    private void panelSuperior(){
        this.estadisticas = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Datos");
        this.estadisticas.setBorder(bordejpanel);
        this.add(this.estadisticas);
    }
    private void panelCentral(){
        this.estadisticas2 = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Graficos");
        this.estadisticas2.setBorder(bordejpanel);
        this.add(this.estadisticas2);
    }
    private void panelInferior(){
        this.estadisticas3 = new JPanel();
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Proyecciones");
        this.estadisticas3.setBorder(bordejpanel);
        this.add(this.estadisticas3);
    }
    
    private void inicializarComponentes(){
        GridLayout distribucion = new GridLayout(3,1);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Estadisticas");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        
    }
    
}
