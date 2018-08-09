/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.Font;
import modelo.GestorEstadisticas;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author analista.apoyo1
 */
public class DatosGraficos {
    private GestorEstadisticas datos;
    
    private ChartPanel chartPanelPie;
    private ChartPanel chartPanelBar;
    private ChartPanel chartPanelLine;

    public DatosGraficos(GestorEstadisticas datos) {
        this.datos = datos;
        CrearPie();
        CrearBarras();
        CrearLinea();
    }
    
    public void CrearPie() {
        JFreeChart chartPie = createDatasetPie();
        this.chartPanelPie = new ChartPanel(chartPie);
    }
    
    private JFreeChart  createDatasetPie() {
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Hechas", Double.valueOf(this.datos.getCantidadActividadesHechas()));
        dataset.setValue("Haciendo", Double.valueOf(this.datos.getCantidadActividadesHaciendo()));
        dataset.setValue("Por Hacer", Double.valueOf(this.datos.getCantidadActividadesPorHaer()));
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Pie Chart Demo 1",
            dataset,            
            true,              
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        
        return chart;
    }

    public ChartPanel getChartPanelPie() {
        return chartPanelPie;
    }
    
    public void CrearBarras() {
        JFreeChart chartBarra = createDatasetBarras();
        this.chartPanelBar = new ChartPanel(chartBarra);
    }
    
    private JFreeChart  createDatasetBarras() {
        final String fiat = "FIAT";
        final String audi = "AUDI";
        final String ford = "FORD";
        final String speed = "Speed";
        final String millage = "Millage";
        final String userrating = "User Rating";
        final String safety = "safety";
      
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        dataset.addValue( 1.0 , fiat , speed );
        dataset.addValue( 3.0 , fiat , userrating );
        dataset.addValue( 5.0 , fiat , millage );
        dataset.addValue( 5.0 , fiat , safety );

        dataset.addValue( 5.0 , audi , speed );
        dataset.addValue( 6.0 , audi , userrating );
        dataset.addValue( 10.0 , audi , millage );
        dataset.addValue( 4.0 , audi , safety );

        dataset.addValue( 4.0 , ford , speed );
        dataset.addValue( 2.0 , ford , userrating );
        dataset.addValue( 3.0 , ford , millage );
        dataset.addValue( 6.0 , ford , safety );
           
        
        JFreeChart barChart = ChartFactory.createBarChart(
         "CAR USAGE STATIStICS", 
         "Category", "Score", 
         dataset,PlotOrientation.VERTICAL, 
         false, false, false);
        
        return barChart;
    }

    public ChartPanel getChartPanelBarra() {
        return chartPanelBar;
    }
    
    public void CrearLinea() {
        JFreeChart chartLinea = createDatasetLinea();
        this.chartPanelLine = new ChartPanel(chartLinea);
    }
    
    private JFreeChart  createDatasetLinea() {
         DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        line_chart_dataset.addValue( 15 , "schools" , "1970" );
        line_chart_dataset.addValue( 30 , "schools" , "1980" );
        line_chart_dataset.addValue( 60 , "schools" , "1990" );
        line_chart_dataset.addValue( 120 , "schools" , "2000" );
        line_chart_dataset.addValue( 240 , "schools" , "2010" ); 
        line_chart_dataset.addValue( 300 , "schools" , "2014" );

      JFreeChart lineChartObject = ChartFactory.createLineChart(
         "Schools Vs Years","Year",
         "Schools Count",
         line_chart_dataset,PlotOrientation.VERTICAL,
         true,true,false);
        
        return lineChartObject;
    }

    public ChartPanel getChartPanelLinea() {
        return chartPanelLine;
    }
    
}
