package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zengjia
 * @date 2021-08-14 18:11:38
 */
public class MaximumDepthOfBinaryTree_104 {
    /**
     * bfs
     *
     * @param root
     * @return
     */
    public int maxDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return maxDepth;
    }

    int maxDepth = 1;

    /**
     * 自己写的dfs
     *
     * @param root
     * @return
     */
    public int maxDepth_dfs1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        maxDepth = Math.max(maxDepth, level);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    /**
     * dfs（别人写的是多么的优美，woc！）
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
