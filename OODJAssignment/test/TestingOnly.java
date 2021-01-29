/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kianjun
 */
public abstract class TestingOnly {

    protected static String Username, Password, Role, Status;

    public static String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public static String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public static String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public TestingOnly(String Username, String Password, String Role, String Status) {
        this.Username = Username;
        this.Password = Password;
        this.Role = Role;
        this.Status = Status;
    }

    public static String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public TestingOnly() { }
}

class TestingOnly1 extends TestingOnly {

    protected String Testing1, Testing2, Testing3, Testing4, Testing5;

    public TestingOnly1(String Testing1, String Testing2, String Testing3, String Testing4, String Testing5, String Username, String Password, String Role, String Status) {
        super(Username, Password, Role, Status);
        this.i = TestingOnly.getStatus();
        this.Testing1 = Testing1;
        this.Testing2 = Testing2;
        this.Testing3 = Testing3;
        this.Testing4 = Testing4;
        this.Testing5 = Testing5;
        
    }
    
    protected String i;

    public String getTesting1() {
        return Testing1;
    }

    public void setTesting1(String Testing1) {
        this.Testing1 = Testing1;
    }

    public String getTesting2() {
        return Testing2;
    }

    public void setTesting2(String Testing2) {
        this.Testing2 = Testing2;
    }

    public String getTesting3() {
        return Testing3;
    }

    public void setTesting3(String Testing3) {
        this.Testing3 = Testing3;
    }

    public String getTesting4() {
        return Testing4;
    }

    public void setTesting4(String Testing4) {
        this.Testing4 = Testing4;
    }

    public String getTesting5() {
        return Testing5;
    }

    public void setTesting5(String Testing5) {
        this.Testing5 = Testing5;
    }
    
    
}

class TestingOnly2 extends TestingOnly1 {
    private String Only1, Only2;

    public TestingOnly2(String Only1, String Only2, String Testing1, String Testing2, String Testing3, String Testing4, String Testing5, String Username, String Password, String Role, String Status) {
        super(Testing1, Testing2, Testing3, Testing4, Testing5, Username, Password, Role, Status);
        this.Only1 = Only1;
        this.Only2 = Only2;
    }

    public String getOnly1() {
        return Only1;
    }

    public void setOnly1(String Only1) {
        this.Only1 = Only1;
    }

    public String getOnly2() {
        return Only2;
    }

    public void setOnly2(String Only2) {
        this.Only2 = Only2;
    }
    
}