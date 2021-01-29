/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Config.Global;
import DataAccess.DataAccess;
import Technician.FrmUpdateProduct;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author kianjun
 */
public class Product {
    DataAccess da = new DataAccess();
    protected String ProductID;
    protected String CategoryName;
    protected String ProductName;
    protected String ProductDescription;
    protected String regDate;
    protected String Price;
    protected String Quantity;
    protected String Status;
    
    public Product() {
        da.setFileName("Product.txt");
    }
    
//    public Product(String ProductID, String CategoryName, String ProductName, String ProductDescription, String regDate, String Price, String Quantity, String Status) {
//        this.ProductID = ProductID;
//        this.CategoryName = CategoryName;
//        this.ProductName = ProductName;
//        this.ProductDescription = ProductDescription;
//        this.regDate = regDate;
//        this.Price = Price;
//        this.Quantity = Quantity;
//        this.Status = Status;
//        da.setFileName("Product.txt");
//    }
    
    public Product(ArrayList ProductDetails) {
        this.ProductID = ProductDetails.get(0).toString();
        this.CategoryName = ProductDetails.get(1).toString();
        this.ProductName = ProductDetails.get(2).toString();
        this.ProductDescription = ProductDetails.get(3).toString();
        this.regDate = ProductDetails.get(4).toString();
        this.Price = ProductDetails.get(5).toString();
        this.Quantity = ProductDetails.get(6).toString();
        this.Status = ProductDetails.get(7).toString();
        da.setFileName("Product.txt");
    }
    
    public String getProductID() { return ProductID; }
    
    public void setProductID(String ProductID) { this.ProductID = ProductID; }
    
    public String getCategoryName() { return CategoryName; }
    
    public void setCategoryName(String CategoryName) { this.CategoryName = CategoryName; }
    
    public String getProductName() { return ProductName; }
    
    public void setProductName(String ProductName) { this.ProductName = ProductName; }
    
    public String getProductDescription() { return ProductDescription; }
    
    public void setProductDescription(String ProductDescription) { this.ProductDescription = ProductDescription; }
    
    public String getPrice() { return Price; }
    
    public void setPrice(String Price) { this.Price = Price; }
    
    public String getQuantity() { return Quantity; }
    
    public void setQuantity(String Quantity) { this.Quantity = Quantity; }
    
    public String getStatus() { return Status; }
    
    public void setStatus(String Status) { this.Status = Status; }
    
    public String getRegDate() {
        return regDate;
    }
    
    public void Add() {
        String line = String.join("|", getProductID(), getCategoryName(), getProductName(), getProductDescription(), getRegDate(), getPrice(), getQuantity(), getStatus());
        da.write(line);
        da.setFileName("Product_activities.txt");
        line = String.join("|", Global.name, getProductName(), "Added");
        da.write(line);
    }
    
    public void View() {
        FrmUpdateProduct frmUpdateProduct = new FrmUpdateProduct();
        frmUpdateProduct.txtProductID.setText(ProductID);
        frmUpdateProduct.txtProductName.setText(ProductName);
        frmUpdateProduct.txtProductDescription.setText(ProductDescription);
        frmUpdateProduct.txtPrice.setText(Price);
        frmUpdateProduct.txtQuantity.setText(Quantity);
        frmUpdateProduct.txtDateAdded.setText(regDate);
        if(Status.equals("ACTIVE")) {
            frmUpdateProduct.btnActivate.setEnabled(false);
        } else {
            frmUpdateProduct.btnDeactivate.setEnabled(false);
        }
        frmUpdateProduct.setVisible(true);
    }
    
    public void Update(){
        da.updateProduct(getProductID(), getCategoryName(), getProductName(), getProductDescription(), getRegDate(), getPrice(), getQuantity(), getStatus());
        da.setFileName("Product_activities.txt");
        String line = String.join("|", Global.name, getProductName(), "Updated");
        da.write(line);
    }
    
    public void UpdateProductQuantity(String ProductName, String Quantity) {
//        da.setFileName("Product.txt");
        ArrayList<String> data = da.readAll();
        for(String rec: data) {
            String[] split = rec.split("\\|");
            if(split[2].equals(ProductName)){
                ProductID = split[0];
                break;
            }
        }
        
        for(String rec: data) {
            if (rec.startsWith(ProductID)) {
                String[] split = rec.split("\\|");
                int quantity = Integer.parseInt(Quantity);
                int quantity1 = Integer.parseInt(split[6]);
                int remains = quantity1 - quantity;
                String record = Integer.toString(remains);
                String Line = String.join("|", split[1], split[2], split[3], split[4], split[5], record, split[7]);
                da.updateProductQuantity(ProductID, Line);
                break;
            }
        }
        
        for (String line : data) {
            
        }
    }
    
    public DefaultComboBoxModel getProductNameforComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
//            da.setFileName("Product.txt");
            ArrayList<String> data = da.readAll();
            for (String rec : data) {
                String[] split = rec.split("\\|");
                if (split[7].equals("ACTIVE")) {
                    model.addElement(split[2]);
                }
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public void ClearProductDatabase() {
//        da.setFileName("Product.txt");
        da.Delete();
        da.setFileName("Product_activities.txt");
        da.Delete();
    }
}
