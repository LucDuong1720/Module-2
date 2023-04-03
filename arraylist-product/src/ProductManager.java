import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    List<Product> products;
    public ProductManager() {
        products = new ArrayList<>();
        Product p1 = new Product(1L, "Tai nghe", 100000);
        Product p2 = new Product(2L, "Ip11", 7000000);
        Product p3 = new Product(3L, "Ip12", 10000000);
        Product p4 = new Product(4L, "Ip13", 15000000);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
    }
    public void showProducts() {
        System.out.printf("%5s | %10s | %20s \n",
                            "ID", "Name", "Price");
        for (int i = 0 ; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%5s | %10s | %20s \n",
                            product.getId(), product.getName(), product.getPrice());
        }
    }


    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scan = new Scanner(System.in);
        boolean checkActionMenu = true;
        do {
            System.out.println("Danh sách sản phẩm: ");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm theo id");
            System.out.println("4. Hiện thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Sắp xếp sách sản phẩm tăng dần");
            System.out.println("7. Sắp xếp sách sản phẩm giảm dần");
            int actionMenu = Integer.parseInt(scan.nextLine());
            switch (actionMenu) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.editProduct();
                    break;
                case 3:
                    productManager.deleteProduct();
                    break;
                case 4:
                    productManager.showProducts();
                    break;
                case 5:
                    productManager.searchByName();
                    break;
                case 6:
                    productManager.sortUpByPrice();
                    break;
                case 7:
                    productManager.sortDownByPrice();
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

    public void sortDownByPrice() {
        products.sort(new ComparatorByPrice1());
        showProducts();
    }

    public void sortUpByPrice() {
        products.sort(new ComparatorByPrice());
        showProducts();
    }

    public void searchByName() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();

        List<Product> result = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)) {
                result.add(products.get(i));
            }
        }
        showProducts(result);
    }

    public void showProducts(List<Product> products) {
        System.out.printf("%5s | %10s | %20s \n",
                "ID", "Name", "Price");
        for (int i = 0 ; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%5s | %10s | %20s \n",
                    product.getId(), product.getName(), product.getPrice());
        }
    }


    public void deleteProduct() {
        System.out.println("Nhập Id cần xóa: ");
        long id = Long.parseLong(scanner.nextLine());

        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.remove(i);
            }
        }
        showProducts();
    }

    public void editProduct() {
        System.out.println("Nhập Id cần sửa: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Tên cần thay đổi: ");
        String name = scanner.nextLine();
        System.out.println("Giá cần thay đổi: ");
        double price = Double.parseDouble(scanner.nextLine());

        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.get(i).setName(name);
                products.get(i).setPrice(price);
            }
        }
        showProducts();
    }

    public void addProduct() {
        System.out.println("Nhập thông tin sản phẩm: ");
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        Comparator comparator = new ComparatorById();
        products.sort(comparator);
        long maxId = products.get(products.size() - 1).getId();

        Product product = new Product();
        product.setId(maxId + 1);
        product.setName(name);
        product.setPrice(price);

        products.add(product);

        showProducts();
    }

}

