package linked_list;

/**
 * @author zengjia
 * @date 2021-05-15 19:38:09
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0);
        ListNode res = resHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            res.next = new ListNode(sum);
            res = res.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            res.next = new ListNode(carry);
        }

        return resHead.next;
    }
}
