package arr_str;

/**
 * @author zengjia
 * @date 2021-03-31 23:22:57
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] >= target ? l : l + 1;
    }
}
