import model.ComparatorById;
import model.ComparatorByName;
import model.ComparatorByPrice;
import model.Product;

import java.util.*;

public class ProductsView {
    List<Product> products;
    Scanner scanner = new Scanner(System.in);
    public ProductsView() {
        products = new ArrayList<>();
//        long id, String name, String brand, String origin, String capacity, int quantity, long price, Date creatAt, Date
//        updateAt
        products.add(new Product(1L, "Chanel Bleu De Chanel", "Chanel", "Pháp",
                "100ml", 50, 3250000, new Date(), new Date()));
        products.add(new Product(2L, "Valentino Uomo Born In Roma", "Valentino", "Ý",
                "100ml", 70, 2100000, new Date(), new Date()));
        products.add(new Product(3L, "Chanel Gabrielle", "Chanel", "Pháp",
                "50ml", 24, 2500000, new Date(), new Date()));
        products.add(new Product(4L, "Dior Pure Poison", "Dior", "Pháp",
                "30ml", 27, 1600000, new Date(), new Date()));
        products.add(new Product(5L, "Chanel Coco Noir", "Chanel", "Pháp",
                "100ml", 12, 3550000, new Date(), new Date()));
        products.add(new Product(6L, "Dior Homme Parfum", "Dior", "Pháp",
                "100ml", 23, 3300000, new Date(), new Date()));
        products.add(new Product(7L, "Burberry My Burberry Blush", "Burberry", "Anh",
                "100ml", 43, 2400000, new Date(), new Date()));
        products.add(new Product(8L, "Burberry Mr. Burberry", "Burberry", "Anh",
                "50ml", 28, 1600000, new Date(), new Date()));
        products.add(new Product(9L, "Valentino Donna Born In Roma", "Valentino", "Ý",
                "30ml", 23, 2400000, new Date(), new Date()));
        products.add(new Product(10L, "Gucci Flora Gorgeous Jasmin", "Gucci", "Pháp",
                "50ml", 12, 2700000, new Date(), new Date()));
    }
    public void showProducts() {
        System.out.printf("%5s | %30s | %10s | %10s | %10s | %10s | %10s | %35s | %35s\n ",
                "ID", "Name", "Brand", "Origin", "Capacity", "Quantity", "Price", "Date Created", "Date Update");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%5s | %30s | %10s | %10s | %10s | %10s | %10s | %35s | %35s\n ",
                    product.getId(), product.getName(), product.getBrand(), product.getOrigin(), product.getCapacity(), product.getQuantity(),
                    product.getPrice(), product.getCreatAt(), product.getUpdateAt());
        }
    }
    public void showProducts(List<Product> products) {
        System.out.printf("%5s | %30s | %10s | %10s | %10s | %10s | %10s | %35s | %35s\n ",
                "ID", "Name", "Brand", "Origin", "Capacity", "Quantity", "Price", "Date Created", "Date Update");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%5s | %30s | %10s | %10s | %10s | %10s | %10s | %35s | %35s\n ",
                    product.getId(), product.getName(), product.getBrand(), product.getOrigin(), product.getCapacity(), product.getQuantity(),
                    product.getPrice(), product.getCreatAt(), product.getUpdateAt());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductsView productsView = new ProductsView();
        boolean checkActionMenu = true;
        do {
            System.out.println("Menu quản lý sản phẩm: ");
            System.out.println("Nhấn 1. Xem danh sách");
            System.out.println("Nhấn 2. Thêm sản phẩm");
            System.out.println("Nhấn 3. Sửa sản phẩm");
            System.out.println("Nhấn 4. Xóa sản phẩm");
            System.out.println("Nhấn 5. Sắp xếp sản phẩm theo giá ");
            System.out.println("Nhấn 6. Sắp xếp sản phẩm theo tên ");
            System.out.println("Nhấn 7. Tìm kiếm sản phẩm theo tên");
            int actionMenu = Integer.parseInt(scan.nextLine());
            switch (actionMenu) {
                case 1:
                    productsView.showProducts();
                    break;
                case 2:
                    productsView.addProduct();
                    break;
                case 3:
                    productsView.editProduct();
                    break;
                case 4:
                    productsView.deleteProduct ();
                    break;
                case 5:
                    productsView.sortByPrice();
                    break;
                case 6:
                    productsView.sortByName();
                    break;
                case 7:
                    productsView.searchByName();
                    break;
                default:
                    System.out.println("Nhập sai rồi bạn ơi! Vui lòng nhập lại");
            }
            boolean checkActionMenuContinue = true;
            do {
                System.out.println("Bạn có muốn tiếp tục hay không: Y/N");
                String actionMenuContinue = scan.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        checkActionMenuContinue = false;
                        break;
                    case "N":
                        checkActionMenu = false;
                        checkActionMenuContinue = false;
                        break;
                    default:
                        checkActionMenuContinue = true;
                }
            }while (checkActionMenuContinue) ;

        } while (checkActionMenu);

    }

    private void searchByName() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();

        List<Product> results = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)) {
                results.add(products.get(i));
            }
        }
        if (results.size() == 0) {
            System.out.println("Không có sản phẩm cần tìm.");
        }
        showProducts(results);
    }

    private void sortByName() {
        products.sort(new ComparatorByName());
        showProducts();
    }

    private void sortByPrice() {
        products.sort(new ComparatorByPrice());
        showProducts();
    }

    private void deleteProduct() {
        System.out.println("Nhập ID sản phẩm cần xóa: ");
        long id = Long.parseLong(scanner.nextLine());

        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.remove(i);
            }
        }
        showProducts();
    }

    private void editProduct() {
        System.out.println("Nhập ID sản phẩm cần thay đổi: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Nhập tên sản phẩm mới: ");
        String name = scanner.nextLine();
        System.out.println("Nhập thương hiệu sản phẩm mới: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập xuất xứ sản phẩm mới: ");
        String origin = scanner.nextLine();
        System.out.println("Nhập dung tích sản phẩm mới: ");
        String capacity = scanner.nextLine();
        System.out.println("Nhập số lượng sản phẩm mới: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá sản phẩm mới: ");
        double price = Double.parseDouble(scanner.nextLine());

        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.get(i).setName(name);
                products.get(i).setBrand(brand);
                products.get(i).setOrigin(origin);
                products.get(i).setCapacity(capacity);
                products.get(i).setQuantity(quantity);
                products.get(i).setPrice(price);
            }
        }
        showProducts();
    }

    private void addProduct() {
        System.out.println("Nhập thông tin sản phẩm:" );
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập thương hiệu sản phẩm: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập xuất xứ sản phẩm: ");
        String origin = scanner.nextLine();
        System.out.println("Nhập dung tích sản phẩm: ");
        String capacity = scanner.nextLine();
        System.out.println("Nhập số lượng sản phẩm: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        Comparator comparator = new ComparatorById();
        products.sort(comparator);
        long maxId = products.get(products.size() - 1).getId();

        Product product = new Product();
        product.setId(maxId + 1);
        product.setName(name);
        product.setBrand(brand);
        product.setOrigin(origin);
        product.setCapacity(capacity);
        product.setQuantity(quantity);
        product.setPrice(price);

        products.add(product);

        showProducts();

    }

}

