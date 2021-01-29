/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Config.Global;
import DataAccess.DataAccess;
import Manager.FrmUpdateTechnician;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import Interface.Operable;

/**
 *
 * @author kianjun
 */
public abstract class User implements Operable {
    public static String name;
    public static String username;
    public static String password;
    public static String role;
    public static String memberid;
    public static String uid;
    static DataAccess da = new DataAccess();

    protected String UserID;
    protected String Username;
    protected String DOB;
    protected String Password;
    protected String Role;
    protected String Question;
    protected String Answer;
    protected String Status;
    private Account acc;
    enum ROLE {
        ADMIN {
            @Override
            public String toString() {
                return "ADMIN";
            }
        },
        MANAGER {
            @Override
            public String toString() {
                return "MANAGER";
            }
        },
        TECHNICIAN {
            @Override
            public String toString() {
                return "TECHNICIAN";
            }
        }
    }
    protected ROLE Roles;

    public User(ArrayList UserDetails) {
        this.UserID = UserDetails.get(0).toString();
        this.Username = UserDetails.get(1).toString();
        this.DOB = UserDetails.get(2).toString();
        this.Password = UserDetails.get(3).toString();
        this.Role = UserDetails.get(4).toString();
        this.Question = UserDetails.get(5).toString();
        this.Answer = UserDetails.get(6).toString();
        this.Status = UserDetails.get(7).toString();
        da.setFileName("user.txt");
    }
    
    //Overloading
    public User() { da.setFileName("user.txt"); }

    public ROLE getRoles() {
        return Roles;
    }

    public void setRoles(ROLE Roles) {
        this.Roles = Roles;
    }
    
    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public String getUsername() {
        return Username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public String getRole() {
        return role;
    }

    public static void setRole(String role) {
        User.role = role;
    }

    public static String getMemberid() {
        return memberid;
    }

    public static void setMemberid(String memberid) {
        User.memberid = memberid;
    }

    public static String getUid() {
        return uid;
    }

    public static void setUid(String uid) {
        User.uid = uid;
    }

    public static DataAccess getDa() {
        return da;
    }

    public static void setDa(DataAccess da) {
        User.da = da;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    
    @Override
    public void Add() {
//        da.setFileName("user.txt");
        String line = String.join("|", getUserID(), getUsername(), getDOB(), getPassword(), getRole(), getQuestion(), getAnswer(), getStatus());
        da.write(line);
    }

    @Override
    public void Update() {
//        da.setFileName("user.txt");
        da.updateUser(getUserID(), getUsername(), getDOB(), getPassword(), getRole(), getQuestion(), getAnswer(), getStatus());
    }

    public void View() throws ParseException {
        FrmUpdateTechnician frmUpdateTechnician = new FrmUpdateTechnician();
        frmUpdateTechnician.txtUserID.setText(UserID);
        frmUpdateTechnician.txtUsername.setText(Username);
        frmUpdateTechnician.jLabel5.setText(Status);
        frmUpdateTechnician.txtPassword.setText(Password);
        frmUpdateTechnician.txtAnswer.setText(Answer);
        frmUpdateTechnician.txtQuestion.setText(Question);
        if (Status.equals("ACTIVE")) {
            frmUpdateTechnician.btnActivate.setEnabled(false);
        } else {
            frmUpdateTechnician.btnDeactivate.setEnabled(false);
        }

        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(DOB);
        LocalDate localDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Calendar cal = Calendar.getInstance();
        cal.set(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
        frmUpdateTechnician.txtDOB.setDate(cal);

        frmUpdateTechnician.setVisible(true);
    }


    
    
}
