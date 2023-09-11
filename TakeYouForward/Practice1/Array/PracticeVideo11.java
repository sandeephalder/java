package Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PracticeVideo11 {

    // Video Link:
    // https://www.youtube.com/watch?v=JDOXKqF60RQ&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=11

    // int[] arr = { 2, 1, 5, 4, 3, 0, 0 };
    int[] arr = { 3, 1, 2 };

    public static void main(String[] args) {
        new PracticeVideo11();
    }

    PracticeVideo11() {
        System.out.println("Find next number in permutation "
                + Arrays.stream(findNextNumberInSequence(arr)).boxed().collect(Collectors.toList()));
    }

    private int[] findNextNumberInSequence(int arr[]) {
        int N = arr.length;
        int result[] = new int[N], pivot = N - 2, max = 0, min = 0;
        while (pivot >= 0 && arr[pivot] > arr[pivot + 1])
            --pivot;

        pivot = N - pivot - 1;
        System.out.println("Pivot :" + (pivot));

        min = pivot;
        for (int i = N - 1; i > pivot; i--) {

            if (arr[i] > arr[min]) {
                min = i;
                break;
            }

        }
        System.out.println("Min :" + arr[min]);

        swap(arr, pivot, min);

        result = Arrays.copyOf(arr, N);

        return result;
    }

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
