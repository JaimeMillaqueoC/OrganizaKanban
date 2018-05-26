/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
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
    
    private JPanel panelTitulo,panelDatos, panelBoton;
    public JButton botonAceptar;
    private JLabel nombreActividad;
    public JTextField areaNombreActividad;
    private String nombre;
    public VentanaAgregarActividad() {
        inicializar();
    }

    private void inicializar() {
        GridLayout distribucion = new GridLayout(3,1);
        this.setLayout(distribucion);
        
        this.panelTitulo = new JPanel(new GridBagLayout());
        this.panelBoton = new JPanel(new GridBagLayout());
        this.panelDatos = new JPanel(new GridBagLayout());
        
        this.nombreActividad = new JLabel("Agregar Actividad");
        this.nombreActividad.setFont( new Font( "Helvetica", Font.BOLD, 18 ) );
        this.botonAceptar = new JButton("Aceptar");
        this.areaNombreActividad = new JTextField(20);
        
        this.panelTitulo.add(this.nombreActividad);
        this.panelDatos.add(this.areaNombreActividad);
        this.panelBoton.add(this.botonAceptar);
        
        this.add(this.panelTitulo);
        this.add(this.panelDatos);
        this.add(this.panelBoton);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Agregar");
        this.setSize(350, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void extraerDatos() {
        this.nombre = areaNombreActividad.getText();
    }

    public String getNombre() {
        return nombre;
    }

    public void setAreaNombreActividad(String areaNombreActividad) {
        this.areaNombreActividad.setText(areaNombreActividad);
    }
    
    
}
