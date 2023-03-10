import java.util.Arrays;
import java.util.Scanner;

public class InsertElementToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10, 4, 6, 7, 8};
        System.out.print("Nhập số cần chèn: ");
        int X = scanner.nextInt();
        System.out.print("Nhập vị trí cần chèn: ");
        int index = scanner.nextInt();

        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = arr[i];
            } else if (i == index) {
                newArr[i] = X;
            } else {
                newArr[i] = arr[i - 1];
            }
        }
        if (index < 0 || index > arr.length - 1) {
            System.out.println("Không chèn được phần tử vào mảng");
        } else {
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = X;
            System.out.println("Mảng sau khi chèn phần tử " + X + " vào vị trí " + index + ":");
            System.out.println(Arrays.toString(newArr));
        }
    }
}