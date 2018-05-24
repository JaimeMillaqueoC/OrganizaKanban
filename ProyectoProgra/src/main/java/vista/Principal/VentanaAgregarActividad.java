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
    public JButton botonAceptar, botonCancelar;
    private JLabel nombreActividad;
    private JTextField areaNombreActividad;
    private String nombre, tiempo;

    public VentanaAgregarActividad() {
        inicializar();
    }

    private void inicializar() {
        GridLayout distribucion = new GridLayout(2,1);
        this.setLayout(distribucion);
        
        this.panelBoton = new JPanel();
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new FlowLayout());
        this.panelBoton.setSize(50, 350);
        
        this.nombreActividad = new JLabel("Actividad:    ");
        this.areaNombreActividad = new JTextField(21);
        
        this.panelDatos.add(this.nombreActividad);
        this.panelDatos.add(this.areaNombreActividad);
        
        this.botonAceptar = new JButton("Aceptar");
        this.botonCancelar = new JButton("Cancelar");
        this.panelBoton.add(this.add(this.botonAceptar));
        this.panelBoton.add(this.add(this.botonCancelar));
        this.add(this.panelDatos);
        this.add(this.panelBoton);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Editar");
        this.setSize(350, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void extraerDatos() {
        this.nombre = areaNombreActividad.getText();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTiempo() {
        return tiempo;
    }
    
    
}
