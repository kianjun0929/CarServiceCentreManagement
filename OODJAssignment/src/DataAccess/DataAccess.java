/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kianjun
 */
public class DataAccess {
    private File fileName;
    
    public void setFileName(String fn) {
        fileName = new File(fn);
    }
    
    public boolean write(String record) {
        try (PrintWriter write = new PrintWriter(new FileWriter(fileName, true))){
            write.println(record);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<String> readAll(){
        ArrayList<String> list = new ArrayList();
        try (Scanner scan = new Scanner(this.fileName)){
            while(scan.hasNext()){
                String line = scan.nextLine();
                list.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public void update(String user_login_id, String name, String record){
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", user_login_id, name, record);//new record
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(user_login_id)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    
    public void clearlogs(){
        if(this.fileName.exists()) {
            this.fileName.delete();
            try {
                this.fileName.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateCategory(String CategoryID, String CategoryName, String CategoryDescription, String DateAdded, String Price, String Status){
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", CategoryID, CategoryName, CategoryDescription, DateAdded, Price, Status);//new record
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(CategoryID)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    
    public void updateUser(String UserID, String Username, String DOB, String Password, String Role, String Question, String Answer, String Status){
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", UserID, Username, DOB, Password, Role, Question, Answer, Status);//new record
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(UserID)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    
    public void updateProduct(String ProductID, String CategoryName, String ProductName, String ProductDescription, String DateAdded, String Price, String Quantity, String Status){
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", ProductID, CategoryName, ProductName, ProductDescription, DateAdded, Price, Quantity, Status);//new record
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(ProductID)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    
    public void updateCustomer(String CustomerID, String CustomerIC, String CustomerName, String DOB, String Gender, String Email, String Phone, String Address, String regDate, String BookingID, String Status) {
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", CustomerID, CustomerIC, CustomerName, DOB, Gender, Email, Phone, Address, regDate, BookingID, Status);
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(CustomerID)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    
    public void updateAppointment(String AppointmentID, String record) {
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", AppointmentID, record);
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(AppointmentID)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    
    public void updateAppointmentForCustomer(String CustomerID, String record) {
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", CustomerID, record);
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(CustomerID)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    
    public void updateAppointmentStatus(String AppointmentID, String record) {
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", AppointmentID, record);
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(AppointmentID)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    public void updateProductQuantity(String ProductID, String record) {
        ArrayList<String> old_list = this.readAll();//exiting content
        ArrayList<String> new_list = new ArrayList();
        
        String newLine = String.join("|", ProductID, record);
        
        for (String oldLine : old_list) {//iterate the old content
            if (oldLine.startsWith(ProductID)) {
                new_list.add(newLine);
            } else {
                new_list.add(oldLine);
            }
        }
      
        if (new_list.size() > 0) {
            try(PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
                new_list.stream().forEach(line -> out.println(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //empty list
        }
    }
    
    public void Delete(){
        if(this.fileName.exists()) {
            this.fileName.delete();
            try {
                this.fileName.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void write(ArrayList<String> newRecord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
