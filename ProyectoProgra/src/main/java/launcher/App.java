/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import java.util.ArrayList;
import modelo.Actividad;
import modelo.ManejoArchivos;
import vista.CronometroPomodoro.frameCronometro;
import vista.Bienvenida.VentanaSplash;


/**
 *
 * @author Jaime
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    frameCronometro ca = new frameCronometro();
    ca.setVisible(true);
    ca.setLocationRelativeTo(null);
//    resetear actividades
//        ManejoArchivos mA = new ManejoArchivos();
//        ArrayList<Actividad> ac = new ArrayList<>();
//        mA.almacenarActividades(ac, "Datos/datosPanelUno.bin");
//        mA.almacenarActividades(ac, "Datos/datosPanelDos.bin");
//        mA.almacenarActividades(ac, "Datos/datosPanelTres.bin");
    VentanaSplash vn = new VentanaSplash();
    
    }
}
