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
    Image bi=Toolkit.getDefaultToolkit().getImage("Utilizables/bienvenido.png");
    ImageIcon ii=new ImageIcon(bi);

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
    
    public void paint(Graphics g){
        g.drawImage(bi,0,0,this);
    }
}
