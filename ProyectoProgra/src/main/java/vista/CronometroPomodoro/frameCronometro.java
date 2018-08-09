/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.CronometroPomodoro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import vista.Principal.Actividad;
import modelo.Pomodoro;

/**
 *
 * @author nicolas
 */
public class frameCronometro extends JFrame {
    
    public JButton botonContinue, botonPause, botonStart, botonStop;
    private JLabel display, displayDerechoInferior,displayDerechoSuperior, displayIzquierdoSuperior, displayIzquierdoInferior;
    private JPanel panelBotones,panelCronometro,panelDatos, panelDatosIzquierdo,panelDatosIzquierdoSuperior,panelDatosIzquierdoInferior, panelDatosDerecho, panelDatoslDerechoSuperior,panelDatosDerechoInferior;
    private Actividad actividad;
    private Pomodoro cronometro;
    private Object source;
    
    public frameCronometro(Actividad actividad) {
        this.actividad = actividad;
        inicializar();
        cronometro = new Pomodoro(this, actividad);
        this.display.setText(cronometro.getHr()+" : "+cronometro.getMin()+" : "+cronometro.getSeg());
        this.displayIzquierdoSuperior.setText(""+actividad.getCantidadPomodorosHechos());
        this.displayIzquierdoInferior.setText(""+actividad.getCantidadDescanzosHechos());
        this.displayDerechoSuperior.setText(""+cronometro.getMinPomodoro()+" : "+cronometro.getSegPomodoro());
        this.displayDerechoInferior.setText(""+cronometro.getMinDescanso()+" : "+cronometro.getSegDescanso());
    }
    
    private void inicializar() {
        this.panelBotones = new JPanel();
        this.botonStart = new JButton();
        this.botonPause = new JButton();
        this.botonContinue = new JButton();
        this.botonStop = new JButton();
        this.panelCronometro = new JPanel();
        this.display = new JLabel();
        this.displayDerechoInferior = new JLabel();
        this.displayDerechoSuperior = new JLabel();
        this.panelDatos = new JPanel();
        this.panelDatosIzquierdo = new JPanel();
        this.panelDatosIzquierdoSuperior = new JPanel();
        this.panelDatosIzquierdoInferior = new JPanel();
        this.panelDatosDerecho = new JPanel();
        this.panelDatoslDerechoSuperior = new JPanel();
        this.panelDatosDerechoInferior = new JPanel();
        this.displayIzquierdoSuperior = new JLabel();
        this.displayIzquierdoInferior = new JLabel();
        
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cronometro Pomodoro");
        this.setUndecorated(false);

        panelCronometro.setLayout(new BorderLayout());

        botonStart.setText("Iniciar");
        panelBotones.add(botonStart);

        botonPause.setText("Pause");
        botonPause.setEnabled(false);
        panelBotones.add(botonPause);

        botonContinue.setText("Continuar");
        botonContinue.setEnabled(false);
        panelBotones.add(botonContinue);

        botonStop.setText("Detener");
        botonStop.setEnabled(false);
        panelBotones.add(botonStop);
                
        
        botonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        botonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        botonContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcontinueActionPerformed(evt);
            }
        });
        botonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        
        

        display.setFont(new java.awt.Font("Times New Roman", 0, 50));
        display.setHorizontalAlignment(SwingConstants.CENTER);
        panelCronometro.add(display, BorderLayout.CENTER);
        
        displayIzquierdoSuperior.setFont(new java.awt.Font("Times New Roman", 0, 15));
        displayIzquierdoSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        displayIzquierdoInferior.setFont(new java.awt.Font("Times New Roman", 0, 15));
        displayIzquierdoInferior.setHorizontalAlignment(SwingConstants.CENTER);
        panelDatosIzquierdoSuperior.add(displayIzquierdoSuperior, BorderLayout.CENTER);
        panelDatosIzquierdoInferior.add(displayIzquierdoInferior, BorderLayout.CENTER);
        Border bordePanelDatosIzquierdoSuperior = new TitledBorder(new LineBorder(Color.BLACK), "Pomodoros");
        this.panelDatosIzquierdoSuperior.setBorder(bordePanelDatosIzquierdoSuperior);
        Border bordePanelDatosIzquierdoInferior = new TitledBorder(new LineBorder(Color.BLACK), "Descansos");
        this.panelDatosIzquierdoInferior.setBorder(bordePanelDatosIzquierdoInferior);
        GridLayout distribucionPanelIzquierdo = new GridLayout(2, 1);
        panelDatosIzquierdo.setLayout(distribucionPanelIzquierdo);
        panelDatosIzquierdo.add(panelDatosIzquierdoSuperior, BorderLayout.CENTER);
        panelDatosIzquierdo.add(panelDatosIzquierdoInferior, BorderLayout.CENTER);
        
        displayDerechoSuperior.setFont(new java.awt.Font("Times New Roman", 0, 20));
        displayDerechoSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        displayDerechoInferior.setFont(new java.awt.Font("Times New Roman", 0, 20));
        displayDerechoInferior.setHorizontalAlignment(SwingConstants.CENTER);
        panelDatoslDerechoSuperior.add(displayDerechoSuperior, BorderLayout.CENTER);
        panelDatosDerechoInferior.add(displayDerechoInferior, BorderLayout.CENTER);
        Border bordePanelDatosDerechoSuperior = new TitledBorder(new LineBorder(Color.BLACK), "Cronometro Pomodoro");
        this.panelDatoslDerechoSuperior.setBorder(bordePanelDatosDerechoSuperior);
        Border bordePanelDatosDerechoInferior = new TitledBorder(new LineBorder(Color.BLACK), "Cronometro Descanso");
        this.panelDatosDerechoInferior.setBorder(bordePanelDatosDerechoInferior);
        GridLayout distribucionPanelDerecho = new GridLayout(2, 1);
        panelDatosDerecho.setLayout(distribucionPanelDerecho);
        panelDatosDerecho.add(panelDatoslDerechoSuperior, BorderLayout.CENTER);
        panelDatosDerecho.add(panelDatosDerechoInferior, BorderLayout.CENTER);
        
        GridLayout distribucion = new GridLayout(3, 1);
        this.setLayout(distribucion);
        this.add(panelCronometro);
        this.add(panelBotones);
        GridLayout distribucionPanelDatos = new GridLayout(1, 2);
        this.panelDatos.setLayout(distribucionPanelDatos);
        Border bordIzquierdo = new TitledBorder(new LineBorder(Color.BLACK), "Contador");
        this.panelDatosIzquierdo.setBorder(bordIzquierdo);
        Border bordeDerecho = new TitledBorder(new LineBorder(Color.BLACK), "Cronometros");
        this.panelDatosDerecho.setBorder(bordeDerecho);
        this.panelDatos.add(this.panelDatosIzquierdo);
        this.panelDatos.add(this.panelDatosDerecho);
        this.add(panelDatos);
        pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void startActionPerformed(ActionEvent evt) {
        source = evt.getSource();
        if (source == botonStart) {
            cronometro.setSegundos(this.actividad.getSegundosActividad());
            cronometro.createThread();
            cronometro.setLive(true);
            cronometro.setGo(true);
            botonStart.setEnabled(false);
            botonPause.setEnabled(true);
            botonStop.setEnabled(true);
        }
    }

    private void pauseActionPerformed(ActionEvent evt) {
        this.actividad.setSegundosActividad(this.cronometro.getSegundos());
        botonPause.setEnabled(false);
        botonContinue.setEnabled(true);
        cronometro.suspenderThread();
    }

    private void bcontinueActionPerformed(ActionEvent evt) {
        this.cronometro.setSegundos(this.actividad.getSegundosActividad());
        botonPause.setEnabled(true);
        cronometro.continuarThread();
        botonContinue.setEnabled(false);
    }

    private void stopActionPerformed(ActionEvent evt) {
        this.actividad.setSegundosActividad(0);
        this.cronometro.setSegundos(this.actividad.getSegundosActividad());
        botonStart.setEnabled(true);
        botonStop.setEnabled(false);
        botonPause.setEnabled(false);
        cronometro.setLive(false);
        cronometro.setGo(false);
        cronometro.setSegundos(0);
    }
    
    public JLabel getDisplayPrimario() {
        return display;
    }
    
    public JLabel displayPanelDerechoInferior() {
        return displayDerechoInferior;
    }
    
    public JLabel displayPanelDerechoSuperior() {
        return displayDerechoSuperior;
    }
    
    public JLabel displayPanelIzquierdoInferior() {
        return displayIzquierdoInferior;
    }
    
    public JLabel displayPanelIzquierdoSuperior() {
        return displayIzquierdoSuperior;
    }
    

    
    public void guardarFin(Boolean valor, int segundos) {
        this.actividad.setSegundosActividad(segundos);
        this.actividad.setEstado(valor);
    }
}