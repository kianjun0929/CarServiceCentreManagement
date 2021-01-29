/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataAccess.DataAccess;
import Interface.Operable;
import java.util.ArrayList;

/**
 *
 * @author kianjun
 */
public class Admin extends User implements Operable {
    
    public Admin(ArrayList AdminDetails) {
        super(AdminDetails);
    }

    public Admin() {}
    
    @Override
    public String getRole() {
        return ROLE.ADMIN.toString();
    }
    
    
    

    @Override
    public ArrayList<String> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void ClearUserDatabase(String username) {
        ArrayList<String> data = da.readAll();
        ArrayList<String> newRecord = new ArrayList<>();
        for(String rec: data) {
            if(rec.startsWith(username)) {
                newRecord.add(rec);
            }
        }
        da.Delete();
        String line = null;
        for(String rec: newRecord) {
            String[] split = rec.split("\\|");
            line = String.join("|", split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7]);
            
        }
        da.write(line);
    }
}
