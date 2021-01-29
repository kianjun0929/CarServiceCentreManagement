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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import oodjassignment.FrmUpdateCustomer;

/**
 *
 * @author kianjun
 */
public class Customer {
    DataAccess da = new DataAccess();
    protected String CustomerID;
    protected String CustomerIC;
    protected String CustomerName;
    protected String DOB;
    protected String Gender;
    protected String Email;
    protected String Phone;
    protected String Address;
    protected String regDate;
    protected String BookingID;
    protected String Status;
    
    public Customer() { 
        da.setFileName("Customer.txt");
    }
    
    public Customer(ArrayList CustomerDetails) {
        this.CustomerID = CustomerDetails.get(0).toString();
        this.CustomerIC = CustomerDetails.get(1).toString();
        this.CustomerName = CustomerDetails.get(2).toString();
        this.DOB = CustomerDetails.get(3).toString();
        this.Gender = CustomerDetails.get(4).toString();
        this.Email = CustomerDetails.get(5).toString();
        this.Phone = CustomerDetails.get(6).toString();
        this.Address = CustomerDetails.get(7).toString();
        this.regDate = CustomerDetails.get(8).toString();
        this.BookingID = CustomerDetails.get(9).toString();
        this.Status = CustomerDetails.get(10).toString();
        da.setFileName("Customer.txt");
    }
    
//    public Customer(String CustomerID, String CustomerIC, String CustomerName, String DOB, String Gender, String Email, String Phone, String Address, String regDate, String BookingID, String Status) {
//        this.CustomerID = CustomerID;
//        this.CustomerIC = CustomerIC;
//        this.CustomerName = CustomerName;
//        this.DOB = DOB;
//        this.Gender = Gender;
//        this.Email = Email;
//        this.Phone = Phone;
//        this.Address = Address;
//        this.regDate = regDate;
//        this.BookingID = BookingID;
//        this.Status = Status;
//        da.setFileName("Customer.txt");
//    }
    
    
    public String getCustomerID() { return CustomerID; }
    
    public void setCustomerID(String CustomerID) { this.CustomerID = CustomerID; }
    
    public String getCustomerIC() { return CustomerIC; }
    
    public void setCustomerIC(String CustomerIC) { this.CustomerIC = CustomerIC; }
    
    public String getCustomerName() { return CustomerName; }
    
    public void setCustomeName(String CustomerName) { this.CustomerName = CustomerName; }
    
    public String getDOB() { return DOB; }    
    
    public void setDOB(String DOB) { this.DOB = DOB; }

    public String getGender() { return Gender; }
    
    public void setGender(String Gender) { this.Gender = Gender; }
    
    public String getEmail() { return Email; }
    
    public void setEmail(String Email) { this.Email = Email; }
    
    public String getPhone() { return Phone; }
    
    public void setPhone(String Phone) { this.Phone = Phone; }
    
    public String getAddress() { return Address; }
    
    public void setAddress(String Address) { this.Address = Address; }
    
    public String getRegDate() { return regDate; }
    
    public void setRegDate(String regDate) { this.regDate = regDate; }
    
    public String getBookingID() { return BookingID; }
    
    public void setBookingID(String BookingID) { this.BookingID = BookingID; }
    
    public String getStatus() { return Status; }
    
    public void setStatus(String Status) { this.Status = Status; }
    
    public void add() {
//        da.setFileName("Customer.txt");
        String line = String.join("|", getCustomerID(), getCustomerIC(), getCustomerName(), getDOB(), getGender(), getEmail(), getPhone(), getAddress(), getRegDate(), getBookingID(), getStatus());
        da.write(line);
    }
    
    public void View() throws ParseException {
        FrmUpdateCustomer frmUpdateCustomer = new FrmUpdateCustomer();
        frmUpdateCustomer.txtCustomerID.setText(CustomerID);
        frmUpdateCustomer.txtCustomerIC.setText(CustomerIC);
        frmUpdateCustomer.txtCustomerName.setText(CustomerName);
        frmUpdateCustomer.txtEmail.setText(Email);
        frmUpdateCustomer.txtPhone.setText(Phone);
        frmUpdateCustomer.txtRegistrationDate.setText(regDate);
        frmUpdateCustomer.txtStatus.setText(Status);
        frmUpdateCustomer.txtBookingNo.setText(BookingID);
        
        if(Status.equals("ACTIVE")){
            frmUpdateCustomer.btnActivate.setEnabled(false);
        } else {
            frmUpdateCustomer.btnDeactivate.setEnabled(true);
        }
        
        if(Gender.equals("MALE")) {
            frmUpdateCustomer.rbtnMale.setSelected(true);
        } else {
            frmUpdateCustomer.rbtnFemale.setSelected(true);
        }
        
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(DOB);  
        LocalDate localDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Calendar cal = Calendar.getInstance();
        cal.set(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
        frmUpdateCustomer.txtDOB.setDate(cal);

        frmUpdateCustomer.txtAddress.setText(Address);
        
        frmUpdateCustomer.setVisible(true);
    }
    
    public void Update() {
//        da.setFileName("Customer.txt");
        da.updateCustomer(getCustomerID(), getCustomerIC(), getCustomerName(), getDOB(), getGender(), getEmail(), getPhone(), getAddress(), getRegDate(), getBookingID(), getStatus());
    }
    
    public void UpdateAppointment(String CustomerName, String BookingID) {
//        da.setFileName("Customer.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[2].equals(CustomerName)){
                CustomerID = split[0];
                break;
            }
        }
        
        for(String rec: data) {
            if (rec.startsWith(CustomerID)) {
                String[] split = rec.split("\\|");
                String Line = String.join("|", split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], BookingID, split[10]);
                da.updateAppointmentForCustomer(CustomerID, Line);
                break;
            }
        }
        
        for (String line : data) {
            
        }
    }
    
    public void RemoveAppointment(String CustomerName) {
//        da.setFileName("Customer.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[2].equals(CustomerName)){
                CustomerID = split[0];
                break;
            }
        }
        
        for(String rec: data) {
            if (rec.startsWith(CustomerID)) {
                String[] split = rec.split("\\|");
                String Line = String.join("|", split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], "N/A", split[10]);
                da.updateAppointmentForCustomer(CustomerID, Line);
                break;
            }
        }
        
        for (String line : data) {
            
        }
    }
    
    public DefaultComboBoxModel getCustomerNameforComboBox()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try
        {
//            da.setFileName("Customer.txt");
            ArrayList<String> data = da.readAll();
            for(String rec: data) {
                String[] split = rec.split("\\|");
                if(split[10].equals("ACTIVE") & split[9].equals("N/A")){
                    model.addElement(split[2]);
                }
            }
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Can't load data from database");
        }
        return model;
      }
    
    public void ClearCustomerDatabase() {
//        da.setFileName("Customer.txt");
        da.Delete();
    }
}
