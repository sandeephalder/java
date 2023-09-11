package Array;

public class PracticeVideo8 {
    // Video Link:
    // https://www.youtube.com/watch?v=AHZpyENo7k4&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=8

    int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 }; // 7

    public static void main(String[] args) {
        new PracticeVideo8();
    }

    PracticeVideo8() {
        System.out.println("Max Subarray Sum" + findMaxSubarraySum(arr));
    }

    private int findMaxSubarraySum(int[] arr) {
        int sum = 0, l = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0)
                sum = 0;
            if (sum > max)
                max = sum;
        }
        return max;
    }

}
