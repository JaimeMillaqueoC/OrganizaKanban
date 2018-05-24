/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.EditarPerfil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vista.Principal.VentanaPrincipal;


/**
 *
 * @author Jaime
 */
public class VentanaEditarUsuario extends JFrame implements ActionListener{
    
    private PanelEditar pEditar;
    private VentanaPrincipal vp;
    public VentanaEditarUsuario(VentanaPrincipal vp) {
        this.vp = vp;
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        
        this.pEditar = new PanelEditar(this.vp);
        this.pEditar.getBtnCancelar().addActionListener(this);
        this.pEditar.getBtnGuardar().addActionListener(this);
        this.add(this.pEditar);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Editar");
        this.setSize(500, 600);
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
            this.setVisible(false);
        }
        if (this.pEditar.getBtnGuardar() == e.getSource()) {
            this.vp.usuario.setRutaFoto(this.pEditar.ruta);
            this.vp.usuario.setPrimerNombre(this.pEditar.tfNombre.getText());
            this.vp.usuario.setApellidoMaterno(this.pEditar.tfApellido.getText());
            this.vp.usuario.setUniversidad(this.pEditar.tfInstitucion.getText());
            this.vp.pPerfil.updateUI();
            this.setVisible(false);
        }
    }
    
    
}
