package arr_str.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zengjia
 * @date 2021-07-15 21:30:14
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) {
                return res;
            }
            // 去重，需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                int sum = a + b + c;
                if (sum == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(a);
                    item.add(b);
                    item.add(c);
                    res.add(item);
                    // 去重
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    // 去重
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ThreeSum_15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
