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
public class TotalRecords {
    DataAccess da = new DataAccess();
//    public int GetTotalRecords () {
//        int num = 1;
//        da.setFileName("CustomerDetails.txt");
//        ArrayList<String> data = da.readAll();
//        for(String rec: data ) {
//            num++;
//        }
//        return num;
//    }
    
    public int GetTotalAppointment () {
        int num = 0;
        da.setFileName("Appointment.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            num++;
        }
        return num;
    }
    
    public int GetTotalCustomer () {
        int num = 0;
        da.setFileName("Customer.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            num++;
        }
        return num;
    }
    
    public double GetTotalPayment (){
        double total = 0.0;
        double num;
        da.setFileName("Payment.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num = Double.parseDouble(split[11]);
            total = total + num;
        }
        return total;
    }
    
    public int GetTotalCustomerWithoutPayment () {
        int num = 0;
        da.setFileName("Customer.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            if(split[9].equals("N/A") && split[10].equals("ACTIVE")) {
                num++;
            }
            
        }
        return num;
    }
    
    public int GetTotalCompleteAppointment () {
        int num = 0;
        da.setFileName("Appointment.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            if(split[9].equals("PENDING")) {
                num++;
            }
            
        }
        return num;
    }
    
    public int GetTotalActivate () {
        int num = 0;
        da.setFileName("user.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            if(split[7].equals("ACTIVE")) {
                num++;
            }
        }
        return num;
    }
    
    public int GetTotalActivateCategory () {
        int num = 0;
        da.setFileName("Category.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            if(split[5].equals("ACTIVE")) {
                num++;
            }
        }
        return num;
    }
    
    public int GetTotalActivateProduct () {
        int num = 0;
        da.setFileName("Product.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            if(split[7].equals("ACTIVE")) {
                num++;
            }
        }
        return num;
    }
    
    public int GetTotalUser() {
        int num = 0;
        da.setFileName("user.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num++;
        }
        return num;
    }
    
    public int GetTotalCategory() {
        int num = 0;
        da.setFileName("Category.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            num++;
        }
        return num;
    }
    
    public int GetTotalProduct () {
        int num = 0;
        da.setFileName("Product.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data ) {
            String[] split = rec.split("\\|");
            if(split[7].equals("ACTIVE")) {
                num++;
            }
        }
        return num;
    }
    
}
