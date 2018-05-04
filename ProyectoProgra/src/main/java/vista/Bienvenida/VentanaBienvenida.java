/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Bienvenida;

import com.sun.awt.AWTUtilities;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import vista.Principal.VentanaPrincipal;

/**
 *
 * @author Jaime
 */
public class VentanaBienvenida extends JFrame {

    private PanelFondo pFondo;

    public VentanaBienvenida() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.pFondo = new PanelFondo();
        this.add(pFondo);

        this.setTitle("OrganizaUfro");
        this.setUndecorated(true);
        this.setSize(600, 600);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, this.getSize().width, this.getSize().height);
        AWTUtilities.setWindowShape(this, forma);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.desaparecerLLamar();
    }

    private void desaparecerLLamar() {
        try {
            Thread.sleep(2000);
            this.setVisible(false);
            VentanaPrincipal v = new VentanaPrincipal();
        } catch (InterruptedException ex) {
            Logger.getLogger(VentanaBienvenida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
