package bit_operation;

/**
 * 题解：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-duo-chong-jie-jue-fang-p77tu/
 *
 * @author zengjia
 * @date 2021-08-25 11:48:48
 */
public class CountingBits_338 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    public int[] countBits1(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
