/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.EditarPerfil;

import javax.swing.JFrame;


/**
 *
 * @author Jaime
 */
public class VentanaEditarUsuario extends JFrame{
    
    public boolean abierto;
    private PanelEditar pEditar;
    
    public VentanaEditarUsuario() {
        this.abierto = true;
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        
        this.pEditar = new PanelEditar();
        this.add(this.pEditar);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Editar");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
