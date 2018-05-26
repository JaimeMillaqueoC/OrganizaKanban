/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import modelo.Actividad;

/**
 *
 * @author analista.apoyo1
 */
public class VistaActividad extends JFrame{
    private final Actividad actividad;
    private JLabel tituloActividad;
    private JPanel panelSuperior,PanelCentral,PanelInferior;
    private JTextArea descripcion;
    private JButton botonGuardar;
    
    public VistaActividad(Actividad actividad) {
        this.actividad = actividad;
        agregarPaneles();
        iniciarVentana();
    }
 private void agregarPaneles() {
    this.panelSuperior = new JPanel(new GridBagLayout());
    this.PanelCentral = new JPanel();
    this.PanelInferior = new JPanel(new GridBagLayout());

    this.tituloActividad = new JLabel(this.actividad.getNombre());
    this.tituloActividad.setFont( new Font( "Helvetica", Font.BOLD, 18 ) );
    this.panelSuperior.add(this.tituloActividad);
    this.add(this.panelSuperior);
     
    this.descripcion = new JTextArea(5, 25);
    this.descripcion.setEditable(true);
    this.PanelCentral.add(this.descripcion);
    this.add(this.PanelCentral);
    
    this.botonGuardar = new JButton("Guardar");
    this.PanelInferior.add(this.botonGuardar);
    this.add(this.PanelInferior);
    }
    private void iniciarVentana() {
        GridLayout distribucion = new GridLayout(3,1);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Agregar Actividad");
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
