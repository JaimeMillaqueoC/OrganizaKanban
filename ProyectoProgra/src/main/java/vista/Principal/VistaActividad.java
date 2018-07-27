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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import vista.CronometroPomodoro.frameCronometro;

/**
 *
 * @author analista.apoyo1
 */
public class VistaActividad extends JFrame implements ActionListener{
    private final Actividad actividad;
    private JLabel tituloActividad, lblTiempo;
    private JPanel panelSuperior,PanelCentral,PanelInferior;
    private JTextArea descripcion;
    private JButton botonGuardar, btnCronometro, btnBorrar;
    private Panel panel;
    
    public VistaActividad(Actividad actividad, Panel panel) {
        this.actividad = actividad;
        this.panel = panel;
        agregarPaneles();
        iniciarVentana();
    }
 private void agregarPaneles() {
    this.panelSuperior = new JPanel(new GridBagLayout());
    this.PanelCentral = new JPanel(new GridBagLayout());
    this.PanelInferior = new JPanel(new GridBagLayout());
    
     GridBagConstraints c = new GridBagConstraints();

    this.tituloActividad = new JLabel(this.actividad.getNombre());
    this.tituloActividad.setFont( new Font( "Helvetica", Font.BOLD, 18 ) );
    this.panelSuperior.add(this.tituloActividad);
    this.add(this.panelSuperior,BorderLayout.NORTH);
    
    c.gridheight = 2;
    this.descripcion = new JTextArea(5, 25);
    this.descripcion.setEditable(true);
    this.descripcion.setText(this.actividad.getDescripcion());
    this.PanelCentral.add(this.descripcion,c);
    
    c.gridx = 1;
    c.gridheight = 1;
    this.btnCronometro = new JButton("Crono");
    this.btnCronometro.addActionListener(this);
    this.PanelCentral.add(this.btnCronometro,c);
    
    c.gridy = 1;
    this.btnBorrar = new JButton("Borrar");
    this.btnBorrar.addActionListener(this);
    this.PanelCentral.add(this.btnBorrar,c);
    
    c.gridx = 0;
    c.gridy = 2;
    this.lblTiempo = new JLabel();
    this.PanelCentral.add(this.lblTiempo,c);
    
    this.add(this.PanelCentral,BorderLayout.CENTER);
    
    this.botonGuardar = new JButton("Guardar");
    this.botonGuardar.addActionListener(this);
    this.PanelInferior.add(this.botonGuardar);
    this.add(this.PanelInferior,BorderLayout.SOUTH);
    }
    private void iniciarVentana() {
//        GridLayout distribucion = new GridLayout(3,1);
//        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Agregar Actividad");
        this.setSize(400, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.botonGuardar == e.getSource()) {
            this.actividad.setDescripcion(this.descripcion.getText());
            this.dispose();
        }
        if (this.btnCronometro == e.getSource()) {
            frameCronometro f = new frameCronometro(this.actividad);
        }
        if (this.btnBorrar == e.getSource()) {
            this.panel.remove(this.actividad);
            this.panel.getListaActividades().remove(this.actividad);
            this.panel.updateUI();
            this.dispose();
        }
    }

    public void setLblTiempo(String Tiempo) {
        this.lblTiempo.setText(Tiempo);
        this.PanelCentral.updateUI();
    }
    
}