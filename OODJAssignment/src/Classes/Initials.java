/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataAccess.DataAccess;
import java.util.ArrayList;

/**
 *
 * @author kianjun
 */
public class Initials {
    DataAccess da = new DataAccess();
    public String GetInitials(String Username) {
        String initials="";
        String[] parts = Username.split(" ");
        char initial;
        for (String part : parts) {
               initial = part.charAt(0);
               initials= initials+initial;
        }     
        return initials;
    }
    
    public String CategoryID() {
        String CategoryID;
        CategoryID = "CAT"+000+idnumber();
        return CategoryID;
    }
    
    private int idnumber () {
        int num = 1;
        da.setFileName("Category.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num++;
        }
        return num;
    }
    
    public String ProductID() {
        String CategoryID;
        CategoryID = "PR"+000+idnumber1();
        return CategoryID;
    }
    
    private int idnumber1 () {
        int num = 1;
        da.setFileName("Product.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num++;
        }
        return num;
    }
    
    public String memberid(String name) {
        String username;
        String initials="";
        String[] parts = name.split(" ");
        char initial;
        for (String part : parts) {
               initial = part.charAt(0);
               initials= initials+initial;
        }     
        username = initials.toUpperCase()+000+idnumber2();
        return username;
    }
    
    private int idnumber2 () {
        int num = 1;
        da.setFileName("Customer.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num++;
        }
        return num;
    }
    
    public String getAppointID() {
        String AppointID;
        AppointID = "AP"+000+idnumber3();
        return AppointID;
    }
    
    private int idnumber3 () {
        int num = 1;
        da.setFileName("Appointment.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num++;
        }
        return num;
    }
    
    public String getPaymentID() {
        String PaymentID;
        PaymentID = "PAY"+000+idnumber4();
        return PaymentID;
    }
    
    private int idnumber4 () {
        int num = 1;
        da.setFileName("Payment.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num++;
        }
        return num;
    }
    
    public String getFeedbackID() {
        String PaymentID;
        PaymentID = "FE"+000+idnumber5();
        return PaymentID;
    }
    
    private int idnumber5 () {
        int num = 1;
        da.setFileName("Feedback.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num++;
        }
        return num;
    }
    
//    public String getInitials(String name) {
//        String initials="";
//        String[] parts = name.split(" ");
//        char initial;
//        for (String part : parts) {
//               initial = part.charAt(0);
//               initials= initials+initial;
//        }
//        return initials;
//    }
}
