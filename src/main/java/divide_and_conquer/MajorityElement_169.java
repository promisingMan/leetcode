package divide_and_conquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zengjia
 * @date 2021-08-08 11:16:00
 */
public class MajorityElement_169 {
    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int majorCount = nums.length / 2;
        for (int i : nums) {
            int count = 0;
            for (int j : nums) {
                if (i == j) {
                    count++;
                    if (count > majorCount) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 哈希表计数
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int majorCount = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>(majorCount);
        for (int i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : count + 1;
            if (count > majorCount) {
                return i;
            }
            map.put(i, count);
        }
        return 0;
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 分治
     *
     * @param nums
     * @return
     */
    public int majorityElement4(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int l, int h) {
        if (l == h) {
            return nums[l];
        }

        int mid = (h - l) / 2 + l;
        int leftMajor = divideAndConquer(nums, l, mid);
        int rightMajor = divideAndConquer(nums, mid + 1, h);

        if (leftMajor == rightMajor) {
            return leftMajor;
        }

        int leftCount = countInRange(nums, leftMajor, l, h);
        int rightCount = countInRange(nums, rightMajor, l, h);

        return leftCount > rightCount ? leftMajor : rightMajor;
    }

    private int countInRange(int[] nums, int num, int l, int h) {
        int count = 0;
        for (int i = l; i <= h; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * Boyer-Moore 投票算法
     *
     * @param nums
     * @return
     */
    public int majorityElement5(int[] nums) {
        int count = 1, candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == candidate) {
                count++;
            } else if (--count == 0) {
                candidate = num;
                count = 1;
            }
        }
        return candidate;
    }
}
