package linked_list.double_point;

import linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zengjia
 * @date 2021-04-22 16:19:10
 */
public class LinkedListCycle_141 {
    /**
     * 快慢指针解法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        return true;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 哈希表解法
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
