package arr_str.double_pointer;

import java.util.Arrays;

/**
 * @author zengjia
 * @date 2021-04-10 11:24:15
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new MoveZeroes_283().moveZeroes(new int[]{0,1,0,3,12});
    }
}
