package Array;

import java.util.Arrays;

public class PracticeVideo14 {
    int[][] arr1 = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 0, 0, 1 } };
    int[][] arr2 = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 0, 0, 1 } };
    int[][] arr3 = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 0, 0, 1 } };

    // Video URL:
    // https://www.youtube.com/watch?v=N0MgLvceX7M&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=14
    public static void main(String[] args) {
        new PracticeVideo14();
    }

    PracticeVideo14() {
        printMetrics(arr1);

        System.out.println("Set Metrics to Zero Brutforce: ");
        setMetricsToZeroBruteForce(arr1);
        printMetrics(arr1);

        System.out.println("Set Metrics to Zero Semi Efficient: ");
        setMetricsToZeroSemiEfficient(arr2);
        printMetrics(arr2);

        System.out.println("Set Metrics to Zero Full Efficient: ");
        setMetricsToZeroSemiEfficient(arr2);
        printMetrics(arr2);

    }

    public void setMetricsToZeroFullEfficient(int[][] arr) {
        int M = arr.length, N = arr[0].length, corner = arr[0][0];

    }

    public void setMetricsToZeroSemiEfficient(int[][] arr) {
        int M = arr.length, N = arr[0].length;
        int[] row = new int[M];
        int[] column = new int[M];
        Arrays.fill(row, 1);
        Arrays.fill(column, 1);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 0;
                    column[j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++)
            if (row[i] == 0)
                for (int j = 0; j < N; j++)
                    arr[i][j] = 0;

        for (int i = 0; i < N; i++)
            if (column[i] == 0)
                for (int j = 0; j < M; j++)
                    arr[j][i] = 0;

    }

    public void setMetricsToZeroBruteForce(int[][] arr) {
        int M = arr.length, N = arr[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    for (int ii = 0; ii < M; ii++)
                        if (arr[ii][j] == 1)
                            arr[ii][j] = 2;
                    for (int jj = 0; jj < N; jj++)
                        if (arr[i][jj] == 1)
                            arr[i][jj] = 2;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 2)
                    arr[i][j] = 0;
            }
        }
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
