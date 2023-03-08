import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1L, "IP11", 11000000, 12, "2 mắt" ));
        products.add(new Product(2L, "IP12", 12000000, 6, "3 mắt" ));
        products.add(new Product(3L, "IP13", 13000000, 8, "3 mắt" ));
        products.add(new Product(4L, "IP14", 14000000, 20, "4 mắt" ));
        products.add(new Product(5L, "IP15", 15000000, 17, "5 mắt" ));
    }
    public static void addNewProduct(Product product) {
        products.add(product);
    public List<Product> getAllProduct() {
        return this.products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return this.products;
    }
}
