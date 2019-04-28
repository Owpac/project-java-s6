package test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

public class StudentGradesHistogram
{
    StudentGradesHistogram(String title, Map<String, Double> grades)
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : grades.entrySet())
        {
            String topic = entry.getKey();
            double grade = entry.getValue();
            dataset.addValue(grade, "Grades", topic);
        }

        String xaxis = "grades";
        String yaxis = "number of students";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        boolean show = false;
        boolean toolTips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createBarChart(title, xaxis, yaxis,
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
