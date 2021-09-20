package week;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zengjia
 * @date 2021-09-19 10:26:23
 */
public class Week259 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.contains("++")) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }

    public int sumOfBeauties(int[] nums) {
        int res = 0;
        int leftMax = Integer.MIN_VALUE;
        Deque<Integer> minStack = new LinkedList<>();
        for (int i = nums.length - 1; i > 1; i--) {
            int min = minStack.isEmpty() ? nums[i] : Math.min(minStack.peek(), nums[i]);
            minStack.push(min);
        }
        for (int i = 1; i <= nums.length - 2; i++) {
            leftMax = Math.max(leftMax, nums[i - 1]);
            Integer rightMin = minStack.pop();
            if (nums[i] > leftMax && nums[i] < rightMin) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Week259 week259 = new Week259();
        int i = week259.sumOfBeauties(new int[]{2, 4, 3, 2});
        System.out.println(i);
    }
}
