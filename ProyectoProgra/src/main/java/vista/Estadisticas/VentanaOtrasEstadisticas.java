/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Estadisticas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import vista.EditarPerfil.PanelEditar;

/**
 *
 * @author nicolas
 */
public class VentanaOtrasEstadisticas extends JFrame{
    
    
    public VentanaOtrasEstadisticas() {
        this.inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Otras estadisticas");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
    }
}
