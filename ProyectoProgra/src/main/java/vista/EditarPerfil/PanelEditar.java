/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.EditarPerfil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vista.Principal.VentanaPrincipal;

/**
 *
 * @author Jaime
 */
public class PanelEditar extends JPanel implements ActionListener{
    private ImageIcon imPerfil;
    private JLabel lblPerfil, lblNombre, lblApellido, lblInsitucion;
    public JTextField tfNombre, tfApellido, tfInstitucion;
    private JButton btnCambiarF, btnCancelar, btnGuardar;
    public String ruta = "Utilizables\\fotoUser.png";
    private VentanaPrincipal vp;
    
    public PanelEditar(VentanaPrincipal vp) {
        this.vp = vp;
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        GridBagLayout distribucion = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(distribucion);
        this.setBackground(Color.WHITE);
        
        c.gridwidth = 4;
        c.weighty = 1.0;
        this.imPerfil = new ImageIcon(this.ruta);
        this.lblPerfil = new JLabel();
        this.lblPerfil.setSize(200, 200);
        Icon icon = new ImageIcon(this.imPerfil.getImage().getScaledInstance(this.lblPerfil.getWidth(), this.lblPerfil.getHeight(), Image.SCALE_DEFAULT));
        this.lblPerfil.setIcon(icon);
        this.add(this.lblPerfil,c);
        
        c.gridy = 1;
        c.weighty = 0.0;
        this.btnCambiarF = new JButton("Cambiar Imagen de Perfil");
        this.btnCambiarF.addActionListener(this);
        this.btnCambiarF.setBackground(Color.LIGHT_GRAY);
        this.add(this.btnCambiarF,c);
        c.weighty = 1.0;
        
        c.gridy = 2;
        c.gridwidth = 2;
        c.weightx = 1.0;
        this.lblNombre = new JLabel("Nombre:");
        this.add(this.lblNombre,c);
        
        c.gridy = 3;
        this.lblApellido = new JLabel("Apellido:");
        this.add(this.lblApellido,c);
        
        c.gridy = 4;
        this.lblInsitucion = new JLabel("Institución:");
        this.add(this.lblInsitucion,c);
        
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        this.tfNombre = new JTextField();
        this.tfNombre.setPreferredSize(new Dimension(200, 25));
        this.add(this.tfNombre,c);
        
        c.gridy = 3;
        this.tfApellido = new JTextField();
        this.tfApellido.setPreferredSize(new Dimension(200, 25));
        this.add(this.tfApellido,c);
        
        c.gridy = 4;
        this.tfInstitucion = new JTextField();
        this.tfInstitucion.setPreferredSize(new Dimension(200, 25));
        this.add(this.tfInstitucion,c);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;
        
        c.gridy = 5;
        c.gridx = 0;
        c.gridwidth = 2;
        this.btnCancelar = new JButton("Cancelar");
        this.btnCancelar.setBackground(Color.LIGHT_GRAY);
        this.add(this.btnCancelar,c);
        
        c.gridy = 5;
        c.gridx = 2;
        this.btnGuardar = new JButton("Guardar Cambios");
        this.btnGuardar.setBackground(Color.LIGHT_GRAY);
        this.add(this.btnGuardar,c);
        
        
        
        
    }
    private void abrirActionPerformed(){
        JFileChooser jf =  new JFileChooser();
        jf.showOpenDialog(this);
        File archivo = jf.getSelectedFile();
        if (archivo != null) {
            this.ruta =  archivo.getAbsolutePath();
            this.imPerfil = new ImageIcon(this.ruta);
            Icon icon = new ImageIcon(this.imPerfil.getImage().getScaledInstance(this.lblPerfil.getWidth(), this.lblPerfil.getHeight(), Image.SCALE_DEFAULT));
            this.lblPerfil.setIcon(icon);
            this.updateUI();
        }
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.btnCambiarF == e.getSource()) {
            this.abrirActionPerformed();
        }
    }
}
