/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Estadisticas;

import com.sun.prism.j2d.J2DPipeline;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import modelo.GestorEstadisticas;
import org.jfree.chart.ChartPanel;
import utilidades.DatosGraficos;

/**
 *
 * @author nicolas
 */
public class VentanaEstadisticasTareas extends JFrame{
    
    private JPanel estadisticas, estadisticas2, estadisticas3;
    private ChartPanel p1;
    private ChartPanel p2;
    private ChartPanel p3;
    
    private JPanel datosSuperior1,datosSuperior2;
    private JLabel nombreSuperior1, superior1;
    private JLabel nombreSuperior2, superior2;
    
    private JPanel datosCentral1, datosCentral2, datosCentral3; 
    private JLabel nombreCentral, central1;
    private JLabel nombreCentra2, central2;
    private JLabel nombreCentra3, central3;
    
    private JPanel datosInferior1,datosInferior2;
    private JLabel nombreInferio1, inferio1;
    private JLabel nombreInferior2, inferio2;
    
    private GestorEstadisticas datos;
    
    public VentanaEstadisticasTareas(ChartPanel a, ChartPanel b, ChartPanel c, GestorEstadisticas q) {
        this.inicializarComponentes();
        this.p1 = a;
        this.p2 = b;
        this.p3 = c;
        this.datos = q;
        this.panelSuperior();
        this.panelCentral();
        this.panelInferior();
    }
    
    private void panelSuperior(){
        this.estadisticas = new JPanel();
        GridLayout distribucion = new GridLayout(0,3);
        this.estadisticas.setLayout(distribucion);
        
        this.datosSuperior1 = new JPanel();
        this.datosSuperior2 = new JPanel();
        
        this.nombreSuperior1 = new JLabel("Actividades Sin terminar");
        this.nombreSuperior2 = new JLabel("Actividades Terminadas");
        
        this.superior1 = new JLabel(Integer.toString(this.datos.getActividadesSinTerminar()));
        this.superior2 = new JLabel(Integer.toString(this.datos.getActividadesTerminadas()));
        
        this.datosSuperior1.add(this.nombreSuperior1);
        this.datosSuperior1.add(superior1);
        
        this.datosSuperior2.add(this.nombreSuperior2);
        this.datosSuperior2.add(superior2);
        
        this.estadisticas.add(this.p2);
        this.estadisticas.add(datosSuperior1);
        this.estadisticas.add(datosSuperior2);
        
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Datos");
        this.estadisticas.setBorder(bordejpanel);
        this.add(this.estadisticas);
    }
    
    private void panelCentral(){
        this.estadisticas2 = new JPanel();
        GridLayout distribucion = new GridLayout(0,4);
        this.estadisticas2.setLayout(distribucion);
        
        this.datosCentral1 = new JPanel();
        this.datosCentral2 = new JPanel();
        this.datosCentral3 = new JPanel();
        
        this.nombreCentral = new JLabel("Cantidad Actividades Haciendo");
        this.nombreCentra2 = new JLabel("Cantidad Actividades Hechas");
        this.nombreCentra3 = new JLabel("Cantidad Actividades Por Hacer");
        
        this.central1 = new JLabel(Integer.toString(this.datos.getCantidadActividadesHaciendo()));
        this.central2 = new JLabel(Integer.toString(this.datos.getCantidadActividadesHechas()));
        this.central3 = new JLabel(Integer.toString(this.datos.getCantidadActividadesPorHaer()));
        
        this.datosCentral1.add(this.nombreCentral);
        this.datosCentral1.add(this.central1);
        
        this.datosCentral2.add( this.nombreCentra2);
        this.datosCentral2.add(this.central2);
        
        this.datosCentral3.add(nombreCentra3);
        this.datosCentral3.add(central3);
        
        this.estadisticas2.add(p3);
        this.estadisticas2.add(datosCentral1);
        this.estadisticas2.add(datosCentral2);
        this.estadisticas2.add(datosCentral3);
        
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Graficos");
        this.estadisticas2.setBorder(bordejpanel);
        this.add(this.estadisticas2);
    }
    private void panelInferior(){
        this.estadisticas3 = new JPanel();
        GridLayout distribucion = new GridLayout(0,3);
        this.estadisticas3.setLayout(distribucion);
        
        this.datosInferior1 = new JPanel();
        this.datosInferior2 = new JPanel();
        
        this.nombreInferio1 = new JLabel("Tiempo total trabajado en Segundos");
        this.nombreInferior2 = new JLabel("Cantidad de metas fijadas");
        
        this.inferio1 = new JLabel(Integer.toString(this.datos.getTiempoTotalTrabajado()));
        this.inferio2 = new JLabel(Integer.toString(this.datos.getCantidadActividadesTotales()));
        
        this.datosInferior1.add(this.nombreInferio1);
        this.datosInferior1.add(this.inferio1 );
        
        this.datosInferior2.add(this.nombreInferior2);
        this.datosInferior2.add(this.inferio2);
        
        this.estadisticas3.add(p1);
        this.estadisticas3.add(datosInferior1);
        this.estadisticas3.add(datosInferior2);
        
        javax.swing.border.Border bordejpanel = new TitledBorder(new LineBorder(Color.BLACK), "Proyecciones");
        this.estadisticas3.setBorder(bordejpanel);
        this.add(this.estadisticas3);
    }
    
    private void inicializarComponentes(){
        GridLayout distribucion = new GridLayout(3,0);
        this.setLayout(distribucion);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Estadisticas");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        
    }
    
}
