/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interface.Operable;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author kianjun
 */
public class Technician extends User implements Operable {
    
    public Technician(ArrayList TechnicianDetails) {
        super(TechnicianDetails);
    }
    
    public Technician() { da.setFileName("user.txt"); }
    
    @Override
    public String getRole() {
        return ROLE.TECHNICIAN.toString();
    }
    
//    @Override
//    public void Add() {
//        String line = String.join("|", getUserID(), getUsername(), getDOB(), getPassword(), getRole(), getQuestion(), getAnswer(), getStatus());
//        da.write(line);
//    }
//    
//    @Override
//    public void Update() {
//        da.updateUser(getUserID(), getUsername(), getDOB(), getPassword(), getRole(), getQuestion(), getAnswer(), getStatus());
//    }
//
    @Override
    public ArrayList<String> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DefaultComboBoxModel getTechnicianNameforComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            ArrayList<String> data = da.readAll();
            for (String rec : data) {
                String[] split = rec.split("\\|");
                if (split[4].equals("TECHNICIAN") && split[7].equals("ACTIVE")) {
                    model.addElement(split[1]);
                }
            }

        } catch (Exception e) {
        }
        return model;
    }
}

