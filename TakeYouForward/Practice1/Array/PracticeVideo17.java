package Array;

import java.util.HashMap;
import java.util.Map;

public class PracticeVideo17 {
    // Video URL:
    // https://www.youtube.com/watch?v=xvNwoz-ufXA&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=17
    int[] arr = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
    int k = 3;

    public static void main(String[] args) {
        new PracticeVideo17();
    }

    PracticeVideo17() {
        System.out.println("Count Subarray with sum K with Brut : " + countTotalSubarraySumBrut(arr, k));
        System.out.println("Count Subarray with sum K with Efficientt :" + countTotalSubarraySumEfficient(arr, k));
    }

    public int countTotalSubarraySumBrut(int[] arr, int k) {
        return 0;
    }

    public int countTotalSubarraySumEfficient(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, N = arr.length, max = 0;
        map.put(0, 1);
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            int remain = sum - k;
            if (map.containsKey(remain))
                max += map.get(remain);

            if (map.containsKey(sum))
                map.put(sum, map.get(sum) + 1);
            else
                map.put(sum, 1);
        }
        System.out.println(" Hash Map " + map);
        return max;
    }
}
