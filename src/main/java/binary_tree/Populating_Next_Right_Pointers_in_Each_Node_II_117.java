package binary_tree;

/**
 * @author zengjia
 * @date 2021-06-08 22:29:40
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    public void dfs(Node node, Node next) {
        if (node != null) {
            node.next = next;

            if (node.right != null) {
                dfs(node.right, getNotNullNext(next));
            }

            if (node.left != null) {
                dfs(node.left, node.right != null ? node.right : getNotNullNext(next));
            }
        }
    }

    public Node getNotNullNext(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }
}