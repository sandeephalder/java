package Array;

import java.util.List;

public class PracticeVideo3 {

    // Video :
    // https://www.youtube.com/watch?v=bYWLJb3vCWY&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=3

    int[] missing_number = { 1, 2, 3, 5, 6, 7, 8, 9 };
    int[] consicutive_ones = { 0, 0, 0, 1, 0, 1, 1, 1 };
    int[] nonconsicutive_ones = { 1, 1, 2, 3, 3, 4, 4 };

    public static void main(String[] args) {
        new PracticeVideo3();
    }

    PracticeVideo3() {
        System.out.println("Find Missing number Formula " + findMissingNumberinSequenceFormula(missing_number, 9));
        System.out.println("Find Missing number XOR " + findMissingNumberinSequenceXOR(missing_number, 9));
        System.out.println("Consequtive number " + findMaxConsequtiveNumberinSequence(consicutive_ones));
        System.out.println(
                "Consequtive number missing " + findMaxConsequtiveNotInNumberNumberinSequence(nonconsicutive_ones));
    }

    private int findMissingNumberinSequenceFormula(int[] arr, int n) {
        int result = 0, total = (n * (n + 1)) / 2;
        for (int a : arr)
            result += a;

        return total - result;
    }

    private int findMissingNumberinSequenceXOR(int[] arr, int n) {
        int result = 1, total = 1;
        ;
        for (int a : arr)
            result ^= a;
        for (int i = 1; i <= n; i++)
            total ^= i;
        return result ^ total;
    }

    private int findMaxConsequtiveNumberinSequence(int[] arr) {
        int max = 0, count = 0;
        for (int a : arr) {
            if (a == 1)
                count++;
            if (count > max)
                max = count;
            if (a == 0) {
                count = 0;
            }
        }
        return max;
    }

    private int findMaxConsequtiveNotInNumberNumberinSequence(int[] arr) {
        int result = 0;
        for (int a : arr)
            result ^= a;
        return result;
    }
}
