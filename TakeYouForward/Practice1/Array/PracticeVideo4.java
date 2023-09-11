package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Video 4: https://www.youtube.com/watch?v=frf7qxiN2qU&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=4

public class PracticeVideo4 {
    int[] arr = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };

    public static void main(String[] args) {
        new PracticeVideo4();
    }

    PracticeVideo4() {
        int target = 10;
        System.out.println("Longest subarray with sum by Hash Map: " + longestSubarrayWithSumByHashMap(arr, target));
        System.out.println(
                "Longest subarray with sum by Two Pointer: " + longestSubarrayWithSumByTwoPointer(arr, target));
    }

    private int longestSubarrayWithSumByHashMap(int arr[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, result = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == target)
                result = Math.max(result, i + 1);
            int rem = sum - target;
            if (map.containsKey(rem))
                result = Math.max(result, i - map.get(rem));
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return result;
    }

    private int longestSubarrayWithSumByTwoPointer(int arr[], int target) {
        int result = 0, l = 0, r = 0, sum = 0;
        for (; r < arr.length;) {
            sum += arr[r++];
            while (sum > target && r <= l) {
                sum -= arr[l++];
            }

            if (sum == target)
                result = Math.max(result, r - l);

        }
        return result;
    }

}
