package interview.bytedance;

/**
 * @author zengjia
 * @date 2021-12-03 17:44:56
 */
public class Solution {
    int[] encrypt = new int[]{5, 3, 2, 1, 4};

    public int[] encode(int[] arr) {
        if (arr == null) {
            return new int[]{};
        }
        int len = arr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (arr[i] < 1 || arr[i] > 5) {
                throw new RuntimeException("字符不合法");
            }
            res[i] = encrypt[arr[i] - 1];
        }
        return res;
    }

    public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int l1 = arr1.length, l2 = arr2.length;
        int target = (l1 + l2) / 2;
        int i = 0, j = 0, k = 0, temp;
        while (i < l1 && j < l2) {
            if (arr1[i] <= arr2[j]) {
                temp = arr1[i++];
            } else {
                temp = arr2[j++];
            }
            if (++k == target) {
                return temp;
            }
        }
        while (i < l1) {
            temp = arr1[i++];
            if (++k == target) {
                return temp;
            }
        }
        while (j < l2) {
            temp = arr2[j++];
            if (++k == target) {
                return temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMedianinTwoSortedAray(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6});
    }
}
