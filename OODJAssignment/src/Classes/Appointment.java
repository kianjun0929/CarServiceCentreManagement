/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataAccess.DataAccess;
import Technician.FrmUpdateAppointment;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author kianjun
 */
public class Appointment {
    DataAccess da = new DataAccess();
    private String AppointmentID;
    private String CustomerName;
    private String CategoryName;
    private String TechnicianName;
    private String CarPlateNo;
    private String AppointmentDetails;
    private String AppointmentDate;
    private String StartTime;
    private String EndTime;
    private String Status;
    
    public Appointment() { 
        da.setFileName("Appointment.txt"); 
    }
    
    public Appointment(ArrayList ApppointmentDetails) {
        this.AppointmentID = ApppointmentDetails.get(0).toString();
        this.CustomerName = ApppointmentDetails.get(1).toString();
        this.CategoryName = ApppointmentDetails.get(2).toString();
        this.TechnicianName = ApppointmentDetails.get(3).toString();
        this.CarPlateNo = ApppointmentDetails.get(4).toString();
        this.AppointmentDetails = ApppointmentDetails.get(5).toString();
        this.AppointmentDate = ApppointmentDetails.get(6).toString();
        this.StartTime = ApppointmentDetails.get(7).toString();
        this.EndTime = ApppointmentDetails.get(8).toString();
        this.Status = ApppointmentDetails.get(9).toString();
        da.setFileName("Appointment.txt");
    }
    
    public String getAppointmentID() { return AppointmentID; }
    public void setAppointmentID(String AppointmentID) { this.AppointmentID = AppointmentID; }
    public String getCustomerName() { return CustomerName; }
    public String getCategoryName() { return CategoryName; }
    public String getTechnicianName() { return TechnicianName; }
    public String getAppointmentDetails() { return AppointmentDetails; }
    public String getAppointmentDate() { return AppointmentDate; }
    public String getStartTime() { return StartTime; }
    public String getEndTime() { return EndTime; }
    public String getStatus() { return Status; }
    public String getCarPlateNo() { return CarPlateNo; }
    public void setCarPlateNo(String CarPlateNo) { this.CarPlateNo = CarPlateNo; }
    public void setDa(DataAccess da) { this.da = da; }
    public void setCustomerName(String CustomerName) { this.CustomerName = CustomerName; }
    public void setCategoryName(String CategoryName) { this.CategoryName = CategoryName; }
    public void setTechnicianName(String TechnicianName) { this.TechnicianName = TechnicianName; }
    public void setAppointmentDetails(String AppointmentDetails) { this.AppointmentDetails = AppointmentDetails; }
    public void setAppointmentDate(String AppointmentDate) { this.AppointmentDate = AppointmentDate; }
    public void setStartTime(String StartTime) { this.StartTime = StartTime; }
    public void setEndTime(String EndTime) { this.EndTime = EndTime; }
    public void setStatus(String Status) { this.Status = Status; }
    
    
    
    public void Add() {
//        da.setFileName("Appointment.txt");
        String line = String.join("|", getAppointmentID(), getCustomerName(), getCategoryName(), getTechnicianName(), getCarPlateNo(), getAppointmentDetails(), getAppointmentDate(), getStartTime(), getEndTime(), getStatus());
        da.write(line);
    }
    
    public void Update() {
        String line = String.join("|", getCustomerName(), getCategoryName(), getTechnicianName(), getCarPlateNo(), getAppointmentDetails(), getAppointmentDate(), getStartTime(), getEndTime(), getStatus());
        da.updateAppointment(getAppointmentID(), line);
    }
    
    public void RemoveAppointment(String AppointmentID) {
//        da.setFileName("Appointment.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[0].equals(AppointmentID)){
                AppointmentID = split[0];
                break;
            }
        }
        
        for(String rec: data) {
            if (rec.startsWith(AppointmentID)) {
                String[] split = rec.split("\\|");
                String Line = String.join("|", split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], "COMPLETED");
                da.updateAppointmentStatus(AppointmentID, Line);
                break;
            }
        }
        
    }
    
        
    public void getAppointmentID(String AppointmentID) {
        
//        da.setFileName("Appointment.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[0].equals(AppointmentID)) {
                FrmUpdateAppointment UpdateAppointment = new FrmUpdateAppointment(split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], split[9]);
                UpdateAppointment.setVisible(true);
            }
        }
    }
    
    public DefaultComboBoxModel getAppointmentIDforComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
//            da.setFileName("Appointment.txt");
            ArrayList<String> data = da.readAll();
            for (String rec : data) {
                String[] split = rec.split("\\|");
                if (split[9].equals("PENDING")) {
                    model.addElement(split[0]);
                }
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public void ClearAppointmentDatabase() {
//        da.setFileName("Appointment.txt");
        da.Delete();
    }
}
