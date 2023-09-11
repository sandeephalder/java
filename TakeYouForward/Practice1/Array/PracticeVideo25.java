import java.util.ArrayList;
import java.util.List;

public class PracticeVideo25 {

    int[] arr = { 4, 3, 6, 2, 1, 1 };

    public static void main(String[] args) {
        new PracticeVideo25();
    }

    PracticeVideo25() {
        System.out.println(" Find the missing and repetative number" + findTheMissingRepetativeNumber(arr));
    }

    public List<Integer> findTheMissingRepetativeNumber(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length, sumn = n * (n + 1) / 2, sumn2 = (n * (n + 1) * (2 * n + 1)) / 6, xpy = 0, xmy = 0,
                x = 0, y = 0, asum = 0, asumn2 = 0;
        for (int i = 0; i < n; i++) {
            asum += arr[i];
            asumn2 += Math.pow(arr[i], 2);
        }
        xmy = asum - sumn;
        xpy = (asumn2 - sumn2) / xmy;
        x = (xmy + xpy) / 2;
        y = (xpy - xmy) / 2;
        result.add(x);
        result.add(y);
        return result;
    }
}
