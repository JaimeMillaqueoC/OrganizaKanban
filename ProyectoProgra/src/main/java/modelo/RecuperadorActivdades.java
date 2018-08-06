/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import utilidades.ManejoArchivos;
import utilidades.Ruta;
import javax.swing.JOptionPane;
import vista.Principal.Panel;

/**
 *
 * @author analista.apoyo1
 */
public class RecuperadorActivdades {
    
    private Panel panelPorhacer, panelHaciendo, panelHecho;
    private ManejoArchivos mArchivos;
    private Ruta ruta;
    public RecuperadorActivdades(Panel panelPorhacer, Panel panelHaciendo, Panel panelHecho) {
        this.panelPorhacer = panelPorhacer;
        this.panelHaciendo = panelHaciendo;
        this.panelHecho = panelHecho;
        this.mArchivos = new ManejoArchivos();
        this.ruta = new Ruta();
        CargarActvidades();
    }
    /**
     * Llama a la clase ManejoArchivos para agregar los objetos Activdad dentro de cada panel
     */
    public void CargarActvidades() {
        this.panelPorhacer.setListaActividades(this.mArchivos.recuperarActividades(this.ruta.RUTA_PANEL_POR_HACER));
        this.panelHaciendo.setListaActividades(this.mArchivos.recuperarActividades(this.ruta.RUTA_PANEL_HACIENDO));
        this.panelHecho.setListaActividades(this.mArchivos.recuperarActividades(this.ruta.RUTA_PANEL_HECHO));
    }
    /**
     * Llama a la clase ManejoArchivos para almacenar los objetos Actividad (que se encuentran 
    dentro de cada panel) en un archivo .bin disponible para cada panel
     */
    public void guardarActividades() {
        this.mArchivos.almacenarActividades(this.panelPorhacer.getListaActividades(), this.ruta.RUTA_PANEL_POR_HACER);
        this.mArchivos.almacenarActividades(this.panelHaciendo.getListaActividades(), this.ruta.RUTA_PANEL_HACIENDO);
        this.mArchivos.almacenarActividades(this.panelHecho.getListaActividades(), this.ruta.RUTA_PANEL_HECHO);
        JOptionPane.showMessageDialog(null, "Las actividades se han guardado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
}