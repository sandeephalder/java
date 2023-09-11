import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeVideo24 {
    public static void main(String[] args) {
        new PracticeVideo24();
    }

    int[] f = { 1, 1, 3, 5, 7, 11 };
    int[] s = { 0, 2, 2, 6, 8, 9, 15, 16 };

    PracticeVideo24() {
        System.out.println(" Merge 2 sorted arrays 1st Approach : " + mergeTwoArraysFirst(f, s));
        // System.out.println(" Merge 2 sorted arrays 2nd Approach : " +
        // mergeTwoArraysSecond(f, s));
    }

    public List<Integer> mergeTwoArraysFirst(int[] f, int[] s) {
        List<Integer> result = new ArrayList();
        int fn = f.length - 1, sn = s.length - 1, j = 0;
        if (fn < sn)
            for (int i = fn; i >= 0; i--) {
                if (f[i] > s[j])
                    swap(f, s, i, j++);
            }
        else
            for (int i = sn; i >= 0; i--) {
                if (f[i] > s[j])
                    swap(s, f, i, j++);
            }
        Arrays.sort(f);
        Arrays.sort(s);
        for (int i : f)
            result.add(i);
        for (int i : s)
            result.add(i);
        return result;
    }

    public List<Integer> mergeTwoArraysSecond(int[] f, int[] s) {
        List<Integer> result = new ArrayList();

        return result;
    }

    private void swap(int[] a, int[] b, int src, int dest) {
        int temp = a[src];
        a[src] = b[dest];
        b[dest] = temp;
    }

}
