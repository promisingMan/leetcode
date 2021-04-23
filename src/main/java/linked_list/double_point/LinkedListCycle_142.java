package linked_list.double_point;

import linked_list.ListNode;

/**
 * @author zengjia
 * @date 2021-04-22 16:19:10
 */
public class LinkedListCycle_142 {
    /**
     * 快慢指针解法
     * 设链表有a+b个节点，a表示从链表头部到环入口（不计入）的节点个数，b表示环的节点个数
     * 设fast每次走两步，slow每次走一步，则有 f = 2s
     * fast 比 slow多走了 n 个环的长度，即 f = s + nb
     * 两式可得 f = 2nb, s = nb
     * 如果让指针从链表头部一直向前走并统计步数k，那么所有 走到环入口节点时的步数 是：k=a+nb（先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点）。
     * 而目前，slow 指针走过的步数为 nb 步。因此，我们只要想办法让 slow 再走 a 步停下来，就可以到环的入口。
     * 但是我们不知道 a 的值，该怎么办？依然是使用双指针法。我们构建一个指针，此指针需要有以下性质：此指针和slow 一起向前走 a 步后，两者在入口节点重合。那么从哪里走到入口节点需要 a 步？答案是链表头部head。
     * <p>
     * 题解：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
