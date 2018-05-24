/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.PAGE_START;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import modelo.Usuario;

/**
 *
 * @author Jaime
 */
public class Perfil extends JPanel {

    private Image fondo;
    private final Usuario user;
    public JButton btnAniadirNuevo;
    

    public Perfil(Usuario user) {
        this.user = user;
        this.inicializarComponentes();
    }

    private void inicializarComponentes(){
        GridLayout distribucion = new GridLayout(4,1);
        this.setLayout(distribucion);
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Usuario");
        this.setBorder(bordejpanel);
        
        ImageIcon image = new ImageIcon(this.user.getRutaFoto());
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH));
        JLabel imagen = new JLabel(image);
        this.add(imagen);
        
        JPanel panelDatos = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nombre = new JLabel(this.user.getPrimerNombre()+" "+this.user.getApellidoMaterno()+" "+this.user.getApellitoPaterno());
        panelDatos.add(nombre);
        JLabel universidad = new JLabel(this.user.getUniversidad());
        panelDatos.add(universidad);
        this.add(panelDatos);
        
        this.btnAniadirNuevo = new JButton("Añadir Actividad");
        this.btnAniadirNuevo.setBackground(Color.LIGHT_GRAY);     
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(this.btnAniadirNuevo);
        this.add(panelBoton);  
        
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

}
