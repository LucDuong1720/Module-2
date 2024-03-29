package model;
import service.IModel;
import utils.DateUtils;

import java.util.Date;

public class Product implements IModel<Product> {
    private long id;
    private String name;
    private String brand;
    private String origin;
    private String capacity;
    private int quantity;
    private double price;
    private Date creatAt;
    private Date updateAt;

    public Product() {}

    public Product(long id, String name, String brand, String origin, String capacity, int quantity, double price, Date creatAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.origin = origin;
        this.capacity = capacity;
        this.quantity = quantity;
        this.price = price;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getId(), this.getName(), this.getBrand(), this.getOrigin(),this.getCapacity(),
                this.getQuantity(), this.getPrice(), this.getCreatAt(), this.getUpdateAt());
    }
    @Override
    public Product parseData(String line) {
        String[] items = line.split(",");
        Product product = new Product();
        product.setId(Long.parseLong(items[0]));
        product.setName(items[1]);
        product.setBrand(items[2]);
        product.setOrigin(items[3]);
        product.setCapacity(items[4]);
        product.setQuantity(Integer.parseInt(items[5]));
        product.setPrice(Double.parseDouble(items[6]));
        product.setCreatAt(DateUtils.parseDate(items[7]));
        String temp = items[8];
        product.setUpdateAt(DateUtils.parseDate(null));
        if (temp != null && !temp.equals("null"))
            product.setUpdateAt(DateUtils.parseDate(temp));

        return product;
    }
}
