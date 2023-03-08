import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    static List<Product> productList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choosen = -1;
        do {
            showMenu();
            try {
                do {
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.println(" Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        list();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        deleteProductById();
                        break;
                    case 5:
                        sort();
                        break;
                    case 6:
                        findMax();
                        break;
                    case 7:
                        readProduct();
                        break;
                    case 8:
                        writeProduct();
                        break;
                    case 9:
                        System.out.println("Tạm biệt");
                        break;
                    default:
                        System.out.println("Nhập sai");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (choosen != 9);
    }

    private static void list() {
        System.out.println("_________________________________________________");
        for (Product product : productList) {
            product.display();
            sc.nextLine();
        }
        System.out.println("__________________________________________________");
    }

    private static void addProduct() {
        while (true) {
            try {
                System.out.print("Mã sản phẩm: ");
                String id = sc.nextLine();

                System.out.print("Tên sản phẩm: ");
                String name = sc.nextLine();
                if (name.trim().equals("")) {
                    System.out.print("Không được để trống!");
                    continue;
                }

                System.out.print("Nhập giá: ");
                int price = Integer.parseInt(sc.nextLine());


                System.out.print("Nhập số lượng: ");
                int quantity = Integer.parseInt(sc.nextLine());

                System.out.print("Nhập mô tả: ");
                String describe = sc.nextLine();
                if (name.trim().equals("")) {
                    System.out.println("Không được để trống!");
                    continue;
                }

                Product product = new Product(id, name, price, quantity, describe);
                productList.add(product);
                break;
            } catch (Exception e) {
                System.out.println("Nhập sai, vui lòng nhập lại!");
            }
        }
    }

    public static void edit() {
        while (true) {
            System.out.print("Nhập mã sản phẩm cần sửa:");
            String id = sc.nextLine();
            if (id.equals("")) {
                return;
            }

            for (Product product : productList) {
                if (product.getId().equals(id)) {
                    editProduct(product);
                    return;
                }
            }
            System.out.println("Không tìm thấy sản phẩm với mã sản phẩm trên. Vui lòng nhập lại!");
        }

    }

    private static void deleteProductById() {
        while (true) {
            System.out.println("Nhập id sản phẩm cần xóa:");
            String id = sc.nextLine();
            if (id.equals("")) {
                return;
            }

            for (Product product : productList) {
                if (product.getId().equals(id)) {
                    System.out.println("Nhập Y để xóa sản phẩm");
                    String chosen = sc.nextLine();
                    if (chosen.equals("Y")) {
                        productList.remove(product);
                        System.out.println("Xóa sản phẩm thành công!");
                        return;
                    }
                    break;
                }
            }
            System.out.println("Không tìm thấy sản phẩm với mã sản phẩm trên. Vui lòng nhập lại!");
        }
    }

    private static void sort() {
        System.out.println("1. Tăng dần");
        System.out.println("2. Hiện thị danh sách sản phẩm");
        System.out.println("3. Trở lại");
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number == 1) {
                    productList.sort((o1, o2) -> {
                        if (o1.getPrice() > o2.getPrice()) {
                            return 1;
                        }
                        return -1;
                    });
                    System.out.println("Sắp xếp xong!");
                    System.out.println("Nhập 2 để hiện thị MENU!");
                    System.out.println("Nhập 3 để về lại MENU!");
                }
                if (number == 2) {
                    list();
                    System.out.println("Nhập 3 để về lại MENU!");
                }
                if (number == 3) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai, vui lòng nhập lại!");
            }
        }
    }

    private static void findMax() {
        int max = 0;
        Product newProduct = new Product();
        for (Product product : productList) {
            if (product.getPrice() > max) {
                max = product.getPrice();
                newProduct = product;
            }
        }
        newProduct.display();
    }

    public static void readProduct() {
    }

    public static void writeProduct() {
    }

    public static void editProduct(Product product) {
        System.out.println("Nhập thông tin cần sửa");
        try {
            System.out.print("Nhập mã sản phẩm : ");
            String id = sc.nextLine();

            System.out.print("Nhập tên sản phẩm: ");
            String name = sc.nextLine();

            System.out.print("Nhập giá (Không sửa nhập 0): ");
            int price = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập số lượng: ");
            int quantity = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập mô tả: ");
            String describe = sc.nextLine();
            if (!id.equals("")) {
                product.setId(id);
            }
            if (!name.equals("")) {
                product.setName(name);
            }
            if (!(price == 0)) {
                product.setPrice(price);
            }
            if (!(quantity == 0)) {
                product.setQuantity(quantity);
            }
            if (!describe.equals("")) {
                product.setDescribe(describe);
            }
            System.out.print("Cập nhật thành công!");
        } catch (Exception e) {
            System.out.print("Nhập sai!");
        }
    }

    static void showMenu() {
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
        System.out.print("Chọn chức năng: ");
    }
}
