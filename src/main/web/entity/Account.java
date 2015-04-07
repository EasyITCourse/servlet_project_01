package entity;

import java.util.List;

public class Account extends AbstractModelBean {
    private int id;
    private String username;
    private String password;
    private List<Role> roles;

    public Account() {
        super();
    }



    public Account(String username, String password, List<Role> roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = roles;


    }

    public Account(int id, String username, String password, List<Role> roles) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}
