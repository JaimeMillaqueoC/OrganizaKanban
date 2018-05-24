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
public class VentanaInformaciones extends JFrame{
    public VentanaInformaciones() {
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Informacion: Modo de uso");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
    }
    
}
