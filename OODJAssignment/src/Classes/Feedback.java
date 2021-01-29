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
public class Feedback {
    DataAccess da = new DataAccess();
    protected String FeedbackID;
    protected String AppointmentID;
    protected String CategoryName;
    protected String FeedbackDescription;
    protected String Rating;
    protected String Improvement;
    protected String DateAdded;
    protected String CustomerName;
    protected String TechnicianName;
    
//    public Feedback(String FeedbackID, String AppointmentID, String CategoryName, String FeedbackDescription, String Rating, String Improvement, String DateAdded, String CustomerName, String TechnicianName) {
//        this.FeedbackID = FeedbackID;
//        this.CategoryName = CategoryName;
//        this.AppointmentID = AppointmentID;
//        this.FeedbackDescription = FeedbackDescription;
//        this.Rating = Rating;
//        this.Improvement = Improvement;
//        this.DateAdded = DateAdded;
//        this.CustomerName = CustomerName;
//        this.TechnicianName = TechnicianName;
//        da.setFileName("Feedback.txt");
//    }
    
    public Feedback(ArrayList FeedbackDetails) {
        this.FeedbackID = FeedbackDetails.get(0).toString();
        this.CategoryName = FeedbackDetails.get(2).toString();
        this.AppointmentID = FeedbackDetails.get(1).toString();
        this.FeedbackDescription = FeedbackDetails.get(3).toString();
        this.Rating = FeedbackDetails.get(4).toString();
        this.Improvement = FeedbackDetails.get(5).toString();
        this.DateAdded = FeedbackDetails.get(6).toString();
        this.CustomerName = FeedbackDetails.get(7).toString();
        this.TechnicianName = FeedbackDetails.get(8).toString();
        da.setFileName("Feedback.txt");
    }
    
    
    public Feedback() {
        da.setFileName("Feedback.txt");
    }
    
    public String getFeedbackID() { return FeedbackID; }
    
    public void setFeedbackID(String FeedbackID) { this.FeedbackID = FeedbackID; }
    
    public String getBookingID() { return AppointmentID; }
    
    public void setBookingID(String AppointmentID) { this.AppointmentID = AppointmentID; }
    
    public String getFeedbackDescription() { return FeedbackDescription; }
    
    public void setFeedbackDescription(String FeedbackDescription) { this.FeedbackDescription = FeedbackDescription; }
    
    public String getRating() { return Rating; }
    
    public void setRating(String Rating) { this.Rating = Rating; }
    
    public String getImprovement() { return Improvement; }
    
    public void setImprovement(String Improvement) { this.Improvement = Improvement; }
    
    public String getDateAdded() { return DateAdded; }
    
    public void setDateAdded(String DateAdded) { this.DateAdded = DateAdded; }
    
    public String getCustomerName() { return CustomerName; }
    
    public void setCustomerName(String CustomerName) { this.CustomerName = CustomerName; }
    
    public String getTechnicianName() { return TechnicianName; }
    
    public void setTechnicianName(String TechnicianName) { this.TechnicianName = TechnicianName; }

    public String getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(String AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    
    
    public void Add() {
        String line = String.join("|", getFeedbackID(), getAppointmentID(), getCategoryName(), getFeedbackDescription(), getRating(), getImprovement(), getDateAdded(), getCustomerName(), getTechnicianName());
        da.write(line);
    }
    
    public void ClearFeedbackDatabase() {
//        da.setFileName("Feedback.txt");
        da.Delete();
    }
}
