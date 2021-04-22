package linked_list;

/**
 * @author zengjia
 * @date 2021-04-22 08:25:15
 */
public class DoublyLinkedList {
    int size;
    DoublyListNode head;
    DoublyListNode tail;

    public DoublyLinkedList() {
        head = new DoublyListNode(0);
        tail = new DoublyListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        DoublyListNode cur = getNodeByIndex(index);
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (size < 0) {
            index = 0;
        }

        DoublyListNode pre, next;
        if (index < size - index) {
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            next = pre.next;
        } else {
            next = tail;
            for (int i = 0; i < size - index; i++) {
                next = next.pre;
            }
            pre = next.pre;
        }

        DoublyListNode node = new DoublyListNode(val);
        node.pre = pre;
        node.next = next;
        pre.next = node;
        next.pre = node;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        DoublyListNode cur = getNodeByIndex(index);
        DoublyListNode pre = cur.pre;
        DoublyListNode next = cur.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }

    /**
     * 获取指定索引节点
     *
     * @param index
     * @return
     */
    private DoublyListNode getNodeByIndex(int index) {
        DoublyListNode cur;
        if (index < size - index) {
            cur = head;
            for (int i = 0; i < index + 1; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.pre;
            }
        }
        return cur;
    }
}
