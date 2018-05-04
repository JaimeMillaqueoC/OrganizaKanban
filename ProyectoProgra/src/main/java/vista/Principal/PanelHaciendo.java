/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jaime
 */
public class PanelHaciendo extends JPanel{
    
    private Image fondo;
    public ArrayList<PAHaciendo> pAHaciendo;
    private int posY;
    private GridBagConstraints gbc;

    public PanelHaciendo() {
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        this.fondo = new ImageIcon("Utilizables\\fondo_madera.jpg").getImage();
        GridBagLayout distribucion = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.setLayout(distribucion);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Haciendo");
        this.setBorder(bordejpanel);
        this.pAHaciendo = new ArrayList<>();
        
    }
    
    public void agregarActividad(PAHaciendo actividad){
        this.pAHaciendo.add(actividad);
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
