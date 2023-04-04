package model;

public class OrderItem {
    private long id;
    private double price;
    private int quantity;
    private long orderId;
    private String productName;
    private double total;
    private double grandTotal;

    public OrderItem() {}

    public OrderItem(long id, double price, int quantity, long orderId, String productName, double total, double grandTotal) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", total=" + total +
                ", grandTotal=" + grandTotal +
                '}';
    }
}
