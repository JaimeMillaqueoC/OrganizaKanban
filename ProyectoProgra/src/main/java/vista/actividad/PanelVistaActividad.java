/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.actividad;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import utilidades.Ruta;

/**
 *
 * @author Jaime
 */
public class PanelVistaActividad extends JPanel{
    
    private final Ruta ruta = new Ruta();
    private final Image fondo = new ImageIcon(this.ruta.FONDO_PANEL_ACTIVIDAD).getImage();
    
    public PanelVistaActividad() {
        setLayout(new GridBagLayout());
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
}
