/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Bienvenida;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JWindow;
import vista.principal.VentanaPrincipal;

/**
 *
 * @author analista.apoyo1
 */
public class VentanaSplash extends JWindow{
    private Image bi;
    private ImageIcon ii;
    
    /**
     * CONSTRUCTOR: Carga los datos de la VentanaSplash, además espera unos segundo para cerrarse y
    posteriormente abrir la clase (ventana) VentanaPrincipal
     */
    public VentanaSplash() {
        this.bi=Toolkit.getDefaultToolkit().getImage("utilizables/bienvenido.png");
        this.ii = new ImageIcon(bi);
        try{
            setSize(ii.getIconWidth(),ii.getIconHeight());
            setLocationRelativeTo(null);
            show();
            Thread.sleep(5000);
            dispose();
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        }
        catch(InterruptedException exception){
        }  
    }
    /**
     * Coloca una imagen especifica en el fondo de la VentanaSplash
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        g.drawImage(bi,0,0,this);
    }
}
