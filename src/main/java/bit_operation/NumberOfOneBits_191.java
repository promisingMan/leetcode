package bit_operation;

/**
 * @author zengjia
 * @date 2021-08-25 11:03:26
 */
public class NumberOfOneBits_191 {
    /**
     * 余2+右移
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    /**
     * 检查每一位是否为1
     *
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 消除最低位的1
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
