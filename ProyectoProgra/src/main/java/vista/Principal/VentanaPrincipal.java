/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Actividad;
import modelo.GestionarActividades;
import modelo.Usuario;
import vista.Ayuda.VentanaContacto;
import vista.Ayuda.VentanaInformaciones;
import vista.EditarPerfil.VentanaEditarUsuario;
import vista.Estadisticas.VentanaEstadisticasTareas;
import vista.Estadisticas.VentanaOtrasEstadisticas;

/**
 *
 * @author Jaime
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    private BarraMenu barraSuperior;
    private Perfil pPerfil;
    private Usuario usuario;
    private boolean abierto;
    
    private Panel paneluno,paneldos,paneltres;
    private GestionarActividades gestor;
    private Actividad actividad;
    private VentanaAgregarActividad ventanaAgregarActividad;
    private VentanaEstadisticasTareas estadisticas;
    private VentanaOtrasEstadisticas otrasEstadisticas;
    private VentanaEditarUsuario vEditarU;
    private VentanaContacto contacto;
    private VentanaInformaciones informaciones;
    
    private final int cantidadPanelesActividad = 10;


    public VentanaPrincipal() {
        this.venatanas();
        this.iniciarPaneles();
        this.acciones();
        this.inicializarComponentes();
        this.gestorActividades();
    }
    
    private void venatanas(){
        this.ventanaAgregarActividad = new VentanaAgregarActividad();
        
    }
    
    private void iniciarPaneles() {
        this.usuario = new Usuario();
        this.barraSuperior = new BarraMenu();
        this.pPerfil = new Perfil(this.usuario);
        
        this.paneluno = new Panel("Por Hacer",cantidadPanelesActividad);
        this.paneldos = new Panel("Haciendo",cantidadPanelesActividad);
        this.paneltres = new Panel("hecho",cantidadPanelesActividad);
        
        this.setJMenuBar(barraSuperior);
        
        this.add(this.pPerfil);
        this.add(this.paneluno);
        this.add(this.paneldos);
        this.add(this.paneltres);
    }
    
    private void acciones() {
        this.barraSuperior.editarPerfil.addActionListener(this);
        this.barraSuperior.otrosDatos.addActionListener(this);
        this.barraSuperior.datosTarea.addActionListener(this);
        this.barraSuperior.contacto.addActionListener(this);
        this.barraSuperior.informacion.addActionListener(this);
        this.barraSuperior.guardar.addActionListener(this);
        this.barraSuperior.salir.addActionListener(this);
        this.pPerfil.btnAniadirNuevo.addActionListener(this);
        this.ventanaAgregarActividad.botonAceptar.addActionListener(this);
    }
    
    private void inicializarComponentes() {
        GridLayout distribucion = new GridLayout(1, 4);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("OrganizaUfro");
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void gestorActividades(){
        this.gestor = new GestionarActividades(paneluno,paneldos,paneltres);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Botones PanelPerfil
        if (this.pPerfil.btnAniadirNuevo == e.getSource()) {
            if (this.ventanaAgregarActividad != null) {
                this.ventanaAgregarActividad.dispose();
            }
            this.ventanaAgregarActividad.setVisible(true);            
        }
        //Botones Barra superior
        if (this.barraSuperior.editarPerfil == e.getSource()) {
            if (this.vEditarU != null) {
                this.vEditarU.dispose();
            }
            this.vEditarU = new VentanaEditarUsuario();
            this.vEditarU.setVisible(true);
        }
        if (this.barraSuperior.datosTarea == e.getSource()) {
            if (this.estadisticas != null) {
                this.estadisticas.dispose();
            }
            this.estadisticas = new VentanaEstadisticasTareas();
            this.estadisticas.setVisible(true);
        }
        if (this.barraSuperior.otrosDatos == e.getSource()) {
            if (this.otrasEstadisticas != null) {
                this.otrasEstadisticas.dispose();
            }
            this.otrasEstadisticas = new VentanaOtrasEstadisticas();
            this.otrasEstadisticas.setVisible(true);
        }
        if (this.barraSuperior.contacto == e.getSource()) {
            if (this.contacto != null) {
                this.contacto.dispose();
            }
            this.contacto = new VentanaContacto();
            this.contacto.setVisible(true);
        }
        if (this.barraSuperior.informacion == e.getSource()) {
            if (this.informaciones != null) {
                this.informaciones.dispose();
            }
            this.informaciones = new VentanaInformaciones();
            this.informaciones.setVisible(true);
        }
        if (this.barraSuperior.salir == e.getSource()) {
            System.exit(0);
        }
        if (this.barraSuperior.guardar == e.getSource()) {
            System.out.println("Guardado");
        }
        
        //Botonoes Ventana Agregar Actividad
        if(this.ventanaAgregarActividad.botonAceptar == e.getSource()){
            this.ventanaAgregarActividad.extraerDatos();
            String nombreTemporal = this.ventanaAgregarActividad.getNombre();
            String tiempoTemporal = this.ventanaAgregarActividad.getTiempo();
            this.actividad = new Actividad(nombreTemporal,tiempoTemporal);
            this.gestor.agregarActividad(actividad);
            this.paneluno = this.gestor.agregarActividadPanelPorHacer();
            this.paneluno.agregarLista(this.actividad);
            this.paneluno.updateUI();
            this.ventanaAgregarActividad.dispose();
            System.out.println(this.paneluno.getListaPaneles());
        }
     }
}