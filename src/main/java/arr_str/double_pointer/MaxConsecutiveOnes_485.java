package arr_str.double_pointer;

/**
 * @author zengjia
 * @date 2021-04-07 10:51:12
 */
public class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int num : nums) {
            if (num == 0) {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
            } else {
                temp++;
            }
        }
        return Math.max(max, temp);
    }
}
