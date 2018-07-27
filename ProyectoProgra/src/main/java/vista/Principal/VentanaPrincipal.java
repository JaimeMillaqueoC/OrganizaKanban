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

    private Panel panelUno, panelDos, panelTres;
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
        
        this.panelUno = new Panel("Por Hacer", cantidadPanelesActividad);
        this.panelDos = new Panel("Haciendo", cantidadPanelesActividad);
        this.panelTres = new Panel("Hecho", cantidadPanelesActividad);
        
        this.setJMenuBar(barraSuperior);

        this.add(this.panelPerfil);
        this.add(this.panelUno);
        this.add(this.panelDos);
        this.add(this.panelTres);
    }
    
    private void agregarActividadesGuardaas() {
        this.recuperarActivididad = new RecuperadorActivdades(this.panelUno, this.panelDos, this.panelTres);
        this.panelUno.setListaActividades(this.darMouseListener(this.panelUno.getListaActividades()));
        this.panelDos.setListaActividades(this.darMouseListener(this.panelDos.getListaActividades()));
        this.panelTres.setListaActividades(this.darMouseListener(this.panelTres.getListaActividades()));
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
        this.gestor = new GestionarActividades(panelUno, panelDos, panelTres);
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
            }else
                this.guardar();
        }

        //Botonoes Ventana Agregar Actividad
        if (this.ventanaAgregarActividad.botonAceptar == e.getSource()) {
            this.ventanaAgregarActividad.extraerDatos();
            this.actividad = new Actividad(this.ventanaAgregarActividad.getNombre());
            this.panelUno = this.gestor.agregarActividadPanelPorHacer(this.actividad);
            this.panelUno.getListaActividades().get(this.panelUno.getListaActividades().size() - 1).addMouseListener(this);
            this.panelUno.updateUI();
            this.ventanaAgregarActividad.areaNombreActividad.setText(null);
            this.ventanaAgregarActividad.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Panel UNO
        if (this.panelUno.getListaActividades().size() > 0) {
            for (Actividad actividad1 : this.panelUno.getListaActividades()) {
                if (actividad1 == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(actividad1,this.panelUno);
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        this.panelDos.agregarLista(new Actividad(actividad1.getNombre(),actividad1.getDescripcion(),actividad1.getSegundosActividad(),actividad1.getCantidadPomodorosHechos(),actividad1.getCantidadDescanzosHechos()));
                        this.panelDos.getListaActividades().get(this.panelDos.getListaActividades().size() - 1).addMouseListener(this);
                        this.panelUno.remove(actividad1);
                        this.panelUno.getListaActividades().remove(actividad1);
                        this.panelUno.updateUI();
                        break;
                    }
                }
            }
        }
        //Panel DOS
        if (this.panelDos.getListaActividades().size() > 0) {
            for (Actividad actividad2 : this.panelDos.getListaActividades()) {
                if (actividad2 == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(actividad2,this.panelDos);
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        this.panelTres.agregarLista(actividad2);
                        this.panelDos.remove(actividad2);
                        this.panelDos.getListaActividades().remove(actividad2);
                        this.panelDos.updateUI();
                        break;
                    }
                }
            }
        }
        //Panel TRES
        if (this.panelTres.getListaActividades().size() > 0) {
            for (int i = 0; i < this.panelTres.getListaActividades().size(); i++) {
                if (this.panelTres.getListaActividades().get(i) == e.getSource()) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //Agregar Ventana para editar la actividad
                        this.ventanaActividad = new VistaActividad(this.panelTres.getListaActividades().get(i),this.panelTres);
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
        if (!(auxP1.size() == this.panelUno.getListaActividades().size() && auxP2.size() == this.panelDos.getListaActividades().size() && auxP3.size() == this.panelTres.getListaActividades().size())) {
            cont++;
        }
        for (Actividad actP : this.panelUno.getListaActividades()) {
            for (Actividad actS : auxP1) {
                if (!actP.getNombre().equals(actS.getNombre()) || !actP.getDescripcion().equals(actS.getDescripcion())) {
                    cont++;
                    break;
                }
            }
        }
        for (Actividad actP : this.panelDos.getListaActividades()) {
            for (Actividad actS : auxP2) {
                if (!actP.getNombre().equals(actS.getNombre()) || !actP.getDescripcion().equals(actS.getDescripcion())) {
                    cont++;
                    break;
                }
            }
        }
        for (Actividad actP : this.panelTres.getListaActividades()) {
            for (Actividad actS : auxP3) {
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
        this.panelUno.setListaActividades(this.quitarMouseListener(this.panelUno.getListaActividades()));
        this.panelDos.setListaActividades(this.quitarMouseListener(this.panelDos.getListaActividades()));
        this.panelTres.setListaActividades(this.quitarMouseListener(this.panelTres.getListaActividades()));
        this.recuperarActivididad.guardarActividades();
        this.panelUno.setListaActividades(this.darMouseListener(this.panelUno.getListaActividades()));
        this.panelDos.setListaActividades(this.darMouseListener(this.panelDos.getListaActividades()));
        this.panelTres.setListaActividades(this.darMouseListener(this.panelTres.getListaActividades()));
    }
}