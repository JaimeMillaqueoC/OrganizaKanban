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
import vista.EditarPerfil.VentanaEditarUsuario;

/**
 *
 * @author Jaime
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelPerfil pPerfil;
    private PanelPorHacer pPorHacer;
    private PanelHaciendo pHaciendo;
    private PanelHecho pHecho;
    private VentanaEditarUsuario vEditarU;
    private boolean abierto;
    private int posY;

    public VentanaPrincipal() {
        this.inicializarComponentes();

    }

    private void inicializarComponentes() {
        GridLayout distribucion = new GridLayout(1, 4);
        this.setLayout(distribucion);

        this.abierto = false;
        this.posY = 0;

        this.pPerfil = new PanelPerfil();
        this.add(this.pPerfil);
        this.pPerfil.btnAniadirNuevo.addActionListener(this);
        this.pPerfil.btnEditarUsuario.addActionListener(this);

        this.pPorHacer = new PanelPorHacer();
        this.add(this.pPorHacer);

        this.pHaciendo = new PanelHaciendo();
        this.add(this.pHaciendo);

        this.pHecho = new PanelHecho();
        this.add(this.pHecho);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("OrganizaUfro");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        Dimension d = new Dimension(this.getWidth(), this.getHeight());

        this.setMinimumSize(d);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Botones PanelPerfil
        if (this.pPerfil.btnAniadirNuevo == e.getSource()) {
            this.pPorHacer.agregarActividad(new PAPorHacer());
            this.pPorHacer.updateUI();
        }
        if (this.pPerfil.btnEditarUsuario == e.getSource()) {
//            if (!this.abierto) {
            this.vEditarU = new VentanaEditarUsuario();
            this.abierto = true;
//            }

        }
        //Botones PanelPorHacer
        
        
        if (this.pPorHacer.pAPorHacer.size() > 0) {
            
            for (int i = 0; i < this.pPorHacer.pAPorHacer.size(); i++) {
                this.pPorHacer.pAPorHacer.get(i).btnQuitar.addActionListener(this);
                this.pPorHacer.pAPorHacer.get(i).btnAgregar.addActionListener(this);
                
                if (this.pPorHacer.pAPorHacer.get(i).btnQuitar == e.getSource()) {
                    this.pPorHacer.remove(this.pPorHacer.pAPorHacer.get(i));
                    this.pPorHacer.pAPorHacer.remove(i);
                    this.pPorHacer.updateUI();
                }if (this.pPorHacer.pAPorHacer.get(i).btnAgregar == e.getSource()) {
                    if (this.pPorHacer.pAPorHacer.get(i).getTfNombreActividad().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "¡Debe llenar con un nombre!");
                    }
                    else if (Integer.parseInt(this.pPorHacer.pAPorHacer.get(i).getCbHora1().getSelectedItem().toString()) == 0 && Integer.parseInt(this.pPorHacer.pAPorHacer.get(i).getCbMinutos1().getSelectedItem().toString()) == 0 && Integer.parseInt(this.pPorHacer.pAPorHacer.get(i).getCbSegundos1().getSelectedItem().toString()) == 0) {
                        JOptionPane.showMessageDialog(null, "¡Debe ingresar un tiempo válido!");
                    }
                    else if (!this.pPorHacer.pAPorHacer.get(i).getTfNombreActividad().getText().equals("") && !(Integer.parseInt(this.pPorHacer.pAPorHacer.get(i).getCbHora1().getSelectedItem().toString()) == 0 && Integer.parseInt(this.pPorHacer.pAPorHacer.get(i).getCbMinutos1().getSelectedItem().toString()) == 0 && Integer.parseInt(this.pPorHacer.pAPorHacer.get(i).getCbSegundos1().getSelectedItem().toString()) == 0)) {
                        this.pHaciendo.agregarActividad(new PAHaciendo(this.pPorHacer.pAPorHacer.get(i).getTfNombreActividad().getText(),
                                this.pPorHacer.pAPorHacer.get(i).getCbHora1().getSelectedItem().toString(),
                                this.pPorHacer.pAPorHacer.get(i).getCbMinutos1().getSelectedItem().toString(),
                                this.pPorHacer.pAPorHacer.get(i).getCbSegundos1().getSelectedItem().toString()));

                        this.pPorHacer.remove(this.pPorHacer.pAPorHacer.get(i));
                        this.pPorHacer.pAPorHacer.remove(i);
                        this.pPorHacer.updateUI();
                    }
                }
            }
        }
        //Botones PanelHaciendo
        if (this.pHaciendo.pAHaciendo.size() > 0) {
            for (int i = 0; i < this.pHaciendo.pAHaciendo.size(); i++) {
                this.pHaciendo.pAHaciendo.get(i).btnFinalizar.addActionListener(this);
                if (this.pHaciendo.pAHaciendo.get(i).btnFinalizar == e.getSource()) {
                    this.pHecho.agregarActividad(new PAHecho(this.pHaciendo.pAHaciendo.get(i).lblNombreActividad.getText(), true));
                    this.pHaciendo.remove(this.pHaciendo.pAHaciendo.get(i));
                    this.pHaciendo.pAHaciendo.remove(i);
                    this.pHaciendo.updateUI();
                }
            }
        }
    }

}
