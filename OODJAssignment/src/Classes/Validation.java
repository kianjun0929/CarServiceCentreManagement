/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Config.Global;
import DataAccess.DataAccess;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kianjun
 */
public class Validation {
    DataAccess da = new DataAccess();
    public boolean checkUser(String uid){
        boolean success=false;
        da.setFileName("user.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[0].equals(uid)){
                //if found;
                success=false;
                break;
            } else {
                success=true;
            }
        }
        if(data.isEmpty()) {
            success = true;
        }
        return success;
    }
    
    public boolean checkCustomer(String CustomerIC){
        boolean success=false;
        da.setFileName("Customer.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[1].equals(CustomerIC)){
                //if found;
                success=false;
                break;
            } else {
                success=true;
            }
        }
        if(data.isEmpty()) {
            success = true;
        }
        return success;
    }

    
    public boolean checkpassword(String password) {
        if(password.length() >= 8 && password.length() <= 16) {
            return true;
        } else {
            return false;
        } 
    }
    
    public boolean checkDOB(String DOB) throws ParseException {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String regDate = new SimpleDateFormat(pattern).format(new Date());
        Date regdate = sdf.parse(regDate);
        Date dob = sdf.parse(DOB);
        if(regdate.compareTo(dob) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkAppointmentDate(String AppointmentDate) throws ParseException {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String regDate = new SimpleDateFormat(pattern).format(new Date());
        Date regdate = sdf.parse(regDate);
        Date appointmentDate = sdf.parse(AppointmentDate);
        if(regdate.compareTo(appointmentDate) <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkCategoryName(String CategoryName){
        boolean success=false;
        da.setFileName("Category.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[1].equals(CategoryName)){
                //if found;
                success=false;
                break;
            } else {
                success=true;
            }
        }
        if(data.isEmpty()) {
            success = true;
        }
        return success;
    }
    
    public boolean checkProductName(String ProductName){
        boolean success=false;
        da.setFileName("Product.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[2].equals(ProductName)){
                //if found;
                success=false;
                break;
            } else {
                success=true;
            }
        }
        
        
        if(data.isEmpty()) {
            success = true;
        }
        return success;
    }
    
    public boolean isValid(String email) {
          String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
          return email.matches(regex);
    }
    
    public boolean isDouble(String Price) {
        try {
            Double.parseDouble(Price);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isInt(String Quantity) {
        try {
            Double.parseDouble(Quantity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean checkTechnician (String TechnicianName) {
        da.setFileName("Appointment.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[3].equals(TechnicianName) && split[8].equals("PENDING")) {
                return false;
            }
        }
        return true;
    }
    
//    public boolean checkAvailable(String TechnicianName, String StartTime, String AppointmentDate) {
//        boolean success = true;
//        int startTime = Integer.parseInt(StartTime);
//        da.setFileName("Appointment.txt");
//        ArrayList<String> data = da.readAll();
//        for(String rec: data) {
//            String[] split = rec.split("\\|");
//            if(split[9].equals("PENDING")){
//                if(split[3].equals(TechnicianName)) {
//                    int EndTime = Integer.parseInt(split[8]);
//                    if(split[6].equals(AppointmentDate)) {
//                        if(EndTime > startTime) {
//                            success = false;
//                        }
//                    }
//                } 
//            }
//        if(data.isEmpty()) {
//                success = true;
//            }
//        }
//        return success;
//    }
    
    public static boolean adminCheck(String uname, String pass) {
        if(Global.login_id.equals(uname) && Global.password.equals(pass)) {
            return true;
        } else {
            return false;
        }
    }
}
