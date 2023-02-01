import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
    public static void display() {
        System.out.println("Nhập số lượng số nguyên tố cần hiện thị:");
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        int i = 2;
        int count = 0;
        while (count < num) {
            if (isPrime(i)) {
                System.out.print(" " + i);
                count++;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        display();
    }
}