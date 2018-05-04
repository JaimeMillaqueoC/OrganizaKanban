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
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        this.add(this.lblNombreActividad,gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(this.lblTiempo,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.lblCronometro.setText(this.hora+" H: "+this.minutos+" M: "+this.segundos+" S");
        this.add(this.lblCronometro,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.btnFinalizar = new JButton("Finalizar");
        this.add(this.btnFinalizar,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.btnReanudar = new JButton("Reanudar");
        this.add(this.btnReanudar,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.btnPausar = new JButton("Pausar");
        this.btnReanudar.setEnabled(false);
        this.add(this.btnPausar,gbc);
    }
}
