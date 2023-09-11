package Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PracticeVideo10 {

    // Video Link:
    // https://www.youtube.com/watch?v=excAOvwF_Wk&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=10

    int[] stock = { 1, 12, 5, 3, 1, 4, 1 };

    public static void main(String[] args) {
        new PracticeVideo10();
    }

    PracticeVideo10() {
        System.out.println("Best time to buy stock:"
                + bestTimeToBuySeeStock(stock));
    }

    private int bestTimeToBuySeeStock(int[] arr) {
        int N = arr.length - 1, cost = N, maxProfit = 0, min = arr[0];

        for (int i = 0; i < N; i++) {
            cost = arr[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, arr[i]);
        }

        return maxProfit;
    }

}
