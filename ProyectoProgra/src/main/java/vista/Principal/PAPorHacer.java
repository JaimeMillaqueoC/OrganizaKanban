/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Jaime
 */
public class PAPorHacer extends JPanel{
    
    public JButton btnAgregar;
    public JButton btnQuitar;
    private JTextField tfNombreActividad;
    private JLabel lblTiempo;
    private JComboBox cbHora1;
    private JLabel lblHora;
    private JComboBox cbMinutos1;
    private JLabel lblMinutos;
    private JComboBox cbSegundos1;
    private JLabel lblSegundos;

    public PAPorHacer() {
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        GridBagLayout distribucion = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(distribucion);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "");
        this.setBorder(bordejpanel);
        this.setBackground(Color.GRAY);
        
        Dimension d = new Dimension(150, 25);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;

        this.tfNombreActividad = new JTextField("");
        PromptSupport.setPrompt("Nombre_Actividad", this.tfNombreActividad);
        this.add(this.tfNombreActividad,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        
        this.lblTiempo = new JLabel("Tiempo: ");
        this.lblTiempo.setForeground(Color.WHITE);
        this.add(this.lblTiempo,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.cbHora1 = new JComboBox();
        agregarItemsAComboBox(this.cbHora1);
        this.cbHora1.setBackground(Color.LIGHT_GRAY);
        this.add(this.cbHora1,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        this.lblHora = new JLabel("HH");
        this.lblHora.setForeground(Color.WHITE);
        this.add(this.lblHora,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        this.cbMinutos1 = new JComboBox();
        agregarItemsAComboBox(this.cbMinutos1);
        this.cbMinutos1.setBackground(Color.LIGHT_GRAY);
        this.add(this.cbMinutos1,gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        this.lblMinutos = new JLabel("MM");
        this.lblMinutos.setForeground(Color.WHITE);
        this.add(this.lblMinutos,gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 1;
        this.cbSegundos1 = new JComboBox();
        agregarItemsAComboBox(this.cbSegundos1);
        this.cbSegundos1.setBackground(Color.LIGHT_GRAY);
        this.add(this.cbSegundos1,gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 1;
        this.lblSegundos = new JLabel("SS");
        this.lblSegundos.setForeground(Color.WHITE);
        this.add(this.lblSegundos,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        this.btnQuitar = new JButton("Quitar (-)");
        this.btnQuitar.setBackground(Color.LIGHT_GRAY);
        this.add(this.btnQuitar,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        this.btnAgregar = new JButton("Iniciar (+)");
        this.btnAgregar.setBackground(Color.LIGHT_GRAY);
        this.add(this.btnAgregar,gbc);
        
    }
    private void agregarItemsAComboBox(JComboBox jc){
        for (int i = 0; i < 60; i++) {
            jc.addItem(i);
        }
    }

    public JTextField getTfNombreActividad() {
        return tfNombreActividad;
    }

    public JLabel getLblTiempo() {
        return lblTiempo;
    }

    public JComboBox getCbHora1() {
        return cbHora1;
    }

    public JLabel getLblHora() {
        return lblHora;
    }

    public JComboBox getCbMinutos1() {
        return cbMinutos1;
    }

    public JLabel getLblMinutos() {
        return lblMinutos;
    }

    public JComboBox getCbSegundos1() {
        return cbSegundos1;
    }

    public JLabel getLblSegundos() {
        return lblSegundos;
    }
    
}
