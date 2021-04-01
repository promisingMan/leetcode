package linked_list;

/**
 * @author zengjia
 * @date 2021-04-01 09:42:33
 */
public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        // ListNode pre = new ListNode(0);
        // pre.next = head;
        // ListNode temp = pre;
        // while(temp.next != null && temp.next.next != null) {
        //     ListNode node1 = temp.next;
        //     ListNode node2 = temp.next.next;
        //     temp.next = node2;
        //     node1.next = node2.next;
        //     node2.next = node1;
        //     temp = node1;
        // }
        // return pre.next;

        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode newHead = head.next;
        // head.next = swapPairs(newHead.next);
        // newHead.next = head;
        // return newHead;

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
