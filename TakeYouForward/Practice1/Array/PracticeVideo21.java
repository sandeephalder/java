import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PracticeVideo21 {
    // Video Link:
    // https://www.youtube.com/watch?v=eD95WRfh81c&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=21

    int[] arr = { 1, 0, -1, 0, 2, -2 };

    public static void main(String[] args) {
        new PracticeVideo21();
    }

    PracticeVideo21() {
        System.out.println("Print 4 Sum Brut: " + findQuardtsBrut(arr));
        System.out.println("Print 4 Sum HashMap: " + findQuardtsHash(arr));
        System.out.println("Print 4 Sum Efficient: " + findQuardtsEfficient(arr));
    }

    public Set<List<Integer>> findQuardtsBrut(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (i == j || j == k || i == k || k == l || j == l || i == l)
                            continue;
                        if (arr[i] + arr[j] + arr[k] + arr[l] == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(arr[k]);
                            list.add(arr[l]);
                            Collections.sort(list);
                            result.add(list);
                        }
                    }

                }
            }
        }
        return result;
    }

    public Set<List<Integer>> findQuardtsHash(int arr[]) {
        Set<List<Integer>> result = new HashSet<>();
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                if (j < N - 1)
                    map.put(arr[j + 1], j + 1);
                for (int k = j + 1; k < N; k++) {
                    int key = 0 - arr[i] - arr[j] - arr[k];
                    if (map.containsKey(key)) {
                        int l = map.get(key);
                        if (i == j || j == k || i == k || k == l || j == l || i == l)
                            continue;
                        if (arr[i] + arr[j] + arr[k] + arr[l] == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(arr[k]);
                            list.add(arr[l]);
                            Collections.sort(list);
                            result.add(list);
                        }
                    }
                    map.put(arr[k], k);

                }
            }
        }
        return result;
    }

    public Set<List<Integer>> findQuardtsEfficient(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(arr);
        int N = arr.length - 1, l = N, k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                l = N;

                k = j + 1;

                while (k < l)

                {
                    if (arr[i] + arr[j] + arr[k] + arr[l] > 0) {
                        l--;
                    } else if (arr[i] + arr[j] + arr[k] + arr[l] < 0) {
                        k++;
                    } else {
                        if (i == j || j == k || i == k || k == l || j == l || i == l)
                            continue;
                        if (arr[i] + arr[j] + arr[k] + arr[l] == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(arr[k]);
                            list.add(arr[l]);
                            Collections.sort(list);
                            result.add(list);
                        }
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
