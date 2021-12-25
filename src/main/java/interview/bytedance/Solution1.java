package interview.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zengjia
 * @date 2021-11-25 21:15:14
 */
public class Solution1 {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        Solution1 a = new Solution1();
        int[] counts1 = a.getCounts(new int[]{5, 2, 6, 1});
        a.getCounts2(new int[]{-1, -1});
        System.out.println(Arrays.toString(counts1));
    }

    public int[] getCounts(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }
        int[] counts = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            counts[i] = count;
        }
        return counts;
    }

    public List<Integer> getCounts2(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        int[] counts = new int[len];
        for (int i = 0; i < len; i++) {

            // 复制从i位置开始的数组
            int[] arr = new int[len - i];
            int index = 0;
            for (int j = i; j < len; j++) {
                arr[index++] = nums[j];
            }

            // 快排的思路，进行一遍partition，返回的位置i即为小于nums[i]的个数
            res.add(partition(arr));
        }
        return res;
    }

    // 以第一个元素为枢纽，设两个指针 i，j, j从后向前找到一个比枢纽小的元素，i从前向后找到一个比枢纽大的元素，然后交换
    // 直到i,j相遇，然后交换枢纽与i位置的值，此时i位置之前的元素就都是比nums[i]小
    public int partition(int[] nums) {
        int pivot = nums[0];
        int i = 0, j = nums.length - 1;

        while (i < j) {
            while (nums[j] > pivot && i < j) {
                j--;
            }
            while (nums[i] < pivot && i < j) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return i;
    }
}
