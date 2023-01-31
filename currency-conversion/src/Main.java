import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float vnd = 23000;
        float usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền USD: ");
        usd = scanner.nextFloat();
        float quydoi = usd * 23000;
        System.out.println("Giá trị VND: " + quydoi);
    }
}