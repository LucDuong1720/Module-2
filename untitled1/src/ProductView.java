import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    static List<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productService;
    public static void laucher() {
        boolean checkActionMenu = false;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.printf("Chọn chức năng:");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showProductView();
                    break;
                case 2:
                    addProductView();
                    break;
                case 3:
                
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 8:
                    
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại");
                    checkActionMenu = true;
                    continue;
            }
            boolean checkActionMenuContinue = false;
            do{
                checkActionMenuContinue = false;
                System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
                String actionMenuContinue = scanner.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        break;
                    case "N":
                        checkActionMenu = false;
                        break;
                    default:
                        System.out.println("Nhập không không đúng vui lòng nhập lai");
                        checkActionMenuContinue = true;

                }
            }while (checkActionMenuContinue);

        } while (checkActionMenu);
    }

    private static void addProductView() {
        Product product = new Product();

        System.out.println("- Mã sản phẩm: ");
        long id = Integer.parseInt(scanner.nextLine());
        System.out.println("- Tên: ");
        String name = scanner.nextLine();
        System.out.println("- Giá: " );
        double price = Integer.parseInt(scanner.nextLine());
        System.out.println("- Số lượng: ");
        double quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("- Mô tả: ");
        String describe = scanner.nextLine();

        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDescribe(describe);
        ProductService.addNewProduct(product);
    }

    public ProductView() {
        productService = new ProductService();
    }
    private static void showProductView() {
        List<Product> products = productService.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println("- Lựa chọn thêm mới");
            System.out.println("- Mã sản phẩm: " + products.get(i).getId());
            System.out.println("- Tên: " + products.get(i).getName());
            System.out.println("- Giá: " + products.get(i).getPrice());
            System.out.println("- Số lượng: " + products.get(i).getQuantity());
            System.out.println("- Mô tả: " + products.get(i).getDescribe());
            System.out.println("");
        }
    }
}
