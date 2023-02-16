import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShopManager {
    private Scanner scanner = new Scanner(System.in);
    private List<Product> products;

    public ShopManager() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Iphone 11", "2 mat", 2000, new Date()));
        products.add(new Product(1L, "Iphone 11", "2 mat", 2000, new Date()));
        products.add(new Product(1L, "Iphone 11", "2 mat", 2000, new Date()));
        products.add(new Product(1L, "Iphone 11", "2 mat", 2000, new Date()));
        products.add(new Product(1L, "Iphone 11", "2 mat", 2000, new Date()));
    }
    public void showProductsView() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }
    public void addProductsView(Product product) {
        products.add(product);
    }
    public void deleteProductsById(long idProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.remove(i);
                break;
            }
        }
    }
    public void deleteProductView() {
        System.out.println("Nhập id cần xóa: ");
        long idProduct = Long.parseLong(scanner.nextLine());
        deleteProductsById(idProduct);
        showProductsView();
    }
}
