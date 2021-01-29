/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interface.Operable;
import java.util.ArrayList;

/**
 *
 * @author kianjun
 */
public class Manager extends User implements Operable {

    public Manager(ArrayList ManagerDetails) {
        super(ManagerDetails);
    }
    
    public Manager() { da.setFileName("user.txt"); }
    
    @Override
    public String getRole() {
        return ROLE.MANAGER.toString();
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

    @Override
    public ArrayList<String> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}