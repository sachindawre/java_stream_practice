package dsa.accolite;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(6));
    }

    /// 0 1 1 2 3 5 8

    private static int fact(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int sum = fact(n-1) + fact(n-2);
        return sum;
    }

    /*private static int fact_1(int n) {

    }*/

}
