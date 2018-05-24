/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Ayuda;

import javax.swing.JFrame;

/**
 *
 * @author nicolas
 */
public class VentanaContacto extends JFrame{
    
    
    public VentanaContacto() {
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Contacto");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
    }
}
