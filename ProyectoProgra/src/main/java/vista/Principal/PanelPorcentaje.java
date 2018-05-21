/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jaime
 */
public class PanelPorcentaje extends JPanel{
    private JLabel lblTareasRealizadas;
    private JLabel lblNumeroTR;
    private JLabel lblPorcentaje;
    private JLabel lblPorcenRealizacion;

    public PanelPorcentaje() {
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        GridBagLayout distribucion = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(distribucion);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "");
        this.setBorder(bordejpanel);
        this.setBackground(Color.GRAY);
        
        gbc.gridx = 0 ;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.lblTareasRealizadas = new JLabel("Tareas Realizadas:");
        this.lblTareasRealizadas.setForeground(Color.WHITE);
        this.add(this.lblTareasRealizadas,gbc);
        
        gbc.gridx = 0 ;
        gbc.gridy = 1;
        this.lblPorcenRealizacion = new JLabel("¨Porcentaje de realizacion:");
        this.lblPorcenRealizacion.setForeground(Color.WHITE);
        this.add(this.lblPorcenRealizacion,gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 2 ;
        gbc.gridy = 0;
        this.lblNumeroTR = new JLabel("---");
        this.lblNumeroTR.setForeground(Color.WHITE);
        this.add(this.lblNumeroTR,gbc);
        
        
        gbc.gridx = 2 ;
        gbc.gridy = 1;
        this.lblPorcentaje = new JLabel("---%");
        this.lblPorcentaje.setForeground(Color.WHITE);
        this.add(this.lblPorcentaje,gbc);
    }
}
