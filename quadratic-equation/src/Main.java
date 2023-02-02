import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("Your Delta: "+ quadraticEquation.getDiscriminant());
        if(quadraticEquation.getDiscriminant() < 0) {
            System.out.println("The equation has no real roots");
        } else if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("Your Root1: " + quadraticEquation.getRoot1());
            System.out.println("Your Root2: " + quadraticEquation.getRoot2());
        } else {
            System.out.println("The equation has one root: " + quadraticEquation.getRoot1());
        }
    }
}