/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Config.Global;
import static Classes.User.da;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author kianjun
 */
public class Account {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public Account(String Username) {
        this.username = Username;
    }
    
    public Account() {}
    
    public boolean forgetPassword(String username) {
        boolean success = false;
        da.setFileName("user.txt");
        ArrayList<String> data = da.readAll();
        for (String rec : data) {
            String[] split = rec.split("\\|");
            if (split[0].equals(username)) {
                //if the given username is matched in the system, assign the question, answer, and password to global
                Global.question = split[5];
                Global.answer = split[6];
                Global.password = split[3];
                success = true;
                break;
            }
        }
        return success;
    }
    
    public static boolean Login() {
        boolean success = false;
        da.setFileName("user.txt");
        ArrayList<String> data = da.readAll();
        for (String rec : data) {
            String[] split = rec.split("\\|");
            if (split[0].equals(User.username) && split[3].equals(User.password)) {
                Global.login_id = split[0];
                Global.name = split[1];
                Global.password = split[3];
                Global.role = split[4];
                Global.question = split[5];
                Global.answer = split[6];
                success = true;
                break;
            }
        }
        if (success) {
            int rand = new Random().nextInt();
            Global.user_login_id = Integer.toString(Math.abs(rand));
            da.setFileName("login_logs.txt");
            //RANDOMNUMBER|USERID|LOGINDT|LOGOUTDT
            String login_line = String.join("|", Global.user_login_id, Global.name, new Date().toString(), "Logout ERROR");
            da.write(login_line);
            da.setFileName("login_activities.txt");
            String login_line2 = String.join("|", Global.name, new Date().toString(), "Login");
            da.write(login_line2);
            return true;
        } else {
            return false;
        }
    }

    public static void logout(String num) {
        da.setFileName("login_logs.txt");
        ArrayList<String> data = da.readAll();
        for (String line : data) {
            if (line.startsWith(num)) {
                String[] split = line.split("\\|");
                da.update(num, Global.name, String.join("|", split[2], new Date().toString()));
                break;
            }
        }
        Global.question = null;
        da.setFileName("login_activities.txt");
        String login_line2 = String.join("|", Global.name, new Date().toString(), "Logout");
        da.write(login_line2);
    }
}
