/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.proyectofp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Jaime
 */
public class VentanaPrincipal extends JFrame{
    
    private PanelPerfil pPerfil;
    private PanelPorHacer pPorHacer;
    private PanelHaciendo pHaciendo;
    private PanelHecho pHecho;
    
    public VentanaPrincipal() {
        this.inicializarComponentes();
        
         
    }
    
    private void inicializarComponentes(){
        GridLayout distribucion = new GridLayout(1,4);
        this.setLayout(distribucion);
        
        this.pPerfil = new PanelPerfil();
        this.add(this.pPerfil);
        
        this.pPorHacer = new PanelPorHacer();
        this.add(this.pPorHacer);
        
        this.pHaciendo = new PanelHaciendo();
        this.add(this.pHaciendo);
        
        this.pHecho = new PanelHecho();
        this.add(this.pHecho);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("OrganizaUfro");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        
        Dimension d = new Dimension(this.getWidth(),this.getHeight());
        
        this.setMinimumSize(d);
        this.setVisible(true);
       
    }
    
}
