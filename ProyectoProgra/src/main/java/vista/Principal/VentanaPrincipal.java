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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Actividad;
import modelo.GestionarActividades;
import modelo.RecuperadorActivdades;
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
public class VentanaPrincipal extends JFrame implements ActionListener, MouseListener {

    private BarraMenu barraSuperior;
    public PanelPerfil panelPerfil;
    public Usuario usuario;
    private int cant;

    private Panel paneluno, paneldos, paneltres;
    private GestionarActividades gestor;
    private Actividad actividad;
    private VentanaAgregarActividad ventanaAgregarActividad;
    private VentanaEstadisticasTareas estadisticas;
    private VentanaOtrasEstadisticas otrasEstadisticas;
    private VentanaEditarUsuario ventanaEditarUsuario;
    private VentanaContacto contacto;
    private VentanaInformaciones informaciones;
    private RecuperadorActivdades recuperarActivididad;
    
    private VistaActividad ventanaActividad;

    private final int cantidadPanelesActividad = 10;

    public VentanaPrincipal() {
        this.venatanas();
        this.iniciarPaneles();
        this.agregarActividadesGuardaas();
        this.acciones();
        this.inicializarComponentes();
        this.gestorActividades();
    }

    private void venatanas() {
        this.ventanaAgregarActividad = new VentanaAgregarActividad();

    }

    private void iniciarPaneles() {
        this.usuario = new Usuario();
        this.barraSuperior = new BarraMenu();
        this.panelPerfil = new PanelPerfil(this.usuario);

        this.paneluno = new Panel("Por Hacer", cantidadPanelesActividad);
        this.paneldos = new Panel("Haciendo", cantidadPanelesActividad);
        this.paneltres = new Panel("Hecho", cantidadPanelesActividad);
        
        
        this.setJMenuBar(barraSuperior);

        this.add(this.panelPerfil);
        this.add(this.paneluno);
        this.add(this.paneldos);
        this.add(this.paneltres);
    }
    
    private void agregarActividadesGuardaas() {
        //Agregar action listener a cada panel agregado....
        this.recuperarActivididad = new RecuperadorActivdades(this.paneluno, this.paneldos, this.paneltres);
    }

    private void acciones() {
        this.barraSuperior.editarPerfil.addActionListener(this);
        this.barraSuperior.otrosDatos.addActionListener(this);
        this.barraSuperior.datosTarea.addActionListener(this);
        this.barraSuperior.contacto.addActionListener(this);
        this.barraSuperior.informacion.addActionListener(this);
        this.barraSuperior.guardar.addActionListener(this);
        this.barraSuperior.salir.addActionListener(this);
        this.panelPerfil.btnAniadirNuevo.addActionListener(this);
        this.ventanaAgregarActividad.botonAceptar.addActionListener(this);
    }

    private void inicializarComponentes() {
        GridLayout distribucion = new GridLayout(1, 4);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("OrganizaUfro");
        this.setResizable(false);
        //this.setUndecorated(true);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void gestorActividades() {
        this.gestor = new GestionarActividades(paneluno, paneldos, paneltres);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Botones PanelPerfil
        if (this.panelPerfil.btnAniadirNuevo == e.getSource()) {
            if (this.ventanaAgregarActividad != null) {
                this.ventanaAgregarActividad.dispose();
            }
            this.ventanaAgregarActividad.setVisible(true);
        }
        //Botones Barra superior
        if (this.barraSuperior.editarPerfil == e.getSource()) {
            if (this.ventanaEditarUsuario != null) {
                this.ventanaEditarUsuario.dispose();
            }
            this.ventanaEditarUsuario = new VentanaEditarUsuario(this);
            this.ventanaEditarUsuario.setVisible(true);
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
        if (this.ventanaAgregarActividad.botonAceptar == e.getSource()) {
            this.ventanaAgregarActividad.extraerDatos();
            this.actividad = new Actividad(this.ventanaAgregarActividad.getNombre());
            this.paneluno = this.gestor.agregarActividadPanelPorHacer(actividad);
            this.paneluno.getListaPaneles().get(this.paneluno.getListaPaneles().size() - 1).addMouseListener(this);
            this.paneluno.updateUI();
            this.ventanaAgregarActividad.areaNombreActividad.setText(null);
            this.ventanaAgregarActividad.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.paneluno.getListaPaneles().size() > 0) {
            for (int i = 0; i < this.paneluno.getListaPaneles().size(); i++) {
                if (this.paneluno.getListaPaneles().get(i) == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(new Actividad(this.paneluno.getListaPaneles().get(i).getNombre()));
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        this.paneldos.agregarLista(new Actividad(this.paneluno.getListaPaneles().get(i).getNombre()));
                        this.paneldos.getListaPaneles().get(this.paneldos.getListaPaneles().size() - 1).addMouseListener(this);
                        this.paneluno.remove(this.paneluno.getListaPaneles().get(i));
                        this.paneluno.getListaPaneles().remove(i);
                        this.paneluno.updateUI();
                    }

                }

            }
        }
        if (this.paneldos.getListaPaneles().size() > 0) {
            for (int i = 0; i < this.paneldos.getListaPaneles().size(); i++) {
                if (this.paneldos.getListaPaneles().get(i) == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(new Actividad(this.paneldos.getListaPaneles().get(i).getNombre()));
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        this.paneltres.agregarLista(new Actividad(this.paneldos.getListaPaneles().get(i).getNombre()));
                        this.paneltres.getListaPaneles().get(this.paneltres.getListaPaneles().size() - 1).addMouseListener(this);
                        this.paneldos.remove(this.paneldos.getListaPaneles().get(i));
                        this.paneldos.getListaPaneles().remove(i);
                        this.paneldos.updateUI();
                    }
                }
            }
        }
        if (this.paneltres.getListaPaneles().size() > 0) {
            for (int i = 0; i < this.paneltres.getListaPaneles().size(); i++) {
                if (this.paneltres.getListaPaneles().get(i) == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(new Actividad(this.paneltres.getListaPaneles().get(i).getNombre()));
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
