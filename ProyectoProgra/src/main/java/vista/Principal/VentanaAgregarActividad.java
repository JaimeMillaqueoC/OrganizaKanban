/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author nicolas
 */
public class VentanaAgregarActividad extends JFrame{
    
    private JPanel panelDatos, panelBoton;
    public JButton botonAceptar;
    private JLabel nombreActividad, duracionMinutosActividad, descripcionActividiad;
    private JTextField areaNombreActividad,areaDuracionMinutos,areadDescripcionActividad;

    public VentanaAgregarActividad() {
        inicializar();
    }

    private void inicializar() {
        GridLayout distribucion = new GridLayout(2,1);
        this.setLayout(distribucion);
        
        this.panelBoton = new JPanel();
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new FlowLayout());

        
        this.nombreActividad = new JLabel("Actividad:    ");
        this.duracionMinutosActividad = new JLabel("Minutos:      ");
        this.descripcionActividiad = new JLabel("Descripcion: ");
        this.areaNombreActividad = new JTextField(20);
        this.areaDuracionMinutos = new JTextField(20);
        this.areadDescripcionActividad = new JTextField(20);
        
        this.panelDatos.add(this.nombreActividad);
        this.panelDatos.add(this.areaNombreActividad);
        
        this.panelDatos.add(this.duracionMinutosActividad);
        this.panelDatos.add(this.areaDuracionMinutos);
        
        this.panelDatos.add(this.descripcionActividiad);
        this.panelDatos.add(this.areadDescripcionActividad);
        
        this.botonAceptar = new JButton("Aceptar");
        this.panelBoton.add(this.add(this.botonAceptar));
        this.add(this.panelDatos);
        this.add(this.panelBoton);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Editar");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    
}
