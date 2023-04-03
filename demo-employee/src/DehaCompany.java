import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DehaCompany {
    private Scanner scanner = new Scanner(System.in);
    List<Employee> employees;

    public DehaCompany() {
        employees = new ArrayList<>();
        //long id, String fullName, Date birthDay, String phone, String email,
        // EmployeeType employeeType, int expInYear, String proSkill
        Employee ep1 = new Experience(1L, "Quang Dang", new Date(1992, 7, 18), "033399457133",
                "quang.dang@codegym.vn", EmployeeType.Experience, 5, "Chem gio");
        // String majors, int semester, String universityName)
        Employee ep2 = new Intern("Chem gio", 4, "Duy Tan");
        ep2.setFullName("Quoc Phap");
        ep2.setEmail("phapsukumathon@gmail.com");
        ep2.setBirthDay(new Date(2000, 2, 2));
        ep2.setId(2L);
        ep2.setEmployeeType(EmployeeType.Intern);

        employees.add(ep1);
        employees.add(ep2);

    }
    public void showEmployees(){
        System.out.printf("%5s | %10s | %30s | %20s | %30s | %10s \n",
                "ID", "Name", "Birthday","Phone","Email", "Employee Type");
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            System.out.printf("%5s | %10s | %30s | %20s | %30s | %10s \n",
                    e.getId(), e.getFullName(), e.getBirthDay(),e.getPhone(),e.getEmail(), e.getEmployeeType());
        }
    }

    public void addEmployee() {
        System.out.println("Nhập thông tin cơ bản: ");
        System.out.println("Họ tên:");
        String fullName = scanner.nextLine();

        System.out.println("Ngày sinh");
        Date date = new Date();

        System.out.println("Số điện thoại");
        String phone = scanner.nextLine();

        System.out.println("Email:");
        String email = scanner.nextLine();


        System.out.printf("Bạn muốn thêm loại nào");
        System.out.println("Nhập 1: Thêm Experience");
        System.out.println("Nhập 2: Thêm Fresher");
        System.out.println("Nhập 3: Thêm Intern");

        int actionADD = Integer.parseInt(scanner.nextLine());
        Employee employee = null;

        switch (actionADD) {
            case 1:
            {
                employee = new Experience(maxId()+1, fullName, date, phone, email, EmployeeType.Experience);
                inputEmployee(employee, EmployeeType.Experience);
                break;
            }
            case 2:
            {
                employee = new Fresher(maxId()+1, fullName, date, phone, email, EmployeeType.Fresher);
                inputEmployee(employee, EmployeeType.Fresher);
                break;
            }
        }
        employees.add(employee);
        showEmployees();
    }

    public Employee findEmployeeById(long id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return employees.get(i);
            }
        }
        return null;
    }
    public void editEmployee() {
        System.out.println("Nhập ID:");
        long id = Long.parseLong(scanner.nextLine());

        Employee employee = findEmployeeById(id);

        System.out.println("Bạn muốn cập nhật loại gì: ");
        System.out.println("Nhập 1: Experience");
        System.out.println("Nhập 2: Fresher");
        System.out.println("Nhập 3: Intern");
        int actionEdit = Integer.parseInt(scanner.nextLine());
        switch (actionEdit) {
            case 1:
                // Experience
                employee = new Experience(employee.getId(), employee.getFullName(),
                        employee.getBirthDay(), employee.getPhone(), employee.getEmail(), EmployeeType.Experience);
                inputEmployee(employee, EmployeeType.Experience);
                break;
            case 2:
                // Fresher
                employee = new Fresher(employee.getId(), employee.getFullName(),
                        employee.getBirthDay(), employee.getPhone(), employee.getEmail(), EmployeeType.Fresher);
                inputEmployee(employee, EmployeeType.Fresher);
                break;
        } 
        updateEmployeeById(id, employee);
        showEmployees();
    }

    private void updateEmployeeById(long id, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, employee);
            }
        }
    }

    /**
     private void inputEmployeeFresher(Employee employee) {
     System.out.println("Nhập ngày tot nghiệp:");
     Date dateGraduation = new Date();
     System.out.println("Nhập xếp loại tốt nghiệp: ");
     String rankGraduation = scanner.nextLine();
     System.out.println("Tốt nghiệp trường:");
     String graduation = scanner.nextLine();
     if (employee instanceof Fresher) {
     Fresher fresher = (Fresher) employee;
     fresher.setEducation(graduation);
     fresher.setGraduationDate(dateGraduation);
     fresher.setGraduationRank(rankGraduation);
     }
     employees.add(employee);
     }
     private void inputEmployeeExperience(Employee employee) {
     System.out.println("Nhập số năm kinh nghiệm: ");
     int expYear = Integer.parseInt(scanner.nextLine());
     System.out.println("Nhập kĩ năng chuyên môn: ");
     String proSkill = scanner.nextLine();
     //long id, String fullName, Date birthDay, String phone,
     // String email, EmployeeType employeeType, int expInYear, String proSkill
     //        employee = new Experience(maxId()+1, fullName, date, phone,
     //                email, employeeType, expYear, proSkill);
     if (employee instanceof Experience) {
     Experience ex = (Experience) employee;
     ex.setProSkill(proSkill);
     ex.setExpInYear(expYear);
     }
     employees.add(employee);
     System.out.println(employee);
     }
     **/

    private void   inputEmployee(Employee employee, EmployeeType type) {
        switch (type) {
            case Experience:
                System.out.println("Nhập số năm kinh nghiệm: ");
                int expYear = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập kĩ năng chuyên môn: ");
                String proSkill = scanner.nextLine();
                if (employee instanceof Experience) {
                    Experience ex = (Experience) employee;
                    ex.setProSkill(proSkill);
                    ex.setExpInYear(expYear);
                }
                break;
            case Fresher:
                System.out.println("Nhập ngày tot nghiệp:");
                Date dateGraduation = new Date();
                System.out.println("Nhập xếp loại tốt nghiệp: ");
                String rankGraduation = scanner.nextLine();
                System.out.println("Tốt nghiệp trường:");
                String graduation = scanner.nextLine();

                if (employee instanceof Fresher) {
                    Fresher fresher = (Fresher) employee;
                    fresher.setEducation(graduation);
                    fresher.setGraduationDate(dateGraduation);
                    fresher.setGraduationRank(rankGraduation);
                }
                break;

        }
    }

    public static void main(String[] args) {
        DehaCompany dehaCompany = new DehaCompany();
//        dehaCompany.showEmployees();
        dehaCompany.editEmployee();
    }

    public long maxId() {
        employees.sort(new ComparatorById());
        return employees.get(employees.size()-1).getId();
    }
}