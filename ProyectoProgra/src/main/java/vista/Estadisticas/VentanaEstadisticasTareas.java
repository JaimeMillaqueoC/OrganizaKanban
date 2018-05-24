/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Estadisticas;

import javax.swing.JFrame;

/**
 *
 * @author nicolas
 */
public class VentanaEstadisticasTareas extends JFrame{
    public VentanaEstadisticasTareas() {
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Estadisticas");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
    }
    
}
