public class Product {
    private long id;
    private String name;
    private double price;
    private double quantity;
    private String describe;

    public Product() {

    }

    public Product(long id, String name, double price, double quantity, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "- Lựa chọn thêm mới" +
                "- Mã sản phẩm: " + id +
                "- Tên: " + name + '\'' +
                "- Giá: " + price +
                "- Số lượng: " + quantity +
                "- Mô tả: " + describe + '\'' +
                '}';
    }
}
