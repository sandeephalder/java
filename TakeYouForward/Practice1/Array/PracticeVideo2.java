package Array;

// Video 2 : https://www.youtube.com/watch?v=wvcQg43_V8U&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=2

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeVideo2 {
    int[] arr = { 2, 1000, 4, 1, 7, 3, 9, 6, 7, 4, 5, 9, 90, 221, 654 };
    int[] zeroes = { 7, 3, 4, 0, 5, 7, 0, 2, 0, 1, 8, 0, 5, 4, 3, 0, 0, 3, 0, 1, 0, 0 };

    int[] u1 = { 2 };
    int[] u2 = { 1 };

    public static void main(String[] args) {
        new PracticeVideo2();
    }

    PracticeVideo2() {
        System.out.println("Rotate Left ");
        leftRotateByOnePlace(arr);
        printArray(arr);

        System.out.println("Rotate Left By D places");
        leftRotateByDPlace(arr, 3);
        printArray(zeroes);

        System.out.println("Move Zeroes to end");
        moveZerorsToEnd(zeroes);
        printArray(zeroes);

        System.out.println("Linear search" + findLinearSearch(arr, 3));

        System.out.println("Union of 2 arrays" + findUnion(u1, u2));

        System.out.println("Intesection of 2 arrays" + findIntersection(u1, u2));

    }

    public List<Integer> findUnion(int[] u1, int[] u2) {
        List<Integer> result = new ArrayList<>();
        int l1 = u1.length, l2 = u2.length, p0 = 0, p1 = 0;

        while (p0 < l1 || p1 < l2) {

            if (p0 >= l1) {
                if (result.size() == 0 || u2[p1] > result.get(result.size() - 1))
                    result.add(u2[p1]);
                p1++;
                continue;
            }
            if (p1 >= l2) {
                if (result.size() == 0 || u1[p0] > result.get(result.size() - 1))
                    result.add(u1[p0]);
                p0++;
                continue;
            }

            if (u1[p0] > u2[p1]) {
                if (result.size() == 0 || u2[p1] > result.get(result.size() - 1))
                    result.add(u2[p1]);
                p1++;
            } else if (u1[p0] <= u2[p1]) {
                if (result.size() == 0 || u1[p0] > result.get(result.size() - 1))
                    result.add(u1[p0]);
                if (u1[p0] == u2[p1])
                    p1++;
                p0++;
            }

        }

        return result;
    }

    public List<Integer> findIntersection(int[] u1, int[] u2) {

        List<Integer> result = new ArrayList<>();
        int l1 = u1.length, l2 = u2.length, p0 = 0, p1 = 0;

        while (p0 < l1 && p1 < l2) {

            if (u1[p0] > u2[p1])
                p1++;
            else if (u1[p0] < u2[p1])
                p0++;
            else if (u1[p0] == u2[p1]) {
                if (result.size() == 0 || u2[p1] > result.get(result.size() - 1))
                    result.add(u2[p1]);
                p1++;
                p0++;
            }
        }
        return result;
    }

    public void leftRotateByOnePlace(int arr[]) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++)
            arr[i - 1] = arr[i];
        arr[arr.length - 1] = temp;
    }

    public void printArray(int[] arr) {
        System.out.println();
        System.out.println(IntStream.of(arr).boxed().collect(Collectors.toList()));
    }

    private void leftRotateByDPlace(int arr[], int d) {
        reverseArray(arr, 0, d);
        reverseArray(arr, d + 1, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
    }

    private void moveZerorsToEnd(int arr[]) {
        int len = arr.length, l = 0, r = 0;
        for (int i = 0; i < len; i++) {
            if (arr[r] != 0)
                swap(arr, l++, r++);
            else
                r++;
        }
    }

    private int findLinearSearch(int arr[], int d) {
        int index = -1;

        return index;
    }

    private void reverseArray(int arr[], int start, int end) {
        int mid = (start + end) / 2;

        for (int i = 0; i <= mid - start; i++)
            swap(arr, start + i, end - i);

    }

    public void swap(int arr[], int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
