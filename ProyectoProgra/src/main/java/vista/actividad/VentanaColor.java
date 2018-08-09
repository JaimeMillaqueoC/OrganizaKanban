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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jaime
 */
public class VentanaColor extends JFrame implements ChangeListener, ActionListener {

    private JColorChooser jcc;
    private JButton btnEstablecer;
    private JButton btnCancelar;
    private JButton btnPredeterminado;
    private VentanaActividad vActividad;

    public VentanaColor(VentanaActividad vActividad) {
        this.jcc = new JColorChooser();
        this.vActividad = vActividad;
        this.iniComp();
    }

    private void iniComp() {
//        jcc.getSelectionModel().addChangeListener(this.getListeners());
        
        this.setLayout(new BorderLayout());
        this.add(jcc, BorderLayout.CENTER);
        
        JPanel botones = new JPanel(new FlowLayout());
        
        this.btnEstablecer = new JButton("Establecer");
        this.btnEstablecer.setBackground(Color.LIGHT_GRAY);
        this.btnEstablecer.addActionListener(this);
        
        this.btnCancelar = new JButton("Cancelar");
        this.btnCancelar.addActionListener(this);
        this.btnCancelar.setBackground(Color.LIGHT_GRAY);
        
        this.btnPredeterminado = new JButton("Predeterminado");
        this.btnPredeterminado.addActionListener(this);
        this.btnPredeterminado.setBackground(Color.LIGHT_GRAY);
        
        botones.add(this.btnCancelar);
        botones.add(this.btnPredeterminado);
        botones.add(this.btnEstablecer);
        
        this.add(botones, BorderLayout.SOUTH);
        jcc.setMaximumSize(new Dimension(100,100));
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Cambiar Color");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.btnCancelar == e.getSource()) {
            this.dispose();
        }
        if (this.btnEstablecer == e.getSource()) {
            this.vActividad.getActividad().setColor(this.jcc.getColor());
            this.vActividad.getActividad().updateUI();
            this.vActividad.getBtnColor().setBackground(this.jcc.getColor());
            this.vActividad.getPanelCentral().updateUI();
            this.dispose();
        }
        if (this.btnPredeterminado == e.getSource()) {
            this.vActividad.getBtnColor().setBackground(this.vActividad.getActividad().getColorPre());
            this.vActividad.getPanelCentral().updateUI();
            this.vActividad.getActividad().setBackground(this.vActividad.getActividad().getColorPre());
            this.vActividad.getActividad().setColor(null);
            this.vActividad.getActividad().updateUI();
            this.dispose();
        }
    }

}
