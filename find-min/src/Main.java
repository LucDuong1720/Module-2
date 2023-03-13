import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.printf("Enter your size: ");
            size = input.nextInt();
            if (size < 1)
                System.out.println("Size is not less than 1. Try again!");
        } while (size < 1);

        int arr[];
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter value of element %d: ", i + 1);
            arr[i] = input.nextInt();
        }
        System.out.println("Your entered array: " + Arrays.toString(arr));

        System.out.println("Min value in your array is: " + findMin(arr));
    }
    public static int findMin(int [] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        } return min;
    }
}