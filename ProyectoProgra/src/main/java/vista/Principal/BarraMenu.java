/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author nicolas
 */

public class BarraMenu extends JMenuBar {
    private JMenu perfil;
    private JMenu ayuda;
    private JMenu estadisticas;
    public JMenuItem editarPerfil;
    public JMenuItem salir;
    public JMenuItem guardar;
    public JMenuItem informacion;
    public JMenuItem contacto;
    public JMenuItem datosTarea;
    public JMenuItem otrosDatos;

    public BarraMenu() {
        inicilizarBarra();
    }
    /**
     * Carga, ordena, configura y agrega todos los elementos que contendrá el JMenuBar
     */
    private void inicilizarBarra() {
        this.perfil = new JMenu("Perfil");
        this.estadisticas = new JMenu("Estadisticas");
        this.ayuda = new JMenu("Ayuda");
        
        this.editarPerfil = new JMenuItem("Editar Perfil");
        this.guardar = new JMenuItem("Guardar Cambios");
        this.salir = new JMenuItem("Salir sin Guardar");
        
        this.datosTarea = new JMenuItem("Estadisticas Tareas");
        this.otrosDatos = new JMenuItem("Otras Estdisticas");
        
        this.informacion = new JMenuItem("Informaciones");
        this.contacto = new JMenuItem("Contacto");
        
        this.add(perfil);
        this.add(estadisticas);
        this.add(ayuda);
        
        perfil.add(editarPerfil);
        perfil.add(guardar);
        perfil.add(salir);
        
        estadisticas.add(datosTarea);
        estadisticas.add(otrosDatos);
        
        ayuda.add(informacion);
        ayuda.add(contacto);
        
    }
}
