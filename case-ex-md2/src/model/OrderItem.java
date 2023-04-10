package model;

import service.IModel;

public class OrderItem implements IModel<OrderItem> {
    private long id;
    private double price;
    private int quantity;
    private long orderId;
    private long productId;
    private String productName;
    private double total;
    private double grandTotal;

    public OrderItem() {}

    public OrderItem(long id, double price, int quantity, long orderId, long productId, String productName, double total, double grandTotal) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.total = total;
        this.grandTotal = grandTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", total=" + total +
                ", grandTotal=" + grandTotal +
                '}';
    }

    @Override
    public OrderItem parseData(String line) {
        String[] items = line.split(",");
        OrderItem orderItem = new OrderItem();
        orderItem.setId(Long.parseLong(items[0]));
        orderItem.setPrice(Double.parseDouble(items[1]));
        orderItem.setQuantity(Integer.parseInt(items[2]));
        orderItem.setOrderId(Long.parseLong(items[3]));
        orderItem.setProductId(Long.parseLong(items[4]));
        orderItem.setProductName(items[5]);
        orderItem.setTotal(Double.parseDouble(items[6]));
        orderItem.setGrandTotal(Double.parseDouble(items[7]));

        return orderItem;
    }
}
