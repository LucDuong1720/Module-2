import java.util.*;

public class CustomerView {
    List<Customer> customers;
    Scanner scanner = new Scanner(System.in);

    public CustomerView() {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, "Quang Dang", "quangdang@gmail.com", "32 Le Loi", new Date()));
        customers.add(new Customer(2L, "2Quang Dang", "quangdang2@gmail.com", "42 Ham Nghi", new Date()));
        customers.add(new Customer(3L, "3Quang Dang", "quangdang3@gmail.com", "92 Le Quy Don", new Date()));
        customers.add(new Customer(4L, "8Quang Dang", "quangdang8@gmail.com", "23 Nguyen Chi Dieu", new Date()));
        customers.add(new Customer(5L, "6Quang Dang", "quangdang6@gmail.com", "51 Trinh Cong Son", new Date()));
        customers.add(new Customer(6L, "5Quang Dang", "quangdang5@gmail.com", "32 Nguyen Hue", new Date()));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustomerView customerView = new CustomerView();
        boolean checkActionMenu = true;
        do {
            System.out.println("Menu quản lý customer: ");
            System.out.println("Nhấn 1. Xem danh sách");
            System.out.println("Nhấn 2. Thêm khách hàng ");
            System.out.println("Nhấn 3. Sửa khách hàng");
            System.out.println("Nhấn 4. Xóa khách hàng");
            System.out.println("Nhấn 5. Sắp xếp khách hàng theo tên ");
            System.out.println("Nhấn 6. Sắp xếp khách hàng theo ngày tạo");
            System.out.println("Nhấn 7. Tìm kiếm khách hàng theo tên");
            System.out.println("Nhấn 8. Tìm kiếm khách hàng theo tên hoặc email");
            int actionMenu = Integer.parseInt(scan.nextLine());
            switch (actionMenu) {
                case 1:
                    customerView.showCustomers();
                    break;
                case 2:
                    customerView.addNewCustomer();
                    break;
                case 3:
                    customerView.editCustomer();
                    break;
                case 4:
                    customerView.deleteCustomer();
                    break;
                case 5:
                    customerView.sortByName();
                    break;
                case 6:
                    customerView.sortByDateCreate();
                    break;
                case 7:
                    customerView.searchByName();
                    break;
                case 8:
                    customerView.searchByNameOrEmail();
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
            } while (checkActionMenuContinue);

        } while (checkActionMenu);

    }

    private void searchByNameOrEmail() {
        System.out.println("Nhập tên khách hàng hoặc email cần tìm: ");
        String nameoremail = scanner.nextLine();
        List<Customer> result = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getFullName().contains(nameoremail) || customers.get(i).getEmail().contains(nameoremail)) {
                result.add(customers.get(i));
            }
        }
        showCustomers(result);
    }

    private void searchByName() {
        System.out.println("Nhập tên khách hàng cần tìm: ");
        String name = scanner.nextLine();
        List<Customer> result = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getFullName().contains(name)) {
                result.add(customers.get(i));
            }
        }
        showCustomers(result);
    }

    private void sortByDateCreate() {
    }

    private void sortByName() {
        customers.sort(new ComparatorByNameCustomer());
        showCustomers();
    }

    private void deleteCustomer() {
        System.out.println("Nhập ID khách hàng cần xóa");
        long id = Long.parseLong(scanner.nextLine());

        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customers.remove(i);
            }
        }
        showCustomers();

    }

    private void editCustomer() {
        System.out.println("Nhập ID khách hàng bạn muốn sửa: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Nhập tên khách hàng mới: ");
        String newName = scanner.nextLine();
        System.out.println("Nhập email mới: ");
        String newEmail = scanner.nextLine();
        System.out.println("Nhập địa chỉ mới: ");
        String newAddress = scanner.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customers.get(i).setFullName(newName);
                customers.get(i).setEmail(newEmail);
                customers.get(i).setAddress(newAddress);
            }
        }
        showCustomers();
    }

    private void addNewCustomer() {
        System.out.println("Nhập thông tin khách hàng cần thêm: ");
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        Comparator comparator = new ComparatorByIdCustomer();
        customers.sort(comparator);
        long maxId = customers.get(customers.size()-1).getId();

        Customer customer = new Customer();
        customer.setId(maxId + 1);
        customer.setFullName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setCreateAt(new Date());

        customers.add(customer);

        showCustomers();
    }

    public void showCustomers() {
        System.out.printf("%5s | %20s | %20s | %20s | %20s \n", "ID", "Name", "Email", "Address", "Date");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.printf("%5s | %20s | %20s | %20s | %20s \n",
                    customer.getId(), customer.getFullName(), customer.getEmail(),
                    customer.getAddress(), customer.getCreateAt());
        }
    }

    public void showCustomers(List<Customer> customers) {
        System.out.printf("%5s | %20s | %20s | %20s | %20s \n", "ID", "Name", "Email", "Address", "Date");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.printf("%5s | %20s | %20s | %20s | %20s \n",
                    customer.getId(), customer.getFullName(), customer.getEmail(),
                    customer.getAddress(), customer.getCreateAt());
        }
    }
}


