package binary_tree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zengjia
 * @date 2021-05-30 22:26:15
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int iLen = inorder.length;
        int pLen = postorder.length;
        if (iLen == 0 || pLen == 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pLen - 1]);
        for (int i = 0; i < iLen; i++) {
            if (inorder[i] == postorder[pLen - 1]) {
                int rSize = iLen - 1 - i;
                node.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, pLen - 1 - rSize));
                node.right = buildTree(Arrays.copyOfRange(inorder, i + 1, iLen), Arrays.copyOfRange(postorder, pLen - 1 - rSize, pLen - 1));
            }
        }
        return node;
    }

    HashMap<Integer, Integer> inorderMemoMap = new HashMap<>();
    int[] post;
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMemoMap.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    private TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postOrderEnd) {
        if (inorderEnd < inorderStart || postOrderEnd < postorderStart) {
            return null;
        }

        // 获取根节点在后序遍历中的值
        int rootVal = post[postOrderEnd];
        // 获取根节点在中序遍历中的位置
        int rootIndexInInorder = inorderMemoMap.get(rootVal);

        TreeNode node = new TreeNode(rootVal);
        // 右子树节点数量
        int rSize = inorderEnd - rootIndexInInorder;
        node.left = buildTree(inorderStart, rootIndexInInorder - 1, postorderStart, postOrderEnd - rSize - 1);
        node.right = buildTree(rootIndexInInorder + 1, inorderEnd, postOrderEnd - rSize, postOrderEnd - 1);
        return node;
    }
}
