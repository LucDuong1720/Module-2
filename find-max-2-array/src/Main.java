import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập ma trận");
        int size = input.nextInt();
        int[][] matrix = new int[size][size];
        System.out.printf("Enter value of %d elements in matrix: \n", size*size);
        int k = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("Value of element %d: ", k++);
                matrix[i][j] = input.nextInt();
            }
        }
        //Find max value
        System.out.println("Your matrix: " + Arrays.deepToString(matrix));
        int max = matrix[0][0];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Max value in your matrix: " + max);
    }
}