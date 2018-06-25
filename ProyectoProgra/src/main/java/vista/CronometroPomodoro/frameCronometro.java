/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.CronometroPomodoro;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Pomodoro;

/**
 *
 * @author nicolas
 */
public class frameCronometro extends JFrame {
    
    private JButton bContinue, bPause, bStart, bStop;
    private JLabel display;
    private JPanel jPanel1,jPanel2;
    
    Pomodoro cronometro;
    Object source;
    
    public frameCronometro() {
        inicializar();
        cronometro = new Pomodoro(this);
    }
    
    private void inicializar() {
        jPanel1 = new JPanel();
        bStart = new JButton();
        bPause = new JButton();
        bContinue = new JButton();
        bStop = new JButton();
        jPanel2 = new JPanel();
        display = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro Pomodoro");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 45));

        bStart.setText("Iniciar");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        jPanel1.add(bStart);

        bPause.setText("Pause");
        bPause.setEnabled(false);
        bPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        jPanel1.add(bPause);

        bContinue.setText("Continuar");
        bContinue.setEnabled(false);
        bContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcontinueActionPerformed(evt);
            }
        });
        jPanel1.add(bContinue);

        bStop.setText("Detener");
        bStop.setEnabled(false);
        bStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        jPanel1.add(bStop);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 130));
        jPanel2.setLayout(new java.awt.BorderLayout());

        display.setFont(new java.awt.Font("Times New Roman", 0, 50)); // NOI18N
        display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        display.setText("0 : 0 : 0");
        jPanel2.add(display, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void startActionPerformed(ActionEvent evt) {
        source = evt.getSource();
        if (source == bStart) {
            cronometro.createThread();
            cronometro.setLive(true);
            cronometro.setGo(true);
            bStart.setEnabled(false);
            bPause.setEnabled(true);
            bStop.setEnabled(true);
        }
    }

    private void pauseActionPerformed(ActionEvent evt) {
        bPause.setEnabled(false);
        bContinue.setEnabled(true);
        cronometro.suspenderThread();
    }

    private void bcontinueActionPerformed(ActionEvent evt) {
        bPause.setEnabled(true);
        cronometro.continuarThread();
        bContinue.setEnabled(false);
    }

    private void stopActionPerformed(ActionEvent evt) {
        bStart.setEnabled(true);
        bStop.setEnabled(false);
        bPause.setEnabled(false);
        cronometro.setLive(false);
        cronometro.setGo(false);
        cronometro.setSegundos(0);
    }
    
    public JLabel getDisplay() {
        return display;
    }
    
    public void setDisplay(JLabel display) {
        this.display = display;
    }
}