/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Actividad;
import modelo.GestionarActividades;
import modelo.ManejoArchivos;
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
    private final String RUTAP1 = "Datos/datosPanelUno.bin", RUTAP2 = "Datos/datosPanelDos.bin", RUTAP3 = "Datos/datosPanelTres.bin";

    private ManejoArchivos mArchivos;

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
        this.mArchivos = new ManejoArchivos();
        this.venatanas();
        this.iniciarPaneles();
        this.agregarActividadesGuardaas();
        this.acciones();
        this.inicializarComponentes();
        this.gestorActividades();
        this.cerrar();
    }

    private void venatanas() {
        this.ventanaAgregarActividad = new VentanaAgregarActividad();
    }

    private void iniciarPaneles() {
        this.usuario = (Usuario) this.mArchivos.cargarDatos("Datos/datosUsuario.bin");
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
        this.recuperarActivididad = new RecuperadorActivdades(this.paneluno, this.paneldos, this.paneltres);
        this.paneluno.setListaActividades(this.darMouseListener(this.paneluno.getListaActividades()));
        this.paneldos.setListaActividades(this.darMouseListener(this.paneldos.getListaActividades()));
        this.paneltres.setListaActividades(this.darMouseListener(this.paneltres.getListaActividades()));
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
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
            this.guardar();
        }

        //Botonoes Ventana Agregar Actividad
        if (this.ventanaAgregarActividad.botonAceptar == e.getSource()) {
            this.ventanaAgregarActividad.extraerDatos();
            this.actividad = new Actividad(this.ventanaAgregarActividad.getNombre());
            this.paneluno = this.gestor.agregarActividadPanelPorHacer(this.actividad);
            this.paneluno.getListaActividades().get(this.paneluno.getListaActividades().size() - 1).addMouseListener(this);
            this.paneluno.updateUI();
            this.ventanaAgregarActividad.areaNombreActividad.setText(null);
            this.ventanaAgregarActividad.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.paneluno.getListaActividades().size() > 0) {
            for (int i = 0; i < this.paneluno.getListaActividades().size(); i++) {
                if (this.paneluno.getListaActividades().get(i) == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(this.paneluno.getListaActividades().get(i),this.paneluno);
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        this.paneldos.agregarLista(this.paneluno.getListaActividades().get(i));
                        this.paneluno.remove(this.paneluno.getListaActividades().get(i));
                        this.paneluno.getListaActividades().remove(i);
                        this.paneluno.updateUI();
                    }

                }

            }
        }
        else if (this.paneldos.getListaActividades().size() > 0) {
            for (int i = 0; i < this.paneldos.getListaActividades().size(); i++) {
                if (this.paneldos.getListaActividades().get(i) == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(this.paneldos.getListaActividades().get(i),this.paneldos);
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        this.paneltres.agregarLista(this.paneldos.getListaActividades().get(i));
                        this.paneldos.remove(this.paneldos.getListaActividades().get(i));
                        this.paneldos.getListaActividades().remove(i);
                        this.paneldos.updateUI();
                    }
                }
            }
        }
        else if (this.paneltres.getListaActividades().size() > 0) {
            for (int i = 0; i < this.paneltres.getListaActividades().size(); i++) {
                if (this.paneltres.getListaActividades().get(i) == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(this.paneltres.getListaActividades().get(i),this.paneltres);
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

    private ArrayList<Actividad> quitarMouseListener(ArrayList<Actividad> actividades) {
        ArrayList<Actividad> aux = new ArrayList<>();
        for (Actividad ac : actividades) {
            ac.removeMouseListener(this);
            aux.add(ac);
        }
        return aux;
    }

    private ArrayList<Actividad> darMouseListener(ArrayList<Actividad> actividades) {
        ArrayList<Actividad> aux = new ArrayList<>();
        for (Actividad ac : actividades) {
            ac.addMouseListener(this);
            aux.add(ac);
        }
        return aux;
    }

    private boolean detectarCambios() {
        int cont = 0;
        ArrayList<Actividad> auxP1 = this.mArchivos.CargarActvidades(RUTAP1);
        ArrayList<Actividad> auxP2 = this.mArchivos.CargarActvidades(RUTAP2);
        ArrayList<Actividad> auxP3 = this.mArchivos.CargarActvidades(RUTAP3);
        if (!(auxP1.size() == this.paneluno.getListaActividades().size() && auxP2.size() == this.paneldos.getListaActividades().size() && auxP3.size() == this.paneltres.getListaActividades().size())) {
            cont++;
        }
        for (Actividad actP : this.paneluno.getListaActividades()) {
            for (Actividad actS : auxP1) {
                System.out.println(actP.getNombre()+" : "+actS.getNombre());
                if (!actP.getNombre().equals(actS.getNombre()) || !actP.getDescripcion().equals(actS.getDescripcion())) {
                    cont++;
                    break;
                }
            }
        }
        for (Actividad actP : this.paneldos.getListaActividades()) {
            for (Actividad actS : auxP2) {
                System.out.println(actP.getNombre()+" : "+actS.getNombre());
                if (!actP.getNombre().equals(actS.getNombre()) || !actP.getDescripcion().equals(actS.getDescripcion())) {
                    cont++;
                    break;
                }
            }
        }
        for (Actividad actP : this.paneltres.getListaActividades()) {
            for (Actividad actS : auxP3) {
                System.out.println(actP.getNombre()+" : "+actS.getNombre());
                if (!actP.getNombre().equals(actS.getNombre()) || !actP.getDescripcion().equals(actS.getDescripcion())) {
                    cont++;
                    break;
                }
            }
        }
        if (cont != 0) {
            return true;
        } else {
            return false;
        }

    }

    private void cerrar() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if (detectarCambios()) {
                    if (JOptionPane.showConfirmDialog(rootPane, "¡Se han detectados cambios sin guardar!\n¿Desea guardar antes de salir?",
                            "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    } else {
                        guardar();
                        System.exit(0);
                    }
                }
                else{
                    System.exit(0);
                }

            }
        });
    }

    private void guardar() {
        this.paneluno.setListaActividades(this.quitarMouseListener(this.paneluno.getListaActividades()));
        this.paneldos.setListaActividades(this.quitarMouseListener(this.paneldos.getListaActividades()));
        this.paneltres.setListaActividades(this.quitarMouseListener(this.paneltres.getListaActividades()));
        this.recuperarActivididad.guardarActividades();
        this.paneluno.setListaActividades(this.darMouseListener(this.paneluno.getListaActividades()));
        this.paneldos.setListaActividades(this.darMouseListener(this.paneldos.getListaActividades()));
        this.paneltres.setListaActividades(this.darMouseListener(this.paneltres.getListaActividades()));
    }
}
