import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeVideo22 {
    // Video Link :
    // https://www.youtube.com/watch?v=eZr-6p0B7ME&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=22

    int[] arr = { 4, 2, 2, 6, 4 };
    int k = 6;

    public static void main(String[] args) {
        new PracticeVideo22();
    }

    PracticeVideo22() {
        System.out.println("Find XoR to K list Brut: " + findXorToList(arr, k));
        System.out.println("Find XoR to K list Optimized: " + findXorToListOptimized(arr, k));
    }

    public int findXorToList(int[] arr, int k) {
        int result = 0, XoR = 0, N = arr.length;
        for (int i = 0; i < N; i++) {

            XoR = 0;
            for (int j = i; j < N; j++) {
                XoR ^= arr[j];

                if (XoR == k)
                    result++;
            }
        }
        return result;
    }

    public int findXorToListOptimized(int[] arr, int k) {
        int result = 0, XoR = 0, N = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < N; i++) {
            XoR = XoR ^ arr[i];
            int remain = k ^ XoR;
            if (map.containsKey(remain))
                result += map.get(remain);
            if (map.containsKey(XoR))
                map.put(XoR, map.get(XoR) + 1);
            else
                map.put(XoR, 1);

        }
        return result;
    }

}
