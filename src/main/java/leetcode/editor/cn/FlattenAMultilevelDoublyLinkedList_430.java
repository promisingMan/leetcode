package leetcode.editor.cn;

//多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生
//成多级数据结构，如下面的示例所示。 
//
// 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//输出：[1,2,3,7,8,11,12,9,10,4,5,6]
//解释：
//
//输入的多级列表如下图所示：
//
//
//
//扁平化后的链表如下图：
//
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2,null,3]
//输出：[1,3,2]
//解释：
//
//输入的多级列表如下图所示：
//
//  1---2---NULL
//  |
//  3---NULL
// 
//
// 示例 3： 
//
// 输入：head = []
//输出：[]
// 
//
// 
//
// 如何表示测试用例中的多级链表？ 
//
// 以 示例 1 为例： 
//
//  1---2---3---4---5---6--NULL
//         |
//         7---8---9---10--NULL
//             |
//             11--12--NULL 
//
// 序列化其中的每一级之后： 
//
// [1,2,3,4,5,6,null]
//[7,8,9,10,null]
//[11,12,null]
// 
//
// 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。 
//
// [1,2,3,4,5,6,null]
//[null,null,7,8,9,10,null]
//[null,11,12,null]
// 
//
// 合并所有序列化结果，并去除末尾的 null 。 
//
// [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12] 
//
// 
//
// 提示： 
//
// 
// 节点数目不超过 1000 
// 1 <= Node.val <= 10^5 
// 
// Related Topics 深度优先搜索 链表 双向链表 👍 245 👎 0


public class FlattenAMultilevelDoublyLinkedList_430 {

    public static void main(String[] args) {
        Solution solution = new FlattenAMultilevelDoublyLinkedList_430().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    */

    class Solution {
        public Node flatten(Node head) {
            Node p = head;
            while (p != null) {
                if (p.child != null) {
                    Node next = p.next;
                    Node child = p.child;
                    p.next = child;
                    p.child = null;
                    child.prev = p;
                    while (child.next != null) {
                        child = child.next;
                    }
                    child.next = next;
                    if (next != null) {
                        next.prev = child;
                    }
                }
                p = p.next;
            }
            return head;
        }

        public Node flatten_dfs(Node head) {
            dfs(head);
            return head;
        }

        private Node dfs(Node node) {
            Node cur = node, last = null;
            while (cur != null) {
                Node next = cur.next;
                if (cur.child != null) {
                    Node childLast = dfs(cur.child);

                    cur.next = cur.child;
                    cur.child.prev = cur;

                    if (next != null) {
                        childLast.next = next;
                        next.prev = childLast;
                    }

                    cur.child = null;
                    last = childLast;
                } else {
                    last = cur;
                }
                cur = next;
            }
            return last;
        }

        class Node {
            public int val;
            public Node prev;
            public Node next;
            public Node child;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}