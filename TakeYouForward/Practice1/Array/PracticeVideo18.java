public class PracticeVideo18 {

    // Video Link :
    // https://www.youtube.com/watch?v=bR7mQgwQ_o8&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=18

    public static void main(String[] args) {
        new PracticeVideo18();
    }

    PracticeVideo18() {
        int size = 5;
        System.out.println("\nPascal Triangle Brut");
        printPascalTriangleBrut(size);

        System.out.println("\nPascal Triangle Efficient");
        printPascalTriangleEfficient(size);
    }

    public void printPascalTriangleBrut(int n) {

        for (int i = 0; i <= n; i++) {
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print(" ==> " + nCr(i, j));
            }
        }

    }

    public void printPascalTriangleEfficient(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print(" ==> " + nCrEfficient(i, j));
            }
        }

    }

    private int nCr(int n, int r) {
        int sum = 1;
        for (int i = 0; i < r; i++) {
            sum = sum * (n - i) / (i + 1);

        }
        return sum;
    }

    private int nCrEfficient(int n, int r) {
        int sum = 1;
        if (r == 0 || r == n)
            return sum;
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - i + 1) / i;
        }
        return sum;
    }
}
