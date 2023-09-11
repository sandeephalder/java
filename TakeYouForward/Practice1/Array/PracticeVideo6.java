package Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PracticeVideo6 {

    // Video Link
    // https://www.youtube.com/watch?v=tp8JIuCXBaU&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=6

    int[] arr = { 2, 1, 2, 0, 1, 2, 0, 1, 0, 0, 2, 0, 1, 0, 0, 1, 2, 1, 0, 1, 2, 0, 1 };

    public static void main(String[] args) {
        new PracticeVideo6();
    }

    PracticeVideo6() {
        sortArray(arr);
        System.out.println("Sort Array Quick by partition: " + Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public void sortArray(int[] arr) {
        int l = 0, m = 0, r = arr.length - 1;
        while (m <= r) {
            while (arr[m] < 2) {
                if (arr[m] == 0) {
                    exch(arr, l++, m++);
                } else if (arr[m] == 1) {
                    m++;
                }
            }

            while (arr[r] == 2) {
                r--;
            }
            exch(arr, m, r);
        }
        exch(arr, m, r);
    }

    public void exch(int[] arr, int src, int dest) {
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }
}
