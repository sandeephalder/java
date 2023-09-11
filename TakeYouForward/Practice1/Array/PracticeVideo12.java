package Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PracticeVideo12 {

    // Video Link :
    // https://www.youtube.com/watch?v=cHrH9CQ8pmY&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=12

    int arr[] = { 10, 22, 12, 3, 0, 6 };

    public static void main(String[] args) {
        new PracticeVideo12();
    }

    PracticeVideo12() {
        System.out.println("Leaders in array" + Arrays.stream(findLeaders(arr)).boxed().collect(Collectors.toList()));
    }

    public int[] findLeaders(int[] arr) {
        int N = arr.length, max = 0, count = 0;
        int[] leaders = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                leaders[count++] = arr[i];
            }
        }
        return leaders;
    }

}
