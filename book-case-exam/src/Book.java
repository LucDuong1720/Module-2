import java.util.Date;

public class Book {
    //biến toàn cục - biến instance - biến của đối tượng
    // các biến này có đặc điểm gì
    // Có giá trị mặc định phụ thuộc vào kiểu dữ liệu
    private long id;
    private String name;
    private String description;
    private Date entryDate;
    private double price;
    // overloading: cho phép một lớp có thể có nhiều phương thức cùng tên khác nhau về tham số và kiểu dữ liệu của nó.
    public Book() {

    }
    // hàm khởi tạo - contructor để làm gì, đặc điểm ntn:           ???
    // Hàm khởi tạo dùng để khởi tạo đối tượng.
    // Đặc điểm: phải có cùng tên với lớp của nó, không có kiểu dữ liệu trả về
    public Book(long id, String name, String description, Date entryDate, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.entryDate = entryDate;
        this.price = price;
    }

    //getter/setter để làm gì: dùng để quản lý quyền truy cập tới thuộc tính và phương thức của đối tượng.
    public long getId() {
        return id;
    }

    public void setId(long id) {
        // từ khóa this: gọi đến đối tượng hiện tại.
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}