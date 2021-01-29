/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataAccess.DataAccess;
import Technician.TfrmDashboard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author kianjun
 */
public class ChartsAnalysis {

    DataAccess da = new DataAccess();

    public ChartPanel GetGenderPieCharts() {
        da.setFileName("Customer.txt");
        ArrayList<String> data = da.readAll();
        int numOfMales = 0, numOfFemales = 0;
        for (String rec : data) {
            String[] split = rec.split("\\|");
            if (split[10].equals("ACTIVE")) {
                if (split[4].equals("MALE")) {
                    numOfMales++;
                } else {
                    numOfFemales++;
                }
            }

        }
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        pieDataSet.setValue("MALE", new Integer(numOfMales));
        pieDataSet.setValue("FEMALE", new Integer(numOfFemales));
        JFreeChart chart = ChartFactory.createPieChart("Gender Pie Charts", pieDataSet, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        ChartPanel frame = new ChartPanel(chart);
        frame.setPreferredSize(new java.awt.Dimension(350, 300));
        return frame;

    }

    public ChartPanel GetFeedbackBarCharts(String CategoryName) {
        da.setFileName("Feedback.txt");
        ArrayList<String> data = da.readAll();
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        for (String rec : data) {
            String[] split = rec.split("\\|");
            if (split[2].equals(CategoryName)) {
                int rate = Integer.parseInt(split[4]);
                switch (rate) {
                    case 1:
                        ones++;
                        break;
                    case 2:
                        twos++;
                        break;
                    case 3:
                        threes++;
                        break;
                    case 4:
                        fours++;
                        break;
                    default:
                        fives++;
                        break;
                }
            }
        }
        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        barchartdata.setValue(ones, "Rating", "Not at all satisfied");
        barchartdata.setValue(twos, "Rating", "Partly satisfied");
        barchartdata.setValue(threes, "Rating", "Satisfied");
        barchartdata.setValue(fours, "Rating", "More than satisfied");
        barchartdata.setValue(fives, "Rating", "Very satisfied");
        JFreeChart barchart = ChartFactory.createBarChart("Feedback Rating", "Rating", "Amount", barchartdata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barchart1 = barchart.getCategoryPlot();
        barchart1.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel barPanel1 = new ChartPanel(barchart);
        return barPanel1;
    }

    public ChartPanel GetPaymentCharts(int num) {
        String pattern = "dd/MM/yyyy";
        String[] date = new String[num];
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < date.length; i++) {
            c.add(Calendar.DAY_OF_MONTH, -1);
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date[i] = sdf.format(c.getTime());
        }

        da.setFileName("Payment.txt");
        ArrayList<String> data = da.readAll();
        int dayone = 0, daytwo = 0, daythree = 0, dayfour = 0, dayfive = 0, daysix = 0, dayseven = 0;
        for (String rec : data) {
            String[] split = rec.split("\\|");
//            for (int i = 0; i < date.length; i++) {
            double total = Double.parseDouble(split[11]);
            if (split[10].equals(date[0])) {
                dayone += total;
            } else if (split[10].equals(date[1])) {
                daytwo += total;
            } else if (split[10].equals(date[2])) {
                daythree += total;
            } else if (split[10].equals(date[3])) {
                dayfour += total;
            } else if (split[10].equals(date[4])) {
                dayfive += total;
            } else if (split[10].equals(date[5])) {
                daysix += total;
            } else {
                dayseven += total;
            }
//            }
        }
        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        barchartdata.setValue(dayone, "Amount", date[0]);
        barchartdata.setValue(daytwo, "Amount", date[1]);
        barchartdata.setValue(daythree, "Amount", date[2]);
        barchartdata.setValue(dayfour, "Amount", date[3]);
        barchartdata.setValue(dayfive, "Amount", date[4]);
        barchartdata.setValue(daysix, "Amount", date[5]);
        barchartdata.setValue(dayseven, "Amount", date[6]);
        JFreeChart barchart = ChartFactory.createAreaChart("Past Seven days", "Days", "Amount", barchartdata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barchart1 = barchart.getCategoryPlot();
        barchart1.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel barPanel1 = new ChartPanel(barchart);
        return barPanel1;
    }

    public ChartPanel GetPaymentCharts3(int num) {
        String pattern = "dd/MM/yyyy";
        String[] date = new String[num];
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < date.length; i++) {
            c.add(Calendar.DAY_OF_MONTH, -1);
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date[i] = sdf.format(c.getTime());
        }

        da.setFileName("Payment.txt");
        ArrayList<String> data = da.readAll();
        int dayone = 0, daytwo = 0, daythree = 0;
        for (String rec : data) {
            String[] split = rec.split("\\|");
            double total = Double.parseDouble(split[11]);
            if (split[10].equals(date[0])) {
                dayone += total;
            } else if (split[10].equals(date[1])) {
                daytwo += total;
            } else if (split[10].equals(date[2])) {
                daythree += total;
            }
        }
        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        barchartdata.setValue(dayone, "Amount", date[0]);
        barchartdata.setValue(daytwo, "Amount", date[1]);
        barchartdata.setValue(daythree, "Amount", date[2]);
        JFreeChart barchart = ChartFactory.createAreaChart("Past Three days", "Days", "Amount", barchartdata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barchart1 = barchart.getCategoryPlot();
        barchart1.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel barPanel1 = new ChartPanel(barchart);
        return barPanel1;
    }

}
