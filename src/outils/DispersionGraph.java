package outils;


import java.awt.*;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.PolynomialFunction2D;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class DispersionGraph extends JFrame{

    public JFrame frame;

    public DispersionGraph(ArrayList<ArrayList<Float>> listrecu, String attr1, String attr2)
    {
        XYPlot plot = new XYPlot();

        XYDataset scatterPlotDataset = getScatterPlotDataset( listrecu, attr1, attr2);
        plot.setDataset(0, scatterPlotDataset);
        plot.setRenderer(0, new XYLineAndShapeRenderer(false, true));
        plot.setDomainAxis(0, new NumberAxis(attr2));
        plot.setRangeAxis(0, new NumberAxis(attr1));
        plot.mapDatasetToDomainAxis(0, 0);
        plot.mapDatasetToRangeAxis(0, 0);


        JFreeChart chart = new JFreeChart(
                "Diagramme de dispersion",
                JFreeChart.DEFAULT_TITLE_FONT, plot,
                true
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        frame = new JFrame("Diagramme de dispersion ");
        frame.setContentPane(chartPanel);
        frame.pack();
        //frame.setLocation(100, 100);
        //frame.setLocationRelativeTo(null);
        frame.setBounds(725,230,500,340);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);


    }




    private XYDataset getScatterPlotDataset(ArrayList<ArrayList<Float>> listrecu, String attr1, String attr2)
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries("Scatterplot");

        for (ArrayList<Float> line:listrecu) {
            Row i = new Row(line);

            if (attr1.equals("thyroid-stimulating hormone") && attr2.equals("T3_resin")) {
                data.add(i.getTSH(), i.getT3_resin());
            } else if (attr1.equals("thyroid-stimulating hormone") && attr2.equals("thyroxin")) {
                data.add(i.getTSH(), i.getThyroxin());
            } else if (attr1.equals("thyroid-stimulating hormone") && attr2.equals("triodothyronine")) {
                data.add(i.getTSH(), i.getTriodothyronine());
            } else if (attr1.equals("thyroid-stimulating hormone") && attr2.equals("Maximal absolute difference of TSH")) {
                data.add(i.getTSH(), i.getMax_TSH());


            } else if (attr1.equals("Maximal absolute difference of TSH") && attr2.equals("T3_resin")) {
                data.add(i.getMax_TSH(), i.getT3_resin());
            } else if (attr1.equals("Maximal absolute difference of TSH") && attr2.equals("thyroxin")) {
                data.add(i.getMax_TSH(), i.getThyroxin());
            } else if (attr1.equals("Maximal absolute difference of TSH") && attr2.equals("triodothyronine")) {
                data.add(i.getMax_TSH(), i.getTriodothyronine());
            } else if (attr1.equals("Maximal absolute difference of TSH") && attr2.equals("thyroid-stimulating hormone")) {
                data.add(i.getMax_TSH(), i.getTSH());


            } else if (attr1.equals("T3_resin") && attr2.equals("Maximal absolute difference of TSH")) {
                data.add(i.getT3_resin(), i.getMax_TSH());
            } else if (attr1.equals("T3_resin") && attr2.equals("thyroxin")) {
                data.add(i.getT3_resin(), i.getThyroxin());
            } else if (attr1.equals("T3_resin") && attr2.equals("triodothyronine")) {
                data.add(i.getT3_resin(), i.getTriodothyronine());
            } else if (attr1.equals("T3_resin") && attr2.equals("thyroid-stimulating hormone")) {
                data.add(i.getT3_resin(), i.getTSH());


            } else if (attr1.equals("thyroxin") && attr2.equals("T3_resin")) {
                data.add(i.getThyroxin(), i.getT3_resin());
            } else if (attr1.equals("thyroxin") && attr2.equals("Maximal absolute difference of TSH")) {
                data.add(i.getThyroxin(), i.getMax_TSH());
            } else if (attr1.equals("thyroxin") && attr2.equals("triodothyronine")) {
                data.add(i.getThyroxin(), i.getTriodothyronine());
            } else if (attr1.equals("thyroxin") && attr2.equals("thyroid-stimulating hormone")) {
                data.add(i.getThyroxin(), i.getTSH());


            } else if (attr1.equals("triodothyronine") && attr2.equals("T3_resin")) {
                data.add(i.getTriodothyronine(), i.getT3_resin());
            } else if (attr1.equals("triodothyronine") && attr2.equals("thyroxin")) {
                data.add(i.getTriodothyronine(), i.getThyroxin());
            } else if (attr1.equals("triodothyronine") && attr2.equals("Maximal absolute difference of TSH")) {
                data.add(i.getTriodothyronine(), i.getMax_TSH());
            } else if (attr1.equals("triodothyronine") && attr2.equals("thyroid-stimulating hormone")) {
                data.add(i.getTriodothyronine(), i.getTSH());
            }

        }

        dataset.addSeries(data);
        return dataset;
    }
}
