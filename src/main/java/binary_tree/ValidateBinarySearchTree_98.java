package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengjia
 * @date 2021-07-19 21:42:54
 */
public class ValidateBinarySearchTree_98 {
    // 中序遍历判断是否有序
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }


    // 中序遍历，记录前一个数字，优化空间复杂度
    long pre = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 短路运算，左子树已不符合条件，直接返回false
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST2(root.right);
    }


    // 最大值最小值
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
