package arr_str.double_pointer;

/**
 * @author zengjia
 * @date 2021-04-07 09:47:13
 */
public class RemoveElement_27 {
    /**
     * 假设数组总共有 n 个元素，i 和 j 至少遍历 2n 步
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 当我们遇到 nums[i] = val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。这实际上使数组的大小减少了 1。
     * 请注意，被交换的最后一个元素可能是您想要移除的值。但是不要担心，在下一次迭代中，我们仍然会检查这个元素。
     * i 和 n 最多遍历 n 步
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement_27 removeElement_27 = new RemoveElement_27();
        removeElement_27.removeElement2(new int[]{3, 2, 2, 3}, 3);
    }
}
