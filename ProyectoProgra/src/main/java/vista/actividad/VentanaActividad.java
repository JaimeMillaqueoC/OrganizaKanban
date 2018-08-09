/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.actividad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import utilidades.Ruta;
import vista.CronometroPomodoro.FrameCronometro;
import vista.principal.Actividad;
import vista.principal.Panel;

/**
 *
 * @author analista.apoyo1
 */
public class VentanaActividad extends JFrame implements ActionListener, MouseListener {

    private final Actividad actividad;
    private JTextField tituloActividad;
    private PanelVistaActividad PanelCentral;
    private JTextArea descripcion;
    private JButton botonGuardar;
    private JButton btnCronometro;
    private JButton btnBorrar;
    private JButton btnColor;
    private Panel panel;
    private Panel panel2;
    private Panel panel3;
    private JComboBox estado;
    private final Ruta ruta = new Ruta();

    public VentanaActividad(Actividad actividad, Panel panel, Panel panel2, Panel panel3) {
        this.actividad = actividad;
        this.panel = panel;
        this.panel2 = panel2;
        this.panel3 = panel3;
        agregarPaneles();
        iniComp();
    }

    private void agregarPaneles() {
        this.setLayout(new GridLayout());
        this.PanelCentral = new PanelVistaActividad();

        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        c.weighty = 1.0;
        this.tituloActividad = new JTextField(this.actividad.getNombre());
        this.tituloActividad.setFont(new Font("Helvetica", Font.BOLD, 18));
        this.tituloActividad.setOpaque(false);
        this.tituloActividad.setEditable(false);
        this.tituloActividad.setBorder(null);
        this.tituloActividad.addMouseListener(this);
        this.tituloActividad.setForeground(Color.CYAN);
        this.tituloActividad.setToolTipText("Click para editar");
        this.PanelCentral.add(this.tituloActividad, c);
//        c.weighty = 0.0;

        c.gridheight = 4;
        c.gridwidth = 1;
        c.gridy = 1;
        c.weighty=1.0;
        c.fill = GridBagConstraints.BOTH;
        this.descripcion = new JTextArea(7, 26);
        this.descripcion.setEditable(true);
        this.descripcion.setText(this.actividad.getDescripcion());
        this.descripcion.setToolTipText("Descripcion de la actividad");
        this.PanelCentral.add(this.descripcion, c);
        c.fill = GridBagConstraints.NONE;
        c.weighty=0.0;

        c.gridx = 1;
        c.gridheight = 1;
//        c.anchor = GridBagConstraints.LINE_END;
        this.btnCronometro = new JButton();
        this.colocarIconoAlBoton(this.btnCronometro, this.ruta.IMAGEN_CRONOMETRO);
        this.btnCronometro.addActionListener(this);
        this.btnCronometro.setToolTipText("Pomodoro");
        this.PanelCentral.add(this.btnCronometro, c);

        c.gridy = 2;
        this.btnBorrar = new JButton();
        this.colocarIconoAlBoton(this.btnBorrar, this.ruta.IMAGEN_BORRAR);
        this.btnBorrar.addActionListener(this);
        this.btnBorrar.setToolTipText("Borrar Actividad");
        this.PanelCentral.add(this.btnBorrar, c);

        c.gridy = 3;
        this.estado = new JComboBox();
        this.estado.addItem("Por Hacer");
        this.estado.addItem("Haciendo");
        this.estado.addItem("Hecho");
        this.estado.setSelectedItem(this.panel.getTitulo());
        this.estado.setToolTipText("Mover Actividad");
        this.PanelCentral.add(this.estado, c);

        c.gridy = 4;
//        c.weightx = 1.0;
//        c.fill = GridBagConstraints.VERTICAL;
        this.btnColor = new JButton();
        this.btnColor.setBackground(this.actividad.getBackground());
        this.btnColor.setBorderPainted(true);
        this.btnColor.addActionListener(this);
        this.btnColor.setPreferredSize(new Dimension(25, 25));
        this.btnColor.setToolTipText("Cambiar de color");
        this.PanelCentral.add(this.btnColor, c);
        c.weightx = 0.0;
//        c.fill = GridBagConstraints.NONE;
        
        c.gridy = 5;
        this.botonGuardar = new JButton();
        this.colocarIconoAlBoton(this.botonGuardar, this.ruta.IMAGEN_GUARDAR);
        this.botonGuardar.addActionListener(this);
        this.botonGuardar.setToolTipText("Guardar Cambios");
        this.PanelCentral.add(this.botonGuardar, c);

        this.add(this.PanelCentral, BorderLayout.CENTER);
    }

    /**
     * Determina las caracteristicas del JFrame en cuestion.
     */
    private void iniComp() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Editar Actividad");
        this.setSize(450, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.botonGuardar == e.getSource()) {
            this.actividad.setDescripcion(this.descripcion.getText());
            this.actividad.setNombre(this.tituloActividad.getText());
            this.actividad.setLblName(this.tituloActividad.getText());
            this.moverActividad();
            this.dispose();
        }
        if (this.btnCronometro == e.getSource()) {
            FrameCronometro f = new FrameCronometro(this.actividad);
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
    private void colocarIconoAlBoton(JButton btn,String ruta){
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage());
        btn.setIcon(icono);
        btn.setBackground(Color.orange);
        btn.setBorder(null);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.tituloActividad == e.getSource()) {
            this.tituloActividad.setOpaque(true);
            this.tituloActividad.setEditable(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
