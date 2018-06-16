/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.EditarPerfil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.ManejoArchivos;
import modelo.Usuario;
import vista.Principal.VentanaPrincipal;


/**
 *
 * @author Jaime
 */
public class VentanaEditarUsuario extends JFrame implements ActionListener{
    
    private PanelEditar pEditar;
    private VentanaPrincipal vp;
    private ManejoArchivos mArchivos;
    public VentanaEditarUsuario(VentanaPrincipal vp) {
        this.vp = vp;
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        
        this.pEditar = new PanelEditar(this.vp.usuario.getRutaFoto());
        this.mArchivos = new ManejoArchivos();
        this.pEditar.getBtnCancelar().addActionListener(this);
        this.pEditar.getBtnGuardar().addActionListener(this);
        this.pEditar.getBtnPredeterminado().addActionListener(this);
        this.add(this.pEditar);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Editar");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public PanelEditar getpEditar() {
        return pEditar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.pEditar.getBtnCancelar() == e.getSource()) {
            this.dispose();
        }
        if (this.pEditar.getBtnGuardar() == e.getSource()) {
            this.vp.usuario.setRutaFoto(this.pEditar.ruta);
            this.vp.usuario.setNombre(this.pEditar.tfNombre.getText()+" "+this.pEditar.tfApellido.getText());
            this.vp.usuario.setUniversidad(this.pEditar.tfInstitucion.getText());
            this.mArchivos.guardarDatos(this.vp.usuario, "Datos/datosUsuario.bin");
            this.vp.panelPerfil.setUser(this.vp.usuario);
            this.vp.panelPerfil.setNombre(this.pEditar.tfNombre.getText()+" "+this.pEditar.tfApellido.getText());
            this.vp.panelPerfil.setLblUniversidad(this.pEditar.tfInstitucion.getText());
            this.vp.panelPerfil.setRutaFoto(this.pEditar.ruta);
            this.vp.panelPerfil.updateUI();
            this.dispose();
            
        }
        if (this.pEditar.getBtnPredeterminado() == e.getSource()) {
            this.vp.usuario = (Usuario) this.mArchivos.cargarDatos("Predeterminado/datosUsuario.bin");
            this.mArchivos.guardarDatos(this.vp.usuario, "Datos/datosUsuario.bin");
            this.vp.panelPerfil.setUser(this.vp.usuario);
            this.vp.panelPerfil.setNombre(this.vp.usuario.getNombre());
            this.vp.panelPerfil.setLblUniversidad(this.vp.usuario.getUniversidad());
            this.vp.panelPerfil.setRutaFoto(this.vp.usuario.getRutaFoto());
            this.vp.panelPerfil.updateUI();
            this.dispose();
        }
    }
    
    
}
