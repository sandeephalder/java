package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Video:  https://www.youtube.com/watch?v=UXDSeD9mN-k&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=5
public class PracticeVideo5 {
    int[] arr = { 0, 2, 6, 5, 8, 11 };

    public static void main(String[] args) {
        new PracticeVideo5();
    }

    PracticeVideo5() {
        int target = 11;
        System.out.println("TwoSum  sum by Hash Map: " + findTwoSumHashMap(arr, target));
        System.out.println(
                "Two Sum  by Two Pointer: " + findTwoSumTwoPointer(arr, target));
    }

    public boolean findTwoSumHashMap(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
            map.put(arr[i], i);

            if (map.containsKey(target - arr[i]))
                return true;

        }
        return result;
    }

    public boolean findTwoSumTwoPointer(int[] arr, int target) {
        int l = 0, r = arr.length - 1, sum = 0, len = arr.length;
        Arrays.sort(arr);
        while (l < r) {
            sum = arr[l] + arr[r];
            if (sum < target)
                l++;
            else if (sum > target)
                r--;
            else
                return true;
        }

        return false;
    }
}
