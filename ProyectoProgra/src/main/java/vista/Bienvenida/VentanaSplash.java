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
import vista.Principal.VentanaPrincipal;

/**
 *
 * @author analista.apoyo1
 */
public class VentanaSplash extends JWindow{
    private final Image bi=Toolkit.getDefaultToolkit().getImage("utilizables/bienvenido.png");
    private final ImageIcon ii=new ImageIcon(bi);
    
    /**
     * CONSTRUCTOR: Carga los datos de la VentanaSplash, además espera unos segundo para cerrarse y
    posteriormente abrir la clase (ventana) VentanaPrincipal
     */
    public VentanaSplash() {
        try{
            setSize(ii.getIconWidth(),ii.getIconHeight());
            setLocationRelativeTo(null);
            show();
            Thread.sleep(5000);
            dispose();
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }  
    }
    /**
     * Coloca una imagen especifica en el fondo de la VentanaSplash
     * @param g 
     */
    public void paint(Graphics g){
        g.drawImage(bi,0,0,this);
    }
}
