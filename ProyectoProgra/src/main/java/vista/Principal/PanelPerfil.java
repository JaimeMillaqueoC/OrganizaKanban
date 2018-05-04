/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.PAGE_START;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jaime
 */
public class PanelPerfil extends JPanel {

    private Image fondo;
    private JLabel lblIcono;
    private JLabel lblFotoPerfil;
    private JLabel lblNombreUsuario;
    public JButton btnEditarUsuario;
    public JButton btnAniadirNuevo;

    public PanelPerfil() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes(){
        this.fondo = new ImageIcon("Utilizables\\fondo_madera.jpg").getImage();
        ImageIcon icono = new ImageIcon("Utilizables\\Logo.png");
        ImageIcon foto = new ImageIcon("Utilizables\\user-icon1.jpg");

//        int scale = 3;
//        int width = icono.getIconWidth();
//        int height = icono.getIconHeight();
//        BufferedImage buffer = new BufferedImage(scale *width, scale * height, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D graphics = buffer.createGraphics();
//        graphics.scale(scale, scale);
//        icono.paintIcon(null, graphics, 0, 0);
//        graphics.dispose();

        GridBagLayout distribucion = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(distribucion);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Perfil");
        this.setBorder(bordejpanel);

        //Agregamos Icono
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.lblIcono = new JLabel();
        this.lblIcono.setSize(200, 120);
        Icon icon = new ImageIcon(icono.getImage().getScaledInstance(this.lblIcono.getWidth(), this.lblIcono.getHeight(), Image.SCALE_DEFAULT));
        this.lblIcono.setIcon(icon);
        this.repaint();
        this.add(this.lblIcono,gbc);
        
        //Agregamos foto de perfil
//        gbc.weightx = 40;
        gbc.weighty = 5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.lblFotoPerfil = new JLabel();
        this.lblFotoPerfil.setSize(200, 200);
        Icon foto1 = new ImageIcon(foto.getImage().getScaledInstance(this.lblFotoPerfil.getWidth(), this.lblFotoPerfil.getHeight(), Image.SCALE_DEFAULT));
        this.lblFotoPerfil.setIcon(foto1);
        this.add(this.lblFotoPerfil,gbc);
        
        //Agregamos nombre de usuario
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 10;
        gbc.weighty = 10;
        gbc.anchor = PAGE_START;
        this.lblNombreUsuario = new JLabel("#NOMBRE_USUARIO");
        this.add(this.lblNombreUsuario,gbc);
        
        //agregando Botones
        gbc.gridx = 0;
        gbc.gridy = 3;
//        gbc.weightx = 10;
//        gbc.weighty = 10;
        this.btnEditarUsuario = new JButton("Editar");
        this.add(this.btnEditarUsuario,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.btnAniadirNuevo = new JButton("Añadir Actividad (+)");
        this.add(this.btnAniadirNuevo,gbc);
        
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

}
