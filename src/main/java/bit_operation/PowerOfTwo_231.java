package bit_operation;

/**
 * @author zengjia
 * @date 2021-08-25 11:46:14
 */
public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    /**
     * n & -n 获取最低位的1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & -n) == n;
    }
}
