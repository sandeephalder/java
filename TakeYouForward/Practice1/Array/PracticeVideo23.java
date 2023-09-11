import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeVideo23 {

    int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 12, 18 }, { 16, 18 } };

    class Doubles implements Comparable<Doubles> {

        Integer a, b;

        public Doubles(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public Integer getB() {
            return b;
        }

        public void setB(Integer b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "Doubles [a=" + a + ", b=" + b + "]";
        }

        @Override
        public int compareTo(PracticeVideo23.Doubles o) {
            if (this.a.equals(o.a)) {
                return this.b.compareTo(o.b);
            }

            return this.a.compareTo(o.a);
        }

    }

    public static void main(String[] args) {
        new PracticeVideo23();
    }

    PracticeVideo23() {
        System.out.println(" Overlapping Limits Optimized: " + mergeOverLappingLimits(arr));
    }

    public List<List<Integer>> mergeOverLappingLimits(int[][] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int N = arr.length, lo = 0, hi = 0;
        ;
        Doubles[] doubles = new Doubles[N];
        for (int i = 0; i < N; i++)
            doubles[i] = new Doubles(arr[i][0], arr[i][1]);
        Arrays.sort(doubles);

        for (int i = 0; i < N; i++) {
            lo = doubles[i].a;
            hi = doubles[i].b;
            while (i < N - 1 && doubles[i + 1].a <= hi) {
                i++;
                hi = doubles[i].b;
            }
            List<Integer> list = new ArrayList<>();
            list.add(lo);
            list.add(hi);
            result.add(list);
        }
        return result;
    }
}
