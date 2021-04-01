package binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengjia
 * @date 2021-04-01 09:12:53
 */
public class FindKClosestElements_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int size = arr.length;
//        int l = 0;
//        int r = size - 1;
//
//        int removeNum = size - k;
//        while (removeNum < 0) {
//            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
//                r--;
//            } else {
//                l++;
//            }
//            removeNum--;
//        }
//
//        List<Integer> res = new ArrayList<>();
//        for (int i = l; i < l + k; i++) {
//            res.add(arr[i]);
//        }
//
//        return res;
        int size = arr.length;

        int left = 0;
        int right = size - k;

        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
