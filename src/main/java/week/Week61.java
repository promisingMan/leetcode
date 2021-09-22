package week;

import java.util.*;

/**
 * @author zengjia
 * @date 2021-09-18 22:40:09
 */
public class Week61 {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[]{};
        }
        Arrays.sort(changed);
        Queue<Integer> q = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int num : changed) {
            if (!q.isEmpty() && q.peek() == num) {
                q.poll();
            } else {
                tmp.add(num);
                q.offer(num * 2);
            }
        }
        if (q.isEmpty()) {
            int[] res = new int[tmp.size()];
            for (int i = 0; i < tmp.size(); i++) {
                res[i] = tmp.get(i);
            }
            return res;
        }
        return new int[]{};
    }

    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return s.charAt(0);
    }

    public static void main(String[] args) {
        Week61 week61 = new Week61();
        week61.search(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
