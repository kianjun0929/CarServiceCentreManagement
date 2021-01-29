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
public class Payment {
    DataAccess da = new DataAccess();
    
    protected String PaymentID;
    protected String AppointmentID;
    protected String CustomerName;
    protected String CategoryName;
    protected String CategoryPrice;
    protected String AppointmentDate;
    protected String AppointmentTime;
    protected String ProductName;
    protected String ProductPrice;
    protected String ProductQuantity;
    protected String DateAdded;
    protected String Total;
    protected String Status;
    
    public Payment() { 
        da.setFileName("Payment.txt");
    }
    
    public Payment(ArrayList PaymentDetails) {
        this.PaymentID = PaymentDetails.get(0).toString();
        this.AppointmentID = PaymentDetails.get(1).toString();
        this.CustomerName = PaymentDetails.get(2).toString();
        this.CategoryName = PaymentDetails.get(3).toString();
        this.CategoryPrice = PaymentDetails.get(4).toString();
        this.AppointmentDate = PaymentDetails.get(5).toString();
        this.AppointmentTime = PaymentDetails.get(6).toString();
        this.ProductName = PaymentDetails.get(7).toString();
        this.ProductPrice = PaymentDetails.get(8).toString();
        this.ProductQuantity = PaymentDetails.get(9).toString();
        this.DateAdded = PaymentDetails.get(10).toString();
        this.Total = PaymentDetails.get(11).toString();
        this.Status = PaymentDetails.get(12).toString();
        da.setFileName("Payment.txt");
    }
    
//    public Payment(String PaymentID, String AppointmentID, String CustomerName, String CategoryName, String CategoryPrice, String AppointmentDate, String AppointmentTime, String ProductName, String ProductPrice, String ProductQuantity, String DateAdded, String Total, String Status) {
//        this.PaymentID = PaymentID;
//        this.AppointmentID = AppointmentID;
//        this.CustomerName = CustomerName;
//        this.CategoryName = CategoryName;
//        this.CategoryPrice = CategoryPrice;
//        this.AppointmentDate = AppointmentDate;
//        this.AppointmentTime = AppointmentTime;
//        this.ProductName = ProductName;
//        this.ProductPrice = ProductPrice;
//        this.ProductQuantity = ProductQuantity;
//        this.DateAdded = DateAdded;
//        this.Total = Total;
//        this.Status = Status;
//        da.setFileName("Payment.txt");
//    }
    
    public String getPaymentID() { return PaymentID; }
    
    public void setPaymentID(String PaymentID) { this.PaymentID = PaymentID; }
    
    public String getAppointmentID() { return AppointmentID; }
    
    public void setAppointmentID(String AppointmentID) { this.AppointmentID = AppointmentID; }
    
    public String getCustomerName() { return CustomerName; }
    
    public void setCustomerName(String CustomerName) { this.CustomerName = CustomerName; }
    
    public String getCategoryName() { return CategoryName; }
    
    public void setCategoryName(String CategoryName) { this.CategoryName = CategoryName; }
    
    public String getCategoryPrice() { return CategoryPrice; }
    
    public void setCategoryPrice(String CategoryPrice) { this.CategoryPrice = CategoryPrice; }
    
    public String getAppointmentDate() { return AppointmentDate; }
    
    public void setAppointmentDate(String AppointmentDate) { this.AppointmentDate = AppointmentDate; }
    
    public String getAppointmentTime() { return AppointmentTime; }
    
    public void setAppointmentTime(String AppointmentTime) { this. AppointmentTime = AppointmentTime; }
    
    public String getProductName() { return ProductName; }
    
    public void setProductName(String ProductName) { this.ProductName = ProductName; }
    
    public String getProductPrice() { return ProductPrice; }
    
    public void setProductPrice(String ProductPrice) { this.ProductPrice = ProductPrice; }
    
    public String getProductQuantity() { return ProductQuantity; }
    
    public void setProductQuantity(String ProductQuantity) { this.ProductQuantity = ProductQuantity; }
    
    public String getDateAdded() { return DateAdded; }
    
    public void setDateAdded(String DateAdded) { this.DateAdded = DateAdded; }
    
    public String getTotal() { return Total; }
    
    public void setTotal(String Total) { this.Total = Total; }
    
    public String getStatus() { return Status; }
    
    public void setStatus(String Status) { this.Status = Status; }
    
    public void Add() {
        String line = String.join("|", getPaymentID(), getAppointmentID(), getCustomerName(), getCategoryName(), getCategoryPrice(), getAppointmentDate(), getAppointmentTime(), getProductName(), getProductPrice(), getProductQuantity(), getDateAdded(), getTotal(), getStatus());
        da.write(line);
    }

    public void ClearPaymentDatabase() {
//        da.setFileName("Payment.txt");
        da.Delete();
    }
}
