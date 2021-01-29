/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Config.Global;
import DataAccess.DataAccess;
import Technician.FrmUpdateAppointment;
import Technician.FrmUpdateCategory;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author kianjun
 */
public class Category {
    private String CategoryID;
    private String CategoryName;
    private String CategoryDescription;
    private String CategoryAddedDate;
    private String Price;
    private String Status;
    DataAccess da = new DataAccess();

    public DataAccess getDa() {
        return da;
    }

    public void setDa(DataAccess da) {
        this.da = da;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getCategoryAddedDate() {
        return CategoryAddedDate;
    }

    public void setCategoryAddedDate(String CategoryAddedDate) {
        this.CategoryAddedDate = CategoryAddedDate;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
    
   
    public Category(String data)
    {
        String[] dataArray = data.split("|");
        this.CategoryID = dataArray[0];
        this.CategoryName = dataArray[1];
        this.CategoryDescription = dataArray[2];
        this.CategoryAddedDate = dataArray[3];
        this.Status = dataArray[4];
    }
    
    public void setCategoryID(String CategoryID)
    {
        this.CategoryID = CategoryID;
    }
    public String getCategoryID()
    {
        return CategoryID;
    }
    
    public void setCategoryDescription(String CategoryDescription) {
        this.CategoryDescription = CategoryDescription;
    }
    
    public String getCategoryDescription() {
        return CategoryDescription;
    }
    
    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    
    public void setStatus(String status)
    {
        this.Status = status;
    }
    public String getStatus()
    {
        return Status;
    }
    
    public Category(ArrayList CategoryDetails) {
        this.CategoryID = CategoryDetails.get(0).toString();
        this.CategoryName = CategoryDetails.get(1).toString();
        this.CategoryDescription = CategoryDetails.get(2).toString();
        this.CategoryAddedDate = CategoryDetails.get(3).toString();
        this.Price = CategoryDetails.get(4).toString();
        this.Status = CategoryDetails.get(5).toString();
        da.setFileName("Category.txt");
    }
    
//    public Category(String CategoryID, String CategoryName, String CategoryDescription, String regDate, String Price, String Status) {
//        this.CategoryID = CategoryID;
//        this.CategoryName = CategoryName;
//        this.CategoryDescription = CategoryDescription;
//        this.CategoryAddedDate = regDate;
//        this.Price = Price;
//        this.Status = Status;
//    }
    
    public Category() { da.setFileName("Category.txt");}
    
    public void Add() {
        String line = String.join("|", getCategoryID(), getCategoryName(), getCategoryDescription(), getCategoryAddedDate(), getPrice(), getStatus());
        da.write(line);
        da.setFileName("Category_activities.txt");
        line = String.join("|", Global.name, getCategoryName(), "Added");
        da.write(line);
    }
    
    public void Update() {
        da.updateCategory(getCategoryID(), getCategoryName(), getCategoryDescription(), getCategoryAddedDate(), getPrice(), getStatus());
        da.setFileName("Category_activities.txt");
        String line = String.join("|", Global.name, getCategoryName(), "Updated");
        da.write(line);
    }
    
    public DefaultComboBoxModel getCategoryNameforComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[5].equals("ACTIVE")) {
                model.addElement(split[1]);
            }
        }
        return model;
    }
    
    public void ClearCategoryDatabase() {
        da.Delete();
        da.setFileName("Category_activities.txt");
        da.Delete();
    }
}
