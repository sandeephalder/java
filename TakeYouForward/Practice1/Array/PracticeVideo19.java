import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeVideo19 {

    // Video URL:
    // https://www.youtube.com/watch?v=vwZj1K0e9U8&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=19

    int arr[] = { 1, 1, 1, 3, 3, 3, 3, 2, 2, 2, 2 };

    public static void main(String[] args) {
        new PracticeVideo19();
    }

    PracticeVideo19() {
        System.out.println("\nPrint Majority Element by Hash: " + printMajorityElementByHash(arr));
        System.out.println("\nPrint Majority Element by Sort: " + printMajorityElementBySort(arr));
        System.out.println("\nPrint Majority Element by Efficient: " + printMajorityElementByEffiecient(arr));
    }

    public List<Integer> printMajorityElementByHash(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int N = arr.length, threshold = N / 3;
        for (int i : arr) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        for (int i : map.keySet())
            if (map.get(i) > threshold)
                result.add(i);
        return result;
    }

    public List<Integer> printMajorityElementBySort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int N = arr.length, count = 1, threshold = N / 3;
        int[] arra1 = Arrays.copyOf(arr, N);
        Arrays.sort(arra1);
        for (int i = 1; i < N; i++) {
            if (arra1[i - 1] == arra1[i]) {
                if (++count > threshold)
                    result.add(arra1[i]);
            } else
                count = 1;

        }
        return result;
    }

    public List<Integer> printMajorityElementByEffiecient(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int th1 = 0, th2 = 0, thi1 = 0, thi2 = 0, N = arr.length, threshold = N / 3;
        for (int i = 0; i < N; i++) {
            if (thi1 == 0 && arr[i] != th2) {
                th1 = arr[i];
                thi1 = 1;
            } else if (thi2 == 0 && arr[i] != th1) {
                th2 = arr[i];
                thi2 = 1;
            } else if (arr[i] == th1) {
                thi1++;
            } else if (arr[i] == th2)
                thi2++;
            else {
                thi1--;
                thi2--;
            }
        }
        thi1 = 0;
        thi2 = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == th1)
                thi1++;
            if (arr[i] == th2)
                thi2++;

        }
        if (thi1 > threshold)
            result.add(th1);
        if (thi2 > threshold)
            result.add(th2);
        return result;
    }

}
