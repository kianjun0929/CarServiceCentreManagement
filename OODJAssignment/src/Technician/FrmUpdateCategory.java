/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technician;

import Config.Global;
import DataAccess.DataAccess;
import Classes.Category;
import Classes.Constant;
import Classes.Initials;
import Classes.User;
import Manager.MfrmDashboard;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import oodjassignment.FrmLogin;

/**
 *
 * @author kianjun
 */
public class FrmUpdateCategory extends javax.swing.JFrame {

    private static String CategoryID, CategoryName, CategoryDescription, CategoryAddedDate, Price, Status;
    /**
     * Creates new form frmUpdateCategory
     */
    public FrmUpdateCategory(String CategoryID, String CategoryName, String CategoryDescription, String regDate, String Price, String Status) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.CategoryDescription = CategoryDescription;
        this.CategoryAddedDate = regDate;
        this.Price = Price;
        this.Status = Status;
        DataAccess da = new DataAccess();
        ArrayList<String> data=null;
        Constant con = new Constant();
        Initials GetInitials = new Initials();
        initComponents();
        this.setLocationRelativeTo(null);

        jLabel2.setText(con.SystemName);
        jLabel14.setText(con.UpdateCategory);
        
        txtCategoryID.setText(GetInitials.CategoryID());
        
        getDetails();
    }

    private void getDetails() {
        txtCategoryID.setText(CategoryID);
        txtCategoryName.setText(CategoryName);
        txtCategoryDescription.setText(CategoryDescription);
        txtDateAdded.setText(CategoryAddedDate);
        txtPrice.setText(Price);
        lblStatus.setText(Status);
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
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCategoryID = new javax.swing.JTextField();
        txtCategoryName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCategoryDescription = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtDateAdded = new javax.swing.JTextField();
        btnDeactivate = new javax.swing.JButton();
        btnActivate = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

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

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("BACK");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(40, 10, 50, 19);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(640, 10, 120, 40);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Category Name");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 160, 130, 17);

        txtCategoryID.setEditable(false);
        txtCategoryID.setForeground(new java.awt.Color(153, 153, 153));
        txtCategoryID.setText("AUTO-GENRATED");
        jPanel2.add(txtCategoryID);
        txtCategoryID.setBounds(180, 110, 240, 40);

        txtCategoryName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCategoryNametxtUserIDFocusLost(evt);
            }
        });
        jPanel2.add(txtCategoryName);
        txtCategoryName.setBounds(180, 150, 240, 40);

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel18.setText("Category ID");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(10, 120, 110, 17);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setText("Category Description");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 200, 160, 17);
        jPanel2.add(txtCategoryDescription);
        txtCategoryDescription.setBounds(180, 190, 240, 40);

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel19.setText("Status");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(440, 120, 110, 17);

        lblStatus.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(51, 204, 0));
        lblStatus.setText("ACTIVE");
        jPanel2.add(lblStatus);
        lblStatus.setBounds(530, 120, 70, 17);

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate);
        btnUpdate.setBounds(640, 690, 120, 50);

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel15.setText("Date Added");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 240, 150, 17);

        txtDateAdded.setEditable(false);
        txtDateAdded.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.add(txtDateAdded);
        txtDateAdded.setBounds(180, 230, 240, 40);

        btnDeactivate.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.select"));
        btnDeactivate.setText("DEACTIVATE");
        btnDeactivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeactivateActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeactivate);
        btnDeactivate.setBounds(160, 690, 140, 50);

        btnActivate.setBackground(java.awt.Color.green);
        btnActivate.setText("ACTIVATE");
        btnActivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateActionPerformed(evt);
            }
        });
        jPanel2.add(btnActivate);
        btnActivate.setBounds(10, 690, 140, 50);

        txtPrice.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.add(txtPrice);
        txtPrice.setBounds(520, 150, 230, 40);

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel22.setText("Price");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(440, 160, 70, 17);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 770, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateActionPerformed
        // TODO add your handling code here:
        String CategoryID = txtCategoryID.getText();
        String CategoryName = txtCategoryName.getText();
        String CategoryDescription = txtCategoryDescription.getText();
        String DateAdded = txtDateAdded.getText();
        String Price = txtPrice.getText();
        String Status = lblStatus.getText();
        
        ArrayList<String> CategoryDetails;
        CategoryDetails = new ArrayList<>();
        CategoryDetails.add(CategoryID);
        CategoryDetails.add(CategoryName);
        CategoryDetails.add(CategoryDescription);
        CategoryDetails.add(DateAdded);
        CategoryDetails.add(Price);
        CategoryDetails.add("ACTIVE");
        Category category = new Category(CategoryDetails);
//        Category category = new Category(CategoryID, CategoryName, CategoryDescription, DateAdded, Price, "ACTIVE");
        category.Update();

        if(Global.role.equals("MANAGER")) {
            new MfrmDashboard().setVisible(true);
        } else {
            new TfrmDashboard().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnActivateActionPerformed

    private void btnDeactivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeactivateActionPerformed
        // TODO add your handling code here:
        String CategoryID = txtCategoryID.getText();
        String CategoryName = txtCategoryName.getText();
        String CategoryDescription = txtCategoryDescription.getText();
        String DateAdded = txtDateAdded.getText();
        String Price = txtPrice.getText();
        
        ArrayList<String> CategoryDetails;
        CategoryDetails = new ArrayList<>();
        CategoryDetails.add(CategoryID);
        CategoryDetails.add(CategoryName);
        CategoryDetails.add(CategoryDescription);
        CategoryDetails.add(DateAdded);
        CategoryDetails.add(Price);
        CategoryDetails.add("INACTIVE");
        Category category = new Category(CategoryDetails);
        
//        Category category = new Category(CategoryID, CategoryName, CategoryDescription, DateAdded, Price, "INACTIVE");
        category.Update();

        if(Global.role.equals("MANAGER")) {
            new MfrmDashboard().setVisible(true);
        } else {
            new TfrmDashboard().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnDeactivateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String CategoryID = txtCategoryID.getText();
        String CategoryName = txtCategoryName.getText();
        String CategoryDescription = txtCategoryDescription.getText();
        String DateAdded = txtDateAdded.getText();
        String Price = txtPrice.getText();
        String Status = lblStatus.getText();
        
        ArrayList<String> CategoryDetails;
        CategoryDetails = new ArrayList<>();
        CategoryDetails.add(CategoryID);
        CategoryDetails.add(CategoryName);
        CategoryDetails.add(CategoryDescription);
        CategoryDetails.add(DateAdded);
        CategoryDetails.add(Price);
        CategoryDetails.add(Status);
        Category category = new Category(CategoryDetails);
        
//        Category category = new Category(CategoryID, CategoryName, CategoryDescription, DateAdded, Price, Status);
        category.Update();

        if(Global.role.equals("MANAGER")) {
            new MfrmDashboard().setVisible(true);
        } else {
            new TfrmDashboard().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtCategoryNametxtUserIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCategoryNametxtUserIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryNametxtUserIDFocusLost

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        if(Global.role.equals("MANAGER")) {
            new MfrmDashboard().setVisible(true);
        } else {
            new TfrmDashboard().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

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
            java.util.logging.Logger.getLogger(FrmUpdateCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUpdateCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUpdateCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUpdateCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUpdateCategory(CategoryID, CategoryName, CategoryDescription, CategoryAddedDate, Price, Status).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActivate;
    public javax.swing.JButton btnDeactivate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel lblStatus;
    public javax.swing.JTextField txtCategoryDescription;
    public javax.swing.JTextField txtCategoryID;
    public javax.swing.JTextField txtCategoryName;
    public javax.swing.JTextField txtDateAdded;
    public javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
