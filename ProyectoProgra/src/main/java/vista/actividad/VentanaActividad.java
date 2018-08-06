/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.actividad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import vista.CronometroPomodoro.frameCronometro;
import vista.Principal.Actividad;
import vista.Principal.Panel;

/**
 *
 * @author analista.apoyo1
 */
public class VentanaActividad extends JFrame implements ActionListener {

    private final Actividad actividad;
    private JLabel tituloActividad;
    private JPanel panelSuperior;
    private JPanel PanelCentral;
    private JPanel PanelInferior;
    private JTextArea descripcion;
    private JButton botonGuardar;
    private JButton btnCronometro;
    private JButton btnBorrar;
    private JButton btnColor;
    private Panel panel;
    private Panel panel2;
    private Panel panel3;
    private JComboBox estado;

    public VentanaActividad(Actividad actividad, Panel panel, Panel panel2, Panel panel3) {
        this.actividad = actividad;
        this.panel = panel;
        this.panel2 = panel2;
        this.panel3 = panel3;
        agregarPaneles();
        iniComp();
    }

    private void agregarPaneles() {
        this.panelSuperior = new JPanel(new GridBagLayout());
        this.PanelCentral = new JPanel(new GridBagLayout());
        this.PanelInferior = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        this.tituloActividad = new JLabel(this.actividad.getNombre());
        this.tituloActividad.setFont(new Font("Helvetica", Font.BOLD, 18));
        this.panelSuperior.add(this.tituloActividad);
        this.add(this.panelSuperior, BorderLayout.NORTH);

        c.gridheight = 5;
        this.descripcion = new JTextArea(7, 26);
        this.descripcion.setEditable(true);
        this.descripcion.setText(this.actividad.getDescripcion());
        this.PanelCentral.add(this.descripcion, c);

        c.gridx = 1;
        c.gridheight = 1;
        this.btnCronometro = new JButton("Crono");
        this.btnCronometro.addActionListener(this);
        this.PanelCentral.add(this.btnCronometro, c);

        c.gridy = 1;
        this.btnBorrar = new JButton("Borrar");
        this.btnBorrar.addActionListener(this);
        this.PanelCentral.add(this.btnBorrar, c);

        c.gridy = 2;
        this.estado = new JComboBox();
        this.estado.addItem("Por Hacer");
        this.estado.addItem("Haciendo");
        this.estado.addItem("Hecho");
        this.estado.setSelectedItem(this.panel.getTitulo());
        this.PanelCentral.add(this.estado, c);
        
        c.gridy = 3;
        this.btnColor = new JButton();
        this.btnColor.setBackground(this.actividad.getBackground());
        this.btnColor.setBorderPainted(true);
        this.btnColor.addActionListener(this);
        this.btnColor.setPreferredSize(new Dimension(25, 25));
        this.PanelCentral.add(this.btnColor,c);
        
        c.gridy = 4;
        this.botonGuardar = new JButton("Guardar");
        this.botonGuardar.addActionListener(this);
        this.PanelCentral.add(this.botonGuardar,c);
        
        this.add(this.PanelCentral, BorderLayout.CENTER);
    }
    /**
     * Determina las caracteristicas del JFrame en cuestion.
     */
    private void iniComp() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Editar Actividad");
        this.setSize(400, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.botonGuardar == e.getSource()) {
            this.actividad.setDescripcion(this.descripcion.getText());
            this.moverActividad();
            this.dispose();
        }
        if (this.btnCronometro == e.getSource()) {
            frameCronometro f = new frameCronometro(this.actividad);
        }
        if (this.btnBorrar == e.getSource()) {
            this.borrarActividad();
        }
        if (this.btnColor == e.getSource()) {
            VentanaColor vC = new VentanaColor(this);
        }
    }
     /**
      * Mueve el objeto Actividad entre los paneles principales
      */
    private void moverActividad() {
        if (this.panel2.getTitulo().equals(this.estado.getSelectedItem().toString())) {
            this.panel2.agregarActividad(this.actividad);
            this.borrarActividad();
        }
        if (this.panel3.getTitulo().equals(this.estado.getSelectedItem().toString())) {
            this.panel3.agregarActividad(this.actividad);
            this.borrarActividad();
        }
    }
    /**
     * Borra el objeto Actividad dentro del objeto Panel que se encuentre
     */
    private void borrarActividad() {
        this.panel.remove(this.actividad);
        this.panel.getListaActividades().remove(this.actividad);
        this.panel.updateUI();
        this.dispose();
    }

    public Actividad getActividad() {
        return actividad;
    }

    public JButton getBtnColor() {
        return btnColor;
    }

    public JPanel getPanelCentral() {
        return PanelCentral;
    }
    
    
}
