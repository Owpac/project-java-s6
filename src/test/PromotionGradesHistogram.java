package test;

import java.io.*;
import java.util.Random;

import org.jfree.chart.*;
import org.jfree.data.statistics.*;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.*;

public class PromotionGradesHistogram
{
    public PromotionGradesHistogram(String title, double[] grades)
    {
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries("Histogram", grades, 20, 0.0, 20.0);
        String xaxis = "grades";
        String yaxis = "number of students";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        boolean show = false;
        boolean toolTips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createHistogram(title, xaxis, yaxis,
                                                        dataset, orientation, show, toolTips, urls);
        int width = 500;
        int height = 300;

        JFrame jFrame = new JFrame(title);
        ChartPanel panel = new ChartPanel(chart);
        jFrame.add(panel);
        jFrame.setSize(width, height);
        jFrame.setVisible(true);
    }
}
