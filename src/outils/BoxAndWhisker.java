package outils;

import java.awt.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.*;
import org.jfree.date.DateUtilities;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;

public class BoxAndWhisker extends JFrame {

    public BoxAndWhisker(ArrayList<ArrayList<Float>> data) {
        super("Box and Whisker Chart");

        final BoxAndWhiskerCategoryDataset dataset = createDataset(data);
        final JFreeChart chart = createChart( dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);

        setContentPane(chartPanel);

    }

    private BoxAndWhiskerCategoryDataset createDataset(ArrayList<ArrayList<Float>> data) {

        final DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();


        ArrayList<Float> T3_resin =new ArrayList<>();
        ArrayList<Float> thyroxin =new ArrayList<>();
        ArrayList<Float> triodothyronine =new ArrayList<>();
        ArrayList<Float> TSH =new ArrayList<>();
        ArrayList<Float> Max_TSH =new ArrayList<>();
        for(ArrayList line : data )
        {
            Row i = new Row(line);
            T3_resin.add(i.getT3_resin());
            thyroxin.add(i.getThyroxin());
            triodothyronine.add(i.getTriodothyronine());
            TSH.add(i.getTSH());
            Max_TSH.add(i.getMax_TSH());
        }
        //BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(T3_resin)
        dataset.add(T3_resin,"","T3_resin");
        dataset.add(thyroxin,"","thyroxin");
        dataset.add(triodothyronine,"","triodothyronine");
        dataset.add(TSH,"","TSH");
        dataset.add(Max_TSH,"","Max_TSH");

        return dataset;

    }

    private JFreeChart createChart(final BoxAndWhiskerCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(
                "Box and Whisker Chart",
                "Attribut",
                "Value",
                dataset,
                true
        );
        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        renderer.setFillBox(true);
        renderer.setAutoPopulateSeriesShape(false);
        renderer.setUseOutlinePaintForWhiskers(true);
        Font legendFont = new Font("SansSerif",Font.PLAIN,16);
        renderer.setLegendTextFont(0,legendFont);
        renderer.setLegendTextFont(1,legendFont);
        renderer.setMedianVisible(true);
        renderer.setMeanVisible(true);
        renderer.setWhiskerWidth(0.5);
        renderer.setMaximumBarWidth(0.15);


        CategoryAxis categoryAxis = new CategoryAxis("Attribut");
        NumberAxis numberAxis = new NumberAxis("Value");
        numberAxis.setAutoRangeIncludesZero(true);


        CategoryPlot plot = new CategoryPlot(dataset,categoryAxis,numberAxis,renderer);
        chart = new JFreeChart(plot);
        chart.setBackgroundPaint(new Color(142, 140, 140));


        return chart;
    }

}

