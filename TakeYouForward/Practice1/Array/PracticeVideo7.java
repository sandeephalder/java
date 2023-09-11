package Array;

import java.util.Map;
import java.util.HashMap;

public class PracticeVideo7 {

    // Video Link
    // https://www.youtube.com/watch?v=nP_ns3uSh80&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=7

    private static final int HashMap = 0;
    int arr[] = { 7, 7, 5, 7, 5, 1, 7, 5, 5, 7, 7, 7 };

    public static void main(String[] args) {
        new PracticeVideo7();
    }

    PracticeVideo7() {
        System.out.println("Find Majority Elements : " + findMajorityElementsByHash(arr));
        System.out.println("Find Majority Elements : " + findMajorityElements(arr));
    }

    private int findMajorityElements(int arr[]) {
        int result = -1, prev = arr[0], sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > prev)
                sum++;
            else if (arr[i] < prev)
                sum--;
            if (sum == 0) {
                prev = arr[i];
            }
        }

        if (sum != 0) {
            sum = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == arr[arr.length - 1])
                    sum++;
            if (sum > arr.length / 2)
                return arr[arr.length - 1];
        }
        return result;
    }

    private int findMajorityElementsByHash(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);

        for (int key : map.keySet())
            if (map.get(key) > arr.length / 2)
                return key;

        return -1;
    }
}
