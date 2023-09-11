package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeVideo16 {

    // Video URL:
    // https://www.youtube.com/watch?v=3Zv-s9UUrFM&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=16

    // int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15
    // }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };

    int[][] arr = { { 1, 2, 3, 4 }, { 6, 7, 8, 9 }, { 11, 12, 13, 14 }, { 16, 17, 18, 19 }, { 21, 22, 23, 24 } };

    public static void main(String[] args) {
        new PracticeVideo16();
    }

    PracticeVideo16() {
        printMetrics(arr);
        System.out.println("Metrics Sprial Traverse" + walkSpiral(arr));

    }

    public List<Integer> walkSpiral(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = arr[0].length - 1, top = 0, bottom = arr.length - 1;

        while (left <= right && top <= bottom) {
            // Left to Right
            for (int i = left; i <= right; i++)
                result.add(arr[top][i]);

            top++;
            // Top to Down
            for (int i = top; i <= bottom; i++)
                result.add(arr[i][right]);

            right--;

            // Right to Left
            for (int i = right; i >= left; i--)
                result.add(arr[bottom][i]);

            bottom--;

            // Down to Up

            for (int i = bottom; i >= top; i--)
                result.add(arr[i][left]);

            left++;
        }

        return result;
    }

    public void printMetrics(int[][] arr) {
        System.out.println();
        for (int[] a : arr) {
            System.out.println();
            Arrays.stream(a).boxed().map(e -> e + " ==>").forEach(System.out::print);
        }
        System.out.println();
    }
}
