/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jaime
 */
public class PanelActividad extends JPanel {
    
    public JLabel lblNombreActividad;
    public JLabel lblTiempo;
    public JLabel lblCronometro;

    public PanelActividad(String lblNombreActividad) {
        this.lblNombreActividad = new JLabel(lblNombreActividad);
        this.lblTiempo = new JLabel("Tiempo: ");
        this.lblCronometro = new JLabel();
    }
    
    
}
