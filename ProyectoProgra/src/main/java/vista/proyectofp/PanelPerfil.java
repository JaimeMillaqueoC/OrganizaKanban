/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.proyectofp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.FIRST_LINE_START;
import static java.awt.GridBagConstraints.PAGE_START;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import utilidades.IC;

/**
 *
 * @author Jaime
 */
public class PanelPerfil extends JPanel implements IC {

    private Image fondo;
    private JLabel lblIcono;
    private JLabel lblFotoPerfil;
    private JLabel lblNombreUsuario;
    private JButton btnEditarUsuario;
    private JButton btnAniadirNuevo;

    public PanelPerfil() {
        this.inicializarComponentes();
    }

    @Override
    public void inicializarComponentes() {
//        this.url = getClass().getResource("C:\\Users\\Jaime\\Documents\\VPProjects\\ImagenProyecto\\background-verde.jpg");

        this.fondo = new ImageIcon("Utilizables\\fondo_azul.jpg").getImage();
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

//        GridLayout gridbag = new GridLayout(5,1);
        GridBagLayout bigMama = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(bigMama);
        Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Perfil");
        this.setBorder(bordejpanel);

        
        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.weightx = 20;
//        gbc.weighty = 20;
//        this.lblIcono = new JLabel("AQUI VA UN ICONO");
        this.lblIcono = new JLabel();
        this.lblIcono.setSize(200, 120);
        Icon icon;
        icon = new ImageIcon(icono.getImage().getScaledInstance(this.lblIcono.getWidth(), this.lblIcono.getHeight(), Image.SCALE_DEFAULT));
        
        this.lblIcono.setIcon(icon);
        this.repaint();
        this.add(this.lblIcono,gbc);
        
        
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
//        gbc.gridheight = 2;
//        this.lblFotoPerfil = new JLabel("AQUI VA UNA FOTO DE PERFIL");
        this.lblFotoPerfil = new JLabel();
        this.lblFotoPerfil.setSize(200, 120);
        Icon foto1;
        foto1 = new ImageIcon(foto.getImage().getScaledInstance(this.lblFotoPerfil.getWidth(), this.lblFotoPerfil.getHeight(), Image.SCALE_DEFAULT));
        this.lblFotoPerfil.setIcon(foto1);
        this.add(this.lblFotoPerfil,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
//        gbc.gridheight = 1;
        this.lblNombreUsuario = new JLabel("#NOMBRE_USUARIO");
        this.add(this.lblNombreUsuario,gbc);
        
        //agregando Botones
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.btnEditarUsuario = new JButton("Editar");
        Dimension d = new Dimension(10,10);
        
        
        this.add(this.btnEditarUsuario,gbc);
        this.btnEditarUsuario.setMaximumSize(d);
        
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
