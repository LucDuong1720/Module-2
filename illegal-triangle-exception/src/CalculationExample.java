import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập c: ");
        int c = Integer.parseInt(scanner.nextLine());

        CalculationExample calc = new CalculationExample();
        calc.calculate(a,b,c);
    }

    private void calculate(int a, int b, int c) {
        try {
            if (a < 0 || b < 0 || c < 0) {
               throw new IllegalTriangleException("Các cạnh của tam giác phải là số dương");
            }
            if (a + b <= c || a + c <= b || c + b <= a) {
                throw new IllegalTriangleException("Tổng 2 cạnh của tam giác phải lớn hơn cạnh còn lại");
            }
            System.out.println("Các cạnh của tam giác hợp lệ.");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}