package model;

import java.util.Date;

public class Order {
    private long id;
    private String fullName;
    private String mobile;
    private String address;
    private double grandTotal;
    private Date creatAt;

    public Order() {}

    public Order(long id, String fullName, String mobile, String address, double grandTotal, Date creatAt) {
        this.id = id;
        this.fullName = fullName;
        this.mobile = mobile;
        this.address = address;
        this.grandTotal = grandTotal;
        this.creatAt = creatAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    @Override
    public String toString() {
        return "model.Order{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", grandTotal=" + grandTotal +
                ", creatAt=" + creatAt +
                '}';
    }
}
