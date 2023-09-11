package Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PracticeVideo9 {

    // Video Link:
    // https://www.youtube.com/watch?v=h4aBagy4Uok&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=9

    int[] arr1 = { 3, 1, -2, -5, -6, 2, 4, -6 };
    int[] arr2 = { 3, 1, -2, -5, -6, 2, 4, -6 };

    public static void main(String[] args) {
        new PracticeVideo9();
    }

    PracticeVideo9() {
        reArrangeElementsBySignExtraSpace(arr1);
        System.out.println(
                "Rearrange Array by Sign Extra space" + Arrays.stream(arr1).boxed().collect(Collectors.toList()));

        System.out.println(
                "Rearrange Array by Sign Optimized"
                        + Arrays.stream(reArrangeElementsBySignOptimized(arr2)).boxed().collect(Collectors.toList()));
    }

    public void reArrangeElementsBySignExtraSpace(int[] arr) {
        int N = arr.length, l = 0, r = 0, i = 0, ll = 0, rr = 0;
        int pos[] = new int[N];
        int neg[] = new int[N];

        for (int ii = 0; ii < N; ii++) {
            if (arr[ii] >= 0)
                pos[l++] = arr[ii];
            else
                neg[r++] = arr[ii];
        }

        while (ll < l || rr < r) {
            if (ll >= l)
                arr[i++] = neg[rr++];
            else if (rr >= r)
                arr[i++] = pos[ll++];
            else if (i % 2 == 0)
                arr[i++] = pos[ll++];
            else
                arr[i++] = neg[rr++];
        }
    }

    public int[] reArrangeElementsBySignOptimized(int[] arr) {
        int N = arr.length, p = 0, n = 0;
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                while (p < N && arr[p] < 0)
                    p++;
                ans[i] = arr[p++];
            } else {
                while (n < N && arr[n] > 0)
                    n++;
                ans[i] = arr[n++];
            }
        }
        return ans;
    }

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
