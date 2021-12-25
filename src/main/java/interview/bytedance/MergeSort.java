package interview.bytedance;

import java.util.Arrays;

/**
 * @author zengjia
 * @date 2021-12-22 15:18:20
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 9, 5, 7};
        new MergeSort().mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    int[] tmp;

    private void mergeSort(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[idx++] = nums[i++];
            } else {
                tmp[idx++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[idx++] = nums[i++];
        }
        while (j <= r) {
            tmp[idx++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; k++) {
            nums[k + l] = tmp[k];
        }
    }
}
