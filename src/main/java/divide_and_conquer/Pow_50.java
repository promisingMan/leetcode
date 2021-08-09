package divide_and_conquer;

/**
 * @author zengjia
 * @date 2021-07-21 20:16:10
 */
public class Pow_50 {
    public double myPow2(double x, int n) {
        double res = 1;
        int abs = Math.abs(n);
        while (abs != 0) {
            res *= x;
            abs--;
        }
        return n > 0 ? res : 1 / res;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        double v = new Pow_50().myPow(2.0, -2);
        System.out.println(v);
    }
}
