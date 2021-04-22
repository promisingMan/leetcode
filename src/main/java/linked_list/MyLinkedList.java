package linked_list;

class MyLinkedList {
    ListNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode cur = head;
        while (index > 0 && cur != null) {
            cur = cur.next;
            index--;
        }
        return cur == null ? -1 : cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode cur = head;
        while (index > 1 && cur != null) {
            cur = cur.next;
            index--;
        }
        if (cur == null) {
            if (index == 0) {
                addAtTail(val);
            }
        } else {
            ListNode temp = cur.next;
            cur.next = node;
            node.next = temp;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        } else if (index == 0) {
            head = head.next;
            return;
        }
        ListNode cur = head;
        while (index > 1 && cur != null) {
            cur = cur.next;
            index--;
        }
        if (cur == null || cur.next == null) {
            return;
        }
        cur.next = cur.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
//        list.addAtIndex(0,10);
//        list.addAtIndex(0,20);
//        list.addAtIndex(1,30);

//        list.addAtHead(2);
//        list.deleteAtIndex(1);
//        list.addAtHead(2);
//        list.addAtHead(7);
//        list.addAtHead(3);
//        list.addAtHead(2);
//        list.addAtHead(5);
//        list.addAtTail(5);
//        list.get(5);
//        list.deleteAtIndex(6);
//        list.deleteAtIndex(4);
//        list.get(0);
        list.addAtHead(2);
        list.addAtIndex(0, 1);
        list.get(1);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */