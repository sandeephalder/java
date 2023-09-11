import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PracticeVideo20 {

    // Video Link:
    // https://www.youtube.com/watch?v=DhFh8Kw7ymk&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=20

    int[] arr = { -1, 0, 1, 2, -1, -4 };

    public static void main(String[] args) {
        new PracticeVideo20();
    }

    PracticeVideo20() {
        System.out.println("Print 3 Sum Brut: " + findTripletsBrut(arr));
        System.out.println("Print 3 Sum HashMap: " + findTripletsHash(arr));
        System.out.println("Print 3 Sum Efficient: " + findTripletsEfficient(arr));
    }

    public Set<List<Integer>> findTripletsBrut(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (i == j || j == k || i == k)
                        continue;
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(arr[i]);
                        l.add(arr[j]);
                        l.add(arr[k]);
                        Collections.sort(l);
                        result.add(l);
                    }
                }
            }
        }
        return result;
    }

    public Set<List<Integer>> findTripletsHash(int arr[]) {
        Set<List<Integer>> result = new HashSet<>();
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < N; j++) {
                map.put(arr[j], j);
                int key = 0 - arr[i] - arr[j];
                if (map.containsKey(key)) {
                    int k = map.get(key);
                    if (i == j || j == k || i == k)
                        continue;
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(arr[i]);
                        l.add(arr[j]);
                        l.add(arr[k]);
                        Collections.sort(l);
                        result.add(l);
                    }
                }

            }
        }
        return result;
    }

    public Set<List<Integer>> findTripletsEfficient(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(arr);
        int N = arr.length - 1, k = N, j = 0;
        for (int i = 0; i < N; i++) {
            k = N;
            j = i + 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] > 0) {
                    k--;
                } else if (arr[i] + arr[j] + arr[k] < 0) {
                    j++;
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(arr[i]);
                    l.add(arr[j]);
                    l.add(arr[k]);
                    Collections.sort(l);
                    result.add(l);
                    j++;
                }
            }
        }
        return result;
    }
}
