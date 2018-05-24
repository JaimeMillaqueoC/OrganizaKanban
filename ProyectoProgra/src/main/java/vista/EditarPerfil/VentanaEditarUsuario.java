/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.EditarPerfil;

import javax.swing.JFrame;
import vista.Principal.VentanaPrincipal;


/**
 *
 * @author Jaime
 */
public class VentanaEditarUsuario extends JFrame{
    
    private PanelEditar pEditar;
    private VentanaPrincipal vp;
    public VentanaEditarUsuario(VentanaPrincipal vp) {
        this.vp = vp;
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        
        this.pEditar = new PanelEditar(this.vp);
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
    
    
}
