package Array;

import java.util.Arrays;

public class PracticeVideo15 {

    int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
    int[][] arr2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

    public static void main(String[] args) {
        new PracticeVideo15();
    }

    PracticeVideo15() {
        // System.out.println("Rotate Metrics Brutforce");
        // rotateMetricsByNintyBrutforce(arr1);

        System.out.println("Rotate Metrics Efficient");
        rotateMetricsByNintyEfficient(arr2);
        printMetrics(arr2);

    }

    public void rotateMetricsByNintyBrutforce(int[][] arr) {
        int M = arr.length, N = arr.length;
        int[][] temp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                temp[j][N - i - 1] = arr[i][j];
        }
        printMetrics(temp);
    }

    public void rotateMetricsByNintyEfficient(int[][] arr) {
        int M = arr.length, N = arr.length;
        for (int i = 0; i < M; i++) {
            for (int j = i; j < N; j++) {
                // System.out.print(" +==> " + arr[i][j]);
                swap(arr, i, j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j <= (N - 1) / 2; j++) {
                reverse(arr, i, j);
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

    private void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    private void reverse(int[][] arr, int i, int j) {
        int N = arr.length - 1;
        int temp = arr[i][j];
        arr[i][j] = arr[i][N - j];
        arr[i][N - j] = temp;
    }
}
