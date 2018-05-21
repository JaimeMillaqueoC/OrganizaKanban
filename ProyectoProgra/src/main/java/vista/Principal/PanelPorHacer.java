/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.FIRST_LINE_START;
import static java.awt.GridBagConstraints.NORTH;
import static java.awt.GridBagConstraints.PAGE_START;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jaime
 */
public class PanelPorHacer extends JPanel{
    
    private Image fondo;
    public ArrayList<PAPorHacer> pAPorHacer;
    private int posY;
    private GridBagConstraints gbc;
    
    public PanelPorHacer() {
        inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        this.fondo = new ImageIcon("Utilizables\\fondo_madera.jpg").getImage();
        GridBagLayout distribucion = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.setLayout(distribucion);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Por Hacer");
        this.setBorder(bordejpanel);
        this.pAPorHacer = new ArrayList<>();
//        this.gbc.weighty = 1.0;
        this.gbc.anchor = NORTH;
        
        
    }
    
    public void agregarActividad(PAPorHacer actividad){
        this.pAPorHacer.add(actividad);
        this.gbc.gridy = this.posY;
        this.add(actividad,gbc);
        this.posY++;
        
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

}
    

