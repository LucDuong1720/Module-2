import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 4, 1};

        System.out.println("Origin Array");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        /**
        int[] copy = Arrays.copyOf(arr, 4);
        copy[3] = 12;

        System.out.println("\nNew array");
        for (int i = 0; i < copy.length; i++)
            System.out.print(copy[i] + " ");
         
         */
    }
    /**
    public static void deleteElementFromIndex(int[] arr, int from, int to) {
        for (int i = from; i <= to; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length-1] = 0;
    }
     */

}