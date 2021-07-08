package binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zengjia
 * @date 2021-06-13 22:28:43
 */
public class SerializeAndDeserializeBinaryTree_297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] list = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(list[i])) {
                node.left = new TreeNode(Integer.parseInt(list[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(list[i])) {
                node.right = new TreeNode(Integer.parseInt(list[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize2(root.left) + "," + serialize2(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}
