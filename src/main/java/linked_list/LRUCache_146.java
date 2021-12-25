package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengjia
 * @date 2021-09-05 18:12:28
 */
public class LRUCache_146 {
    Map<Integer, DoublyLinkedListNode> map;
    int capacity;
    int size;
    DoublyLinkedListNode head, tail;

    public LRUCache_146(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        // 使用伪头部和伪尾部节点
        head = new DoublyLinkedListNode();
        tail = new DoublyLinkedListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoublyLinkedListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoublyLinkedListNode node = map.get(key);
        if (node == null) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            if (size == capacity) {
                DoublyLinkedListNode tail = removeTail();
                map.remove(tail.key);
            } else {
                size++;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DoublyLinkedListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoublyLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoublyLinkedListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DoublyLinkedListNode removeTail() {
        DoublyLinkedListNode realTail = tail.prev;
        removeNode(realTail);
        return realTail;
    }

    public static class DoublyLinkedListNode {
        int key;
        int value;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;

        public DoublyLinkedListNode() {

        }

        public DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
