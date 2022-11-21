package interview.ali;

public class CycleArray {
    public static void main(String[] args) {
        int[] search = new CycleArray().search(new int[]{1, 2, 3, 4, 3});
        for (int i : search) {
            System.out.println(i);
        }
        System.out.println(search);
    }

    //给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
    //
    //
    //数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。 
    //
    //
    //示例 1:
    //输入: nums = [1,2,1]
    //输出: [2,-1,2]
    //解释: 第一个 1 的下一个更大的数是 2；
    //数字 2 找不到下一个更大的数； 
    //第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
    //示例 2:
    //
    //
    //输入: nums = [1,2,3,4,3]
    //输出: [2,3,4,-1,4]
    public int[] search(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }

        // 结果数组
        int[] res = new int[len];

        // 遍历每一个元素
        for (int i = 0; i < len; i++) {
            // (i + 1) % len 循环处理
            // j != i 表示遍历整个数组都没找到比本身大的
            boolean found = false;
            for (int j = (i + 1) % len; j != i; j = (j + 1) % len) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    found = true;
                    break;
                }
            }
            if (!found) {
                res[i] = -1;
            }
        }

        return res;
    }
}
