/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import modelo.Usuario;
import utilidades.ManejoArchivos;
import utilidades.Ruta;

/**
 *
 * @author Jaime
 */
public class PanelPerfil extends JPanel {

    private Usuario user;
    public JButton btnAniadirNuevo;
    private String primerNombre;
    private String universidad;
    private String rutaImagenUsuario;
    private JLabel lblNombre;
    private JLabel lblUniversidad;
    private JLabel imagenUsuario;
    private final int ESCALADO_X = 130;
    private final int ESCALADO_Y = 120;
    private Ruta r;
    private ManejoArchivos mArchivos;

    public PanelPerfil(Usuario user) {
        this.user = user;
        this.primerNombre = this.user.getNombre();
        this.universidad = this.user.getUniversidad();
        this.rutaImagenUsuario = this.user.getRutaFoto();
        this.r = new Ruta();
        this.mArchivos = new ManejoArchivos();
        this.inicializarComponentes();
    }

    /**
     * Carga, ordena, configura y agrega todos los elementos que contendrá el
     * panel
     */
    private void inicializarComponentes() {
        GridLayout distribucion = new GridLayout(4, 1);
        this.setLayout(distribucion);
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Usuario");
        this.setBorder(bordejpanel);
        
        this.comprobarRuta();
        
        JPanel panelDatos = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.lblNombre = new JLabel(this.primerNombre);
        panelDatos.add(this.lblNombre, c);
        this.lblUniversidad = new JLabel(this.universidad);
        c.gridy = 1;
        panelDatos.add(this.lblUniversidad, c);
        this.add(panelDatos);

        this.btnAniadirNuevo = new JButton("Añadir Actividad");
        this.btnAniadirNuevo.setBackground(Color.LIGHT_GRAY);
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(this.btnAniadirNuevo);
        this.add(panelBoton);

    }

    private void comprobarRuta() {
        File archivo = new File(this.rutaImagenUsuario);
        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(null, "No se a encontrado la imagen en la ruta:\n"+this.rutaImagenUsuario+"\nSe ha cambiado a la imagen predeterminada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            this.rutaImagenUsuario = this.r.RUTA_IMAGEN_USUARIO_PREDETERMINADA;
            this.user.setRutaFoto(this.rutaImagenUsuario);
            this.mArchivos.guardarDatos(this.user, this.r.RUTA_USUARIO);
        }
        cargarImagen(this.rutaImagenUsuario);
    }

    private void cargarImagen(String ruta) {
        ImageIcon image = new ImageIcon(ruta);
        image = new ImageIcon(image.getImage().getScaledInstance(this.ESCALADO_X, this.ESCALADO_Y, BufferedImage.SCALE_SMOOTH));
        this.imagenUsuario = new JLabel(image);
        this.add(this.imagenUsuario);
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

    /**
     * Redefine el atributo rutaImagenUsuario y ademas llama al metodo
     * editarImagenUsuario()
     *
     * @param rutaImagenUsuario
     */
    public void setRutaImagenUsuario(String rutaImagenUsuario) {
        this.rutaImagenUsuario = rutaImagenUsuario;
        this.editarImagenUsuario();
    }

    /**
     * Redefine la imagen del usuario con la ruta de la imagen especificada por
     * el usuario
     */
    private void editarImagenUsuario() {
        ImageIcon image = new ImageIcon(this.rutaImagenUsuario);
        image = new ImageIcon(image.getImage().getScaledInstance(this.ESCALADO_X, this.ESCALADO_Y, BufferedImage.SCALE_SMOOTH));
        this.imagenUsuario.setIcon(image);
        this.updateUI();
    }

}
