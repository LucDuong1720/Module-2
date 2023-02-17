import java.util.*;

public class ShopManager {
    private Scanner scanner = new Scanner(System.in);
    private static List<Product> products;

    public static List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ShopManager() {
        products = new ArrayList<>();
        products.add(new Product(1L, "MacBook Air M2", "16GB RAM", 32000000, new Date()));
        products.add(new Product(2L, "MacBook Pro M1", "8GB RAM", 30000000, new Date()));
        products.add(new Product(3L, "MacBook Pro M1", "8GB RAM", 21000000, new Date()));
        products.add(new Product(4L, "MacBook Pro M2", "16GB RAM", 29500000, new Date()));
        products.add(new Product(5L, "MacBook Air M2", "8GB RAM", 26000000, new Date()));
    }
    public void showProductsView(List<Product> products) {
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
        showProductsView(products);
    }

    public void sortProductByPrice() {
        System.out.println("Sắp xếp sản phẩm theo giá thành");
        Comparator comparator = new ComparatorByPrice();
        products.sort(comparator);
        showProductsView(products);
    }

    public void searchProductView() {
        System.out.println("Tìm kiếm theo tên: ");
        String nameSearch = scanner.nextLine();
        List<Product> results = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(nameSearch)) {
                results.add(products.get(i));
            }
        }
        showProductsView(results);
    }

    public void sortProductByName() {
        System.out.println("Sắp xếp sản phẩm theo tên");
        
    }

    public void searchProductByPrice() {
    }
}
