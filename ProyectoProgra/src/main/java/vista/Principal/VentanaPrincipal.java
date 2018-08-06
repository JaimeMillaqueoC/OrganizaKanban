/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import vista.actividad.VentanaActividad;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.GestionarActividades;
import utilidades.ManejoArchivos;
import utilidades.Ruta;
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
    private final Ruta ruta;
    private ManejoArchivos mArchivos;

    private Panel panelPorHacer;
    private Panel panelHaciendo;
    private Panel panelHecho;
    private GestionarActividades gestor;
    private Actividad actividad;
    private VentanaAgregarActividad ventanaAgregarActividad;
    private VentanaEstadisticasTareas estadisticas;
    private VentanaOtrasEstadisticas otrasEstadisticas;
    private VentanaEditarUsuario ventanaEditarUsuario;
    private VentanaContacto contacto;
    private VentanaInformaciones informaciones;
    private RecuperadorActivdades recuperarActivididad;

    private VentanaActividad ventanaActividad;

    private final int cantidadPanelesActividad = 10;

    public VentanaPrincipal() {
        this.mArchivos = new ManejoArchivos();
        this.ruta = new Ruta();
        this.venatanas();
        this.iniciarPaneles();
        this.agregarActividadesGuardadas();
        this.acciones();
        this.inicializarComponentes();
        this.gestorActividades();
        this.cerrar();
    }

    /**
     * Instancia la clase VentanaAgregarActividad.
     */
    private void venatanas() {
        this.ventanaAgregarActividad = new VentanaAgregarActividad();
    }

    /**
     * Instancia, ordena y agrega los elementos principales de esta clase.
     */
    private void iniciarPaneles() {
        this.usuario = (Usuario) this.mArchivos.recuperarDatosUsuario(this.ruta.RUTA_USUARIO);
        this.barraSuperior = new BarraMenu();
        this.panelPerfil = new PanelPerfil(this.usuario);

        this.panelPorHacer = new Panel("Por Hacer", cantidadPanelesActividad);
        this.panelHaciendo = new Panel("Haciendo", cantidadPanelesActividad);
        this.panelHecho = new Panel("Hecho", cantidadPanelesActividad);

        this.setJMenuBar(barraSuperior);

        this.add(this.panelPerfil);
        this.add(this.panelPorHacer);
        this.add(this.panelHaciendo);
        this.add(this.panelHecho);
    }

    /**
     * Instancia la clase recuperarActivididad con el fin de cargar y agregar
     * los objetos Actividad a cada uno de sus paneles correspondientes.
     */
    private void agregarActividadesGuardadas() {
        this.recuperarActivididad = new RecuperadorActivdades(this.panelPorHacer, this.panelHaciendo, this.panelHecho);
        this.panelPorHacer.setListaActividades(this.darMouseListener(this.panelPorHacer.getListaActividades()));
        this.panelHaciendo.setListaActividades(this.darMouseListener(this.panelHaciendo.getListaActividades()));
        this.panelHecho.setListaActividades(this.darMouseListener(this.panelHecho.getListaActividades()));
    }

    /**
     * Agrega los ActionListener a cada elemento que lo necesite.
     */
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

    /**
     * Determina las caracteristicas del JFrame en cuestion.
     */
    private void inicializarComponentes() {
        GridLayout distribucion = new GridLayout(1, 4);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("OrganizaUfro");
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Instancia la clase GestionarActividades.
     */
    private void gestorActividades() {
        this.gestor = new GestionarActividades(panelPorHacer, panelHaciendo, panelHecho);
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
            if (!detectarCambios()) {
                JOptionPane.showMessageDialog(null, "No han habido cambios", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.guardar();
            }
        }

        //Botonoes Ventana Agregar Actividad
        if (this.ventanaAgregarActividad.botonAceptar == e.getSource()) {
            this.ventanaAgregarActividad.extraerDatos();
            this.actividad = new Actividad(this.ventanaAgregarActividad.getNombre());
            this.panelPorHacer = this.gestor.agregarActividadPanelPorHacer(this.actividad);
            this.panelPorHacer.getListaActividades().get(this.panelPorHacer.getListaActividades().size() - 1).addMouseListener(this);
            this.panelPorHacer.updateUI();
            this.ventanaAgregarActividad.areaNombreActividad.setText(null);
            this.ventanaAgregarActividad.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Panel PorHacer
        if (this.panelPorHacer.getListaActividades().size() > 0) {
            for (Actividad actividad1 : this.panelPorHacer.getListaActividades()) {
                if (actividad1 == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        this.ventanaActividad = new VentanaActividad(actividad1, this.panelPorHacer, this.panelHaciendo, this.panelHecho);
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        Actividad actAux = new Actividad();
                        actAux.clonar(actividad1);
                        this.panelHaciendo.agregarActividad(actAux);
                        this.panelHaciendo.getListaActividades().get(this.panelHaciendo.getListaActividades().size() - 1).addMouseListener(this);
                        this.panelPorHacer.remove(actividad1);
                        this.panelPorHacer.getListaActividades().remove(actividad1);
                        this.panelPorHacer.updateUI();
                        break;
                    }
                }
            }
        }
        //Panel Haciendo
        if (this.panelHaciendo.getListaActividades().size() > 0) {
            for (Actividad actividad2 : this.panelHaciendo.getListaActividades()) {
                if (actividad2 == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        this.ventanaActividad = new VentanaActividad(actividad2, this.panelHaciendo, this.panelPorHacer, this.panelHecho);
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        this.panelHecho.agregarActividad(actividad2);
                        this.panelHaciendo.remove(actividad2);
                        this.panelHaciendo.getListaActividades().remove(actividad2);
                        this.panelHaciendo.updateUI();
                        break;
                    }
                }
            }
        }
        //Panel Hecho
        if (this.panelHecho.getListaActividades().size() > 0) {
            for (int i = 0; i < this.panelHecho.getListaActividades().size(); i++) {
                if (this.panelHecho.getListaActividades().get(i) == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        this.ventanaActividad = new VentanaActividad(this.panelHecho.getListaActividades().get(i), this.panelHecho, this.panelPorHacer, this.panelHaciendo);
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

    /**
     * Quita todos los MouseListener de cada objeto Actividad dentro del
     * ArrayList que recibe
     *
     * @param actividades
     * @return
     */
    private ArrayList<Actividad> quitarMouseListener(ArrayList<Actividad> actividades) {
        ArrayList<Actividad> aux = new ArrayList<>();
        for (Actividad ac : actividades) {
            ac.removeMouseListener(this);
            aux.add(ac);
        }
        return aux;
    }

    /**
     * Agrega MouseListener a cada objeto Actividad dentro del ArrayList que
     * recibe
     *
     * @param actividades
     * @return
     */
    private ArrayList<Actividad> darMouseListener(ArrayList<Actividad> actividades) {
        ArrayList<Actividad> aux = new ArrayList<>();
        for (Actividad ac : actividades) {
            ac.addMouseListener(this);
            aux.add(ac);
        }
        return aux;
    }

    /**
     * Busca cambios realizados en cada Panel central
     * (PanelPorHacer,PanelHaciendo,PanelHecho) y dentro de cada objeto
     * Actividad. En caso de encontrarlos retorna un true.
     *
     * @return
     */
    private boolean detectarCambios() {
        ArrayList<Actividad> auxP1 = this.mArchivos.recuperarActividades(this.ruta.RUTA_PANEL_POR_HACER);
        ArrayList<Actividad> auxP2 = this.mArchivos.recuperarActividades(this.ruta.RUTA_PANEL_HACIENDO);
        ArrayList<Actividad> auxP3 = this.mArchivos.recuperarActividades(this.ruta.RUTA_PANEL_HECHO);
        if (!(auxP1.size() == this.panelPorHacer.getListaActividades().size() && auxP2.size() == this.panelHaciendo.getListaActividades().size() && auxP3.size() == this.panelHecho.getListaActividades().size())) {
            return true;
        }
        return this.buscarDiferencias(auxP1, this.panelPorHacer.getListaActividades())
                || this.buscarDiferencias(auxP2, this.panelHaciendo.getListaActividades())
                || this.buscarDiferencias(auxP3, this.panelHecho.getListaActividades());
    }
    /**
     * Busca las diferencias entre los atributos de los objetos Actividad contenidos en un arreglo
     * @param listGuardada
     * @param listActual
     * @return 
     */
    private boolean buscarDiferencias(ArrayList<Actividad> listGuardada, ArrayList<Actividad> listActual){
        for (int i = 0; i < listActual.size(); i++) {
                if (listActual.get(i).equals(listGuardada.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Pregunta al usuario si guardar antes de salir en caso de que se detecten
     * cambios.
     */
    private void cerrar() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if (detectarCambios()) {
                    if (JOptionPane.showConfirmDialog(rootPane, "¡Se han detectados cambios sin guardar!\n¿Desea salir sin guardar?",
                            "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        guardar();
                        System.exit(0);
                    } else {
                        System.exit(0);
                    }
                } else {
                    System.exit(0);
                }
            }
        });
    }

    /**
     * Guarda los objetos Actividad en el archivo .bin determinado para cada uno
     * llamando a los metodos encargados para ello.
     */
    private void guardar() {
        this.panelPorHacer.setListaActividades(this.quitarMouseListener(this.panelPorHacer.getListaActividades()));
        this.panelHaciendo.setListaActividades(this.quitarMouseListener(this.panelHaciendo.getListaActividades()));
        this.panelHecho.setListaActividades(this.quitarMouseListener(this.panelHecho.getListaActividades()));
        this.recuperarActivididad.guardarActividades();
        this.panelPorHacer.setListaActividades(this.darMouseListener(this.panelPorHacer.getListaActividades()));
        this.panelHaciendo.setListaActividades(this.darMouseListener(this.panelHaciendo.getListaActividades()));
        this.panelHecho.setListaActividades(this.darMouseListener(this.panelHecho.getListaActividades()));
    }
}
