/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technician;

import DataAccess.DataAccess;
import Classes.Constant;
import Classes.Initials;
import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kianjun
 */
public class FrmPaymentMethod extends javax.swing.JFrame {

    private static String AppointmentID;
    DataAccess da = new DataAccess();

    /**
     * Creates new form frmPaymentMethod
     */
    public FrmPaymentMethod(String AppointmentID) {
        this.AppointmentID = AppointmentID;
        Constant con = new Constant();
        Initials GetInitials = new Initials();
        initComponents();
        this.setLocationRelativeTo(null);

        jLabel2.setText(con.SystemName);
        jLabel14.setText(con.PaymentMethod);

        txtAppointmentID.setText(AppointmentID);

        txtReferenceNum.setVisible(false);
        getDetails(AppointmentID);
    }

    private void getDetails(String AppointmentID) {
        da.setFileName("Payment.txt");
        ArrayList<String> data = da.readAll();
        for (String rec : data) {
            String[] split = rec.split("\\|");
            if (split[1].equals(AppointmentID)) {
                txtCustomerName.setText(split[2]);
                txtCategoryName.setText(split[3]);
                txtCategoryPrice.setText(split[4]);
                txtAppointmentDateTime.setText(split[5] + split[6]);
                txtProductName.setText(split[7]);
                txtProductPrice.setText(split[8]);
                txtQuantity.setText(split[9]);
                txtTotal.setText(split[11]);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtCategoryName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtReferenceNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAppointmentID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtCategoryPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAppointmentDateTime = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPayAmount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(770, 750));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(770, 750));
        getContentPane().setLayout(null);

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

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel18.setText("Payment Method");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(10, 120, 130, 17);

        btnPay.setText("PAY");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        jPanel2.add(btnPay);
        btnPay.setBounds(640, 690, 120, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Debit or Credit Cards", "Online Payment" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(230, 110, 230, 40);

        txtCategoryName.setEditable(false);
        jPanel2.add(txtCategoryName);
        txtCategoryName.setBounds(230, 270, 220, 40);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Category Name");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 280, 130, 20);
        jPanel2.add(txtReferenceNum);
        txtReferenceNum.setBounds(480, 110, 230, 40);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Appointment ID");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 160, 130, 20);

        txtAppointmentID.setEditable(false);
        jPanel2.add(txtAppointmentID);
        txtAppointmentID.setBounds(230, 150, 220, 40);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Customer Name");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 240, 130, 20);

        txtCustomerName.setEditable(false);
        jPanel2.add(txtCustomerName);
        txtCustomerName.setBounds(230, 230, 220, 40);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Product Name");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 360, 130, 20);

        txtProductName.setEditable(false);
        jPanel2.add(txtProductName);
        txtProductName.setBounds(230, 350, 220, 40);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Total");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 480, 160, 20);

        txtQuantity.setEditable(false);
        jPanel2.add(txtQuantity);
        txtQuantity.setBounds(230, 430, 220, 40);

        txtCategoryPrice.setEditable(false);
        jPanel2.add(txtCategoryPrice);
        txtCategoryPrice.setBounds(280, 310, 170, 40);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("Category Price ");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 320, 160, 20);

        txtAppointmentDateTime.setEditable(false);
        jPanel2.add(txtAppointmentDateTime);
        txtAppointmentDateTime.setBounds(230, 190, 220, 40);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Appointment Date and Time");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 200, 210, 20);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setText("How much you bought");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 440, 160, 20);

        jLabel12.setText("RM");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(240, 400, 40, 16);

        txtTotal.setForeground(new java.awt.Color(255, 0, 51));
        txtTotal.setText("jLabel13");
        jPanel2.add(txtTotal);
        txtTotal.setBounds(280, 480, 53, 16);

        jLabel15.setText("RM");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(240, 550, 40, 16);

        txtPayAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPayAmountKeyTyped(evt);
            }
        });
        jPanel2.add(txtPayAmount);
        txtPayAmount.setBounds(280, 540, 170, 40);

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel16.setText("Product Price");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(10, 400, 130, 20);

        jLabel17.setText("RM");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(240, 320, 40, 16);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 530, 770, 12);

        jLabel13.setText("Pay Amount:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 550, 90, 16);

        jLabel19.setText("RM");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(240, 480, 40, 16);

        txtProductPrice.setEditable(false);
        jPanel2.add(txtProductPrice);
        txtProductPrice.setBounds(280, 390, 170, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 770, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        try {
            double Total = Double.parseDouble(txtTotal.getText());
            double PayAmount = Double.parseDouble(txtPayAmount.getText());
            if (PayAmount >= Total) {
                AppointmentID = txtAppointmentID.getText();
                new FrmFeedback(AppointmentID).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please pay what you bought !");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Please make sure you entered the pay amount fields !");
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int num = jComboBox1.getSelectedIndex();
        if (num == 2) {
            txtReferenceNum.setVisible(true);
        } else {
            txtReferenceNum.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtPayAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPayAmountKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((Character.isLetter(c)) || (c == KeyEvent.VK_BACKSPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPayAmountKeyTyped

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
            java.util.logging.Logger.getLogger(FrmPaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPaymentMethod(AppointmentID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAppointmentDateTime;
    private javax.swing.JTextField txtAppointmentID;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextField txtCategoryPrice;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtPayAmount;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReferenceNum;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
