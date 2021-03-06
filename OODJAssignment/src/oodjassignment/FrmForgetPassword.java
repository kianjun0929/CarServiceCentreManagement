/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;

import Config.Global;
import Classes.Account;
import Classes.Admin;
import Classes.Constant;
import Classes.User;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author kianjun
 */
public class FrmForgetPassword extends javax.swing.JFrame {

    /**
     * Creates new form frmForgetPassword
     */
    public FrmForgetPassword() {
        Constant con = new Constant();
        initComponents();
        this.setLocationRelativeTo(null);
        CurrentDateandTime();

        lblSystemName.setText(con.SystemName);
        jLabel6.setText(con.Username);
        jLabel4.setText(con.Question);
        jLabel7.setText(con.Answer);
        jLabel8.setText(con.Password);

    }

    public void CurrentDateandTime() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    for (;;) {
                        Calendar cal = new GregorianCalendar();
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        txtDate.setText("Date: " + day + "/" + (month + 1) + "/" + year);
                        int hour = cal.get(Calendar.HOUR);
                        int minute = cal.get(Calendar.MINUTE);
                        int second = cal.get(Calendar.SECOND);
                        txtTime.setText("Time: " + hour + ":" + (minute) + ":" + second);
                        sleep(1000);
                    }
                } catch (Exception e) {
                    e.getCause();
                }
            }
        };
        clock.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSystemName = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCheck = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtQuestion = new javax.swing.JTextField();
        txtAnswer = new javax.swing.JTextField();
        btnBack = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 750));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1020, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        lblSystemName.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        lblSystemName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblSystemName);
        lblSystemName.setBounds(30, 70, 970, 70);

        txtDate.setForeground(new java.awt.Color(255, 255, 255));
        txtDate.setText("jLabel2");
        jPanel1.add(txtDate);
        txtDate.setBounds(10, 690, 190, 16);

        txtTime.setForeground(new java.awt.Color(255, 255, 255));
        txtTime.setText("jLabel2");
        jPanel1.add(txtTime);
        txtTime.setBounds(10, 720, 200, 16);

        jPanel4.setBackground(new java.awt.Color(153, 0, 153));
        jPanel4.setLayout(null);

        txtPassword.setEditable(false);
        txtPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        jPanel4.add(txtPassword);
        txtPassword.setBounds(20, 330, 450, 60);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel4);
        jLabel4.setBounds(20, 110, 140, 20);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel6);
        jLabel6.setBounds(20, 10, 140, 20);

        btnCheck.setBackground(new java.awt.Color(102, 255, 51));
        btnCheck.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnCheck.setText("CHECK");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        jPanel4.add(btnCheck);
        btnCheck.setBounds(20, 400, 450, 60);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel7);
        jLabel7.setBounds(20, 210, 140, 20);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel8);
        jLabel8.setBounds(20, 300, 140, 20);

        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        jPanel4.add(txtUsername);
        txtUsername.setBounds(20, 40, 450, 60);

        txtQuestion.setEditable(false);
        txtQuestion.setForeground(new java.awt.Color(102, 102, 102));
        txtQuestion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuestionFocusLost(evt);
            }
        });
        jPanel4.add(txtQuestion);
        txtQuestion.setBounds(20, 140, 450, 60);

        txtAnswer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnswerFocusLost(evt);
            }
        });
        jPanel4.add(txtAnswer);
        txtAnswer.setBounds(20, 230, 450, 60);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 160, 500, 490);

        btnBack.setBackground(new java.awt.Color(255, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 51, 0));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        btnBack.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel5.setText("BACK");
        btnBack.add(jLabel5);
        jLabel5.setBounds(40, 10, 40, 19);

        jPanel1.add(btnBack);
        btnBack.setBounds(880, 10, 110, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/AASC logo.PNG"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 160, 445, 490);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1020, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        try {
            String answer = txtAnswer.getText().toUpperCase();
            if (answer.equals(Global.answer)) {
                txtPassword.setText(Global.password);
            } else {
                JOptionPane.showMessageDialog(rootPane, "You have entered an incorrect security answer.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        new FrmLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost

        String Username = txtUsername.getText();
        Admin admin = new Admin();
        admin.setAcc(new Account(Username));

        Account account = new Account();
        if (account.forgetPassword(Username)) {
            txtQuestion.setText(Global.question);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please enter a valid username.");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtQuestionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuestionFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuestionFocusLost

    private void txtAnswerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnswerFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswerFocusLost

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
            java.util.logging.Logger.getLogger(FrmForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBack;
    private javax.swing.JButton btnCheck;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JLabel txtDate;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtQuestion;
    private javax.swing.JLabel txtTime;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
