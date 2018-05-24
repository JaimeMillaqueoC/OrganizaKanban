/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Bienvenida;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jaime
 */
public class PanelFondo extends JPanel{
    
    private Image fondo;
    
    public PanelFondo() {
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        this.fondo = new ImageIcon("Utilizables/bienvenido.jpg").getImage();
    }
    
    @Override
     public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
     }
}
