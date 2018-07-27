/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
public class PanelPerfil extends JPanel {

    private Image fondo;
    private Usuario user;
    public JButton btnAniadirNuevo;
    private String primerNombre;
    private String universidad;
    private String rutaFoto;
    private JLabel lblNombre, lblUniversidad, imagen;

    public PanelPerfil(Usuario user) {
        this.user = user;
        this.primerNombre = this.user.getNombre();
        this.universidad = this.user.getUniversidad();
        this.rutaFoto = this.user.getRutaFoto();
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        GridLayout distribucion = new GridLayout(4, 1);
        this.setLayout(distribucion);
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Usuario");
        this.setBorder(bordejpanel);

        ImageIcon image = new ImageIcon(this.rutaFoto);
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH));
        this.imagen = new JLabel(image);
//        this.imagen.setIcon(image);
        this.add(this.imagen);

        JPanel panelDatos = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.lblNombre = new JLabel(this.primerNombre);
        panelDatos.add(lblNombre);
        this.lblUniversidad = new JLabel(this.universidad);
        panelDatos.add(this.lblUniversidad);
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

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setNombre(String nombre) {
        this.lblNombre.setText(nombre);
    }

    public void setLblUniversidad(String universidad) {
        this.lblUniversidad.setText(universidad);
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
        ImageIcon image = new ImageIcon(this.rutaFoto);
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH));
        this.imagen.setIcon(image);
        this.updateUI();
        
    }
    
    

}
