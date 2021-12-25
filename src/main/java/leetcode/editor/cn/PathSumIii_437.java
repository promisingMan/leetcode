package leetcode.editor.cn;

//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1021 👎 0


import java.util.HashMap;
import java.util.Map;

public class PathSumIii_437 {

    public static void main(String[] args) {
        Solution solution = new PathSumIii_437().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = rootSum(root, targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return ret;
        }

        private int rootSum(TreeNode root, int targetSum) {
            int ret = 0;
            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }
            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
        }

        public int pathSum_prefixSum(TreeNode root, int targetSum) {
            Map<Integer, Integer> prefix = new HashMap<>();
            // 表示自身节点就是targetSum
            prefix.put(0, 1);
            return dfs(root, prefix, 0, targetSum);
        }

        private int dfs(TreeNode root, Map<Integer, Integer> prefix, int cur, int targetSum) {
            if (root == null) {
                return 0;
            }
            cur += root.val;
            int ret = prefix.getOrDefault(cur - targetSum, 0);
            prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
            ret += dfs(root.left, prefix, cur, targetSum);
            ret += dfs(root.right, prefix, cur, targetSum);
            prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
            return ret;
        }

        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}