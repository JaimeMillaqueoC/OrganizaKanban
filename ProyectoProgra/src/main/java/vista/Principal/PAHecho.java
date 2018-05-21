/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jaime
 */
public class PAHecho extends PanelActividad{
    
    private JLabel lblPorcentaje;
    private JLabel lblRealizado;
    private JLabel lblFinalizada;
    private GridBagConstraints gbc;
    
    public PAHecho(String lblNombreActividad,boolean finalizado) {
        super(lblNombreActividad);
        this.inicializarComponentes();
        if (finalizado) {
            this.agregarEtiqueta();
        }
    }
    
    
    private void inicializarComponentes(){
        GridBagLayout distribucion = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.setLayout(distribucion);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "");
        this.setBorder(bordejpanel);
        this.setBackground(Color.GRAY);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.lblNombreActividad.setForeground(Color.WHITE);
        this.add(this.lblNombreActividad,gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.lblTiempo.setForeground(Color.WHITE);
        this.add(this.lblTiempo,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.lblCronometro.setForeground(Color.WHITE);
        this.add(this.lblCronometro,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.lblPorcentaje = new JLabel("Porcentaje Realizado:");
        this.lblPorcentaje.setForeground(Color.WHITE);
        this.add(this.lblPorcentaje,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.lblRealizado = new JLabel("- - -%");
        this.lblRealizado.setForeground(Color.WHITE);
        this.add(this.lblRealizado,gbc);
    }
    
    private void agregarEtiqueta(){
        this.lblFinalizada = new JLabel("Finalizado Forzado");
        this.lblFinalizada.setForeground(Color.red);
        this.gbc.gridx = 1;
        this.gbc.gridy = 0;
        this.add(this.lblFinalizada,gbc);
    }
}
