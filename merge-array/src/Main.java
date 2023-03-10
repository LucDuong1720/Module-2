import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 2, 1, 2};
        int[] arr1 = {2, 3, 8, 3, 9};

        int[] arr3 = new int[arr.length + arr1.length];
        for (int i = 0; i < arr.length; i++ ) {
            arr3[i] = arr[i];
        }
        for (int j = 0; j < arr1.length; j++) {
            arr3[arr.length + j] = arr1[j];
        }
        System.out.println(Arrays.toString(arr3));
    }
}