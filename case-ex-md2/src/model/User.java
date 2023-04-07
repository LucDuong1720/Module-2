package model;

import java.util.Date;

public class User {
    private long id;
    private String nameAccount;
    private String password;
    private String nameUser;
    private String phone;
    private String address;
    private Date dateCreat;
    private Role role;

    public User(){}

    public User(long id, String nameAccount, String password, String nameUser, String phone, String address, Date dateCreat, Role role) {
        this.id = id;
        this.nameAccount = nameAccount;
        this.password = password;
        this.nameUser = nameUser;
        this.phone = phone;
        this.address = address;
        this.dateCreat = dateCreat;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(Date dateCreat) {
        this.dateCreat = dateCreat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameAccount='" + nameAccount + '\'' +
                ", password='" + password + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dateCreat=" + dateCreat +
                ", role=" + role +
                '}';
    }
}
