import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 10; // số phần tử trong mảng
        int[] array = new int[N];

        // nhập mảng
        for (int i = 0; i < N; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // nhập phần tử cần xoá
        System.out.print("Nhập phần tử cần xoá: ");
        int X = scanner.nextInt();

        // tìm vị trí của X
        int index_del = -1;
        for (int i = 0; i < N; i++) {
            if (array[i] == X) {
                index_del = i;
                break;
            }
        }

        if (index_del == -1) {
            System.out.println("Không tìm thấy phần tử " + X + " trong mảng.");
        } else {
            // xoá phần tử X khỏi mảng
            for (int i = index_del; i < N-1; i++) {
                array[i] = array[i+1];
            }
            // giảm số phần tử của mảng đi 1
            N--;

            System.out.println("Mảng sau khi xoá phần tử " + X + ": " + Arrays.toString(Arrays.copyOf(array, N)));
        }
    }
}