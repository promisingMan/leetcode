package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zengjia
 * @date 2021-08-14 18:11:38
 */
public class MinimumDepthOfBinaryTree_111 {
    public int minDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return minDepth;
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // left + right + 1 多么的巧妙，省了两个if判断
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
