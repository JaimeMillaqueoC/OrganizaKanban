/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.Principal.Panel;

/**
 *
 * @author analista.apoyo1
 */
public class RecuperadorActivdades {
    
    private Panel panelTemporalUno, panelTemporalDos, panelTemporalTres;
    private ManejoArchivos mArchivos;
    private final String RUTAP1 = "Datos/datosPanelUno.bin", RUTAP2 = "Datos/datosPanelDos.bin", RUTAP3 = "Datos/datosPanelTres.bin";

    public RecuperadorActivdades(Panel panelTemporalUno, Panel panelTemporalDos, Panel panelTemporalTres) {
        this.panelTemporalUno = panelTemporalUno;
        this.panelTemporalDos = panelTemporalDos;
        this.panelTemporalTres = panelTemporalTres;
        this.mArchivos = new ManejoArchivos();
        CargarActvidades();
//        guardarActividades();
    }

    public void CargarActvidades() {
        this.panelTemporalUno.setListaActividades(this.mArchivos.CargarActvidades(this.RUTAP1));
        this.panelTemporalDos.setListaActividades(this.mArchivos.CargarActvidades(this.RUTAP2));
        this.panelTemporalTres.setListaActividades(this.mArchivos.CargarActvidades(this.RUTAP3));
    }

    public void guardarActividades() {
        this.mArchivos.almacenarActividades(this.panelTemporalUno.getListaActividades(), this.RUTAP1);
        this.mArchivos.almacenarActividades(this.panelTemporalDos.getListaActividades(), this.RUTAP2);
        this.mArchivos.almacenarActividades(this.panelTemporalTres.getListaActividades(), this.RUTAP3);
        JOptionPane.showMessageDialog(null, "Las actividades se han guardado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
}