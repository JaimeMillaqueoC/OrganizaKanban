/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jaime
 */
public class PAHaciendo extends PanelActividad{
    
    public JButton btnPausar;
    public JButton btnFinalizar;
    public JButton btnReanudar;
    private String hora;
    private String minutos;
    private String segundos;
    
    public PAHaciendo(String lblNombreActividad, String hora, String minutos, String segundos) {
        super(lblNombreActividad);
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        GridBagLayout distribucion = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(distribucion);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "");
        this.setBorder(bordejpanel);
        this.setBackground(Color.GRAY);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        this.lblNombreActividad.setForeground(Color.WHITE);
        this.add(this.lblNombreActividad,gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH ;
        gbc.weighty = 1.0;
        this.lblTiempo.setForeground(Color.WHITE);
        this.add(this.lblTiempo,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        this.lblCronometro.setText(this.hora+" H "+this.minutos+" M "+this.segundos+" S");
        this.lblCronometro.setForeground(Color.WHITE);
        this.add(this.lblCronometro,gbc);
        gbc.weighty = 0;
        
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.btnFinalizar = new JButton("Finalizar");
        this.btnFinalizar.setBackground(Color.LIGHT_GRAY);
        this.add(this.btnFinalizar,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.btnReanudar = new JButton("Reanudar");
        this.btnReanudar.setBackground(Color.LIGHT_GRAY);
        this.btnReanudar.setEnabled(false);
        this.add(this.btnReanudar,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        this.btnPausar = new JButton("Pausar");
        this.btnPausar.setBackground(Color.LIGHT_GRAY);
        this.add(this.btnPausar,gbc);
    }
}
