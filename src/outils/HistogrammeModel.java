package outils;
import java.awt.*;


import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;


public class HistogrammeModel{

    public JFrame frame;
    public ChartPanel chartPanel2;
    public HistogrammeModel(String title, double[] vector, int NbrIntervalle) {
        JPanel chartPanel = crearPanel(title,vector,NbrIntervalle);
    }


    static IntervalXYDataset crearDataset(double[] vector, int NbrIntervalle,String nameAttr) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries(nameAttr, vector, NbrIntervalle);
        return dataset;
    }

    JFreeChart crearChart(IntervalXYDataset dataset) {
        JFreeChart chart = ChartFactory.createHistogram(
                "Histogramme",
                "Valeurs",
                "Fréquences d’apparition",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );




        chartPanel2 = new ChartPanel(chart);
        chartPanel2.setPreferredSize(new Dimension(500, 300));
        this.frame = new JFrame("Histogramme ");
        frame.setContentPane(chartPanel2);
        frame.pack();
        //frame.setLocation(100, 100);
        //frame.setLocationRelativeTo(null);
        frame.setBounds(725,230,500,340);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);




        return chart;
    }
    public  JPanel crearPanel(String title,double[] vector, int NbrIntervalle ) {
        JFreeChart chart = crearChart(crearDataset(vector,NbrIntervalle,title));
        return new ChartPanel(chart);
    }

}


