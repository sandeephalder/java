package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PracticeVideo13 {

    // Video
    // URL:https://www.youtube.com/watch?v=oO5uLE7EUlM&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=13

    int[] arr1 = { 102, 4, 100, 1, 101, 3, 2, 1, 1, 5 };
    int[] arr2 = { 102, 4, 100, 1, 101, 3, 2, 1, 1, 5 };

    public static void main(String[] args) {
        new PracticeVideo13();
    }

    PracticeVideo13() {
        System.out
                .println("Longest Consecutive Sequence by sorting Sort Method: "
                        + findLongestConsecutiveSubsequenceBySorting(arr1));
        System.out.println(
                "Longest Consecutive Sequence by sorting Optimal: " + findLongestConsecutiveSubsequenceOptimal(arr2));
    }

    public int findLongestConsecutiveSubsequenceBySorting(int[] arr) {
        int max = 0, N = arr.length, count = 0;
        Arrays.sort(arr);
        Arrays.stream(arr).boxed().map(a -> a + " ==> ").forEach(System.out::print);
        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[i - 1] == 1)
                count++;
            else
                count = 0;
            if (count > max) {
                max = count;
            }

        }
        return max + 1;
    }

    public int findLongestConsecutiveSubsequenceOptimal(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0, max = 0;
        for (int i : arr)
            set.add(i);
        for (int j : set) {
            Integer min = j;
            while (set.contains(min--))
                count++;
            if (max < count)
                max = count;
            count = 0;
        }
        return max;
    }

}
