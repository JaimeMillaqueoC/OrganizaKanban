/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.proyectofp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import utilidades.IC;

/**
 *
 * @author Jaime
 */
public class PanelPorHacer extends JPanel implements IC{
    
    private Image fondo;

    public PanelPorHacer() {
        inicializarComponentes();
    }
    
    
    
    @Override
    public void inicializarComponentes() {
        this.fondo = new ImageIcon("Utilizables\\fondo_azul.jpg").getImage();
        FlowLayout distribucion = new FlowLayout();
        this.setLayout(distribucion);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Por Hacer");
        this.setBorder(bordejpanel);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
    
}
