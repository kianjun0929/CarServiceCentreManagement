/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technician;

import Config.Global;
import DataAccess.DataAccess;
import Classes.Account;
import Classes.Category;
import Classes.Constant;
import Classes.ChartsAnalysis;
import Classes.TotalRecords;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import oodjassignment.FrmLogin;
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
public class TfrmDashboard extends javax.swing.JFrame {

    DataAccess da = new DataAccess();
    /**
     * Creates new form frmDashboard
     */
    public TfrmDashboard() {
        Constant con = new Constant();
        initComponents();
        this.setLocationRelativeTo(null);
//        txtAppointmentNotification.setVisible(false);
        CurrentDateandTime();
        
        jLabel1.setText(con.LoginAs);
        jLabel2.setText(con.SystemName);
        jLabel14.setText(con.Dashboard);
        jLabel20.setText(Global.role);
        
        lblRole.setText(Global.name);
        
        getAppointment();
        
        TotalRecords TR = new TotalRecords();
        lblTotalAppointment.setText("/" + TR.GetTotalAppointment());
        lblTotalPending.setText(TR.GetTotalCompleteAppointment()+"");
        lblTotalCustomer.setText("/"+ TR.GetTotalCustomer());
        lblTotalCustomerWithoutAppointment.setText(TR.GetTotalCustomerWithoutPayment()+"");
        
        ChartsAnalysis CA = new ChartsAnalysis();
        jPanel5.removeAll();
        jPanel5.add(CA.GetGenderPieCharts());
        
    }

    private void CurrentDateandTime(){
            Thread clock = new Thread() {
            public void run() {
                try {
                    for(;;) {
                        Calendar cal = new GregorianCalendar();
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        txtDate.setText("Date: " +day+"/"+(month+1)+"/"+year);
                        int hour = cal.get(Calendar.HOUR);
                        int minute = cal.get(Calendar.MINUTE);
                        int second = cal.get(Calendar.SECOND);
                        txtTime.setText("Time: "+hour+":"+(minute)+":"+second);
                        sleep(1000);
                    }
                } catch (Exception e) {
                    e.getCause();
                }
            }
        };
            clock.start();
            
        }
    
    public void getAppointment()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try
        {
            da.setFileName("Appointment.txt");
            ArrayList<String> data = da.readAll();
            for(String rec: data) {
                String[] split = rec.split("\\|");
                if(split[3].equals(Global.name) && split[9].equals("PENDING")){
                    jLabel10.setText("You have a new appointment !");
                    txtAppointmentNotification.setText(txtAppointmentNotification.getText() + "\n   Appointment Date and Time: " + split[6] + " from " + split[7] + " to " + split[8] + " with " + split[1]);
                    txtAppointmentNotification.setVisible(true);
                }
            }
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Can't load data from database");
        }
      }
    
//    private void getPieChart() {
//        DefaultPieDataset pieDataSet = new DefaultPieDataset();
//        pieDataSet.setValue("ONE", new Integer(10));
//        pieDataSet.setValue("TWO", new Integer(20));
//        pieDataSet.setValue("THREE", new Integer(30));
//        pieDataSet.setValue("FOUR", new Integer(40));
//        pieDataSet.setValue("FIVE", new Integer(50));
//        JFreeChart chart = ChartFactory.createPieChart("PIE Charts", pieDataSet, true, true, true);
//        PiePlot P = (PiePlot)chart.getPlot();
//        ChartFrame frame = new ChartFrame("PIE Charts", chart);
//        frame.setVisible(true);
//        frame.setSize(450, 500);
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAppointmentNotification = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblTotalPending = new javax.swing.JLabel();
        lblTotalAppointment = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblTotalCustomerWithoutAppointment = new javax.swing.JLabel();
        lblTotalCustomer = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1020, 750));
        setMinimumSize(new java.awt.Dimension(1020, 750));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1020, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 120, 17);

        txtDate.setForeground(new java.awt.Color(255, 255, 255));
        txtDate.setText("jLabel2");
        jPanel1.add(txtDate);
        txtDate.setBounds(10, 720, 110, 16);

        txtTime.setForeground(new java.awt.Color(255, 255, 255));
        txtTime.setText("jLabel2");
        jPanel1.add(txtTime);
        txtTime.setBounds(140, 720, 100, 16);

        lblRole.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblRole.setForeground(new java.awt.Color(102, 255, 0));
        lblRole.setText("jLabel2");
        jPanel1.add(lblRole);
        lblRole.setBounds(10, 40, 200, 40);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Dashboard");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 120, 80, 30);

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));
        jPanel3.setLayout(null);
        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 110, 250, 50);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Manage Category");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(70, 170, 130, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Manage Product");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(80, 220, 120, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Manage Customer");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 270, 130, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Manage Appointment");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 320, 150, 30);

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Manage Payment");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13);
        jLabel13.setBounds(70, 370, 120, 30);

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("PROFILE");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17);
        jLabel17.setBounds(100, 660, 60, 20);

        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("jLabel20");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(140, 10, 100, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 250, 750);

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setForeground(new java.awt.Color(255, 0, 255));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 10, 560, 17);
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 200, 0, 0);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 500, 150, 0);

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel14.setText("jLabel4");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 30, 400, 60);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("LOGOUT");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(30, 10, 70, 19);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(640, 10, 120, 40);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setText("No Appointment !");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 560, 530, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 550, 770, 10);

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 255));

        txtAppointmentNotification.setEditable(false);
        txtAppointmentNotification.setBackground(new java.awt.Color(255, 204, 255));
        txtAppointmentNotification.setColumns(20);
        txtAppointmentNotification.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtAppointmentNotification.setForeground(new java.awt.Color(0, 0, 255));
        txtAppointmentNotification.setLineWrap(true);
        txtAppointmentNotification.setRows(10);
        jScrollPane1.setViewportView(txtAppointmentNotification);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 610, 730, 120);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(null);

        jLabel12.setText("Pending Payment");
        jPanel7.add(jLabel12);
        jLabel12.setBounds(10, 10, 130, 16);

        lblTotalPending.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblTotalPending.setForeground(new java.awt.Color(0, 255, 0));
        lblTotalPending.setText("jLabel5");
        jPanel7.add(lblTotalPending);
        lblTotalPending.setBounds(130, 40, 90, 50);

        lblTotalAppointment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalAppointment.setText("jLabel21");
        jPanel7.add(lblTotalAppointment);
        lblTotalAppointment.setBounds(153, 100, 60, 16);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(20, 110, 220, 120);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

        jLabel15.setText("Appointment");
        jPanel8.add(jLabel15);
        jLabel15.setBounds(10, 30, 120, 16);

        lblTotalCustomerWithoutAppointment.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblTotalCustomerWithoutAppointment.setForeground(new java.awt.Color(0, 255, 0));
        lblTotalCustomerWithoutAppointment.setText("jLabel5");
        jPanel8.add(lblTotalCustomerWithoutAppointment);
        lblTotalCustomerWithoutAppointment.setBounds(130, 40, 90, 50);

        lblTotalCustomer.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalCustomer.setText("jLabel21");
        jPanel8.add(lblTotalCustomer);
        lblTotalCustomer.setBounds(160, 100, 53, 16);

        jLabel16.setText("Customer without");
        jPanel8.add(jLabel16);
        jLabel16.setBounds(10, 10, 120, 16);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(260, 110, 220, 120);

        jPanel5.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.add(jPanel5);
        jPanel5.setBounds(20, 240, 360, 300);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(250, 0, 770, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        FrmLogin frmLogin = new FrmLogin();
        try {
            int confirmed = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to logout?", "Account Logout", JOptionPane.YES_NO_OPTION);
            if(confirmed == JOptionPane.YES_OPTION)
            {
                Account account = new Account();
                account.logout(Global.user_login_id);
                frmLogin.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Invalid logged out. Please launch the program from login page.");
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        FrmCategory frmCategory = new FrmCategory();
        frmCategory.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        new FrmProduct().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new FrmCustomer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new FrmAppointment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        new FrmPayment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        try {
            // TODO add your handling code here:
            new PROFILE().setVisible(true);
            this.dispose();
        } catch (ParseException ex) {
            Logger.getLogger(TfrmDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TfrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TfrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TfrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TfrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TfrmDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTotalAppointment;
    private javax.swing.JLabel lblTotalCustomer;
    private javax.swing.JLabel lblTotalCustomerWithoutAppointment;
    private javax.swing.JLabel lblTotalPending;
    private javax.swing.JTextArea txtAppointmentNotification;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables
}
