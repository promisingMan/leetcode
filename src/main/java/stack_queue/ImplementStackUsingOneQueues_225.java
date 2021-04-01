package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingOneQueues_225 {
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingOneQueues_225() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        while (size > 0) {
            queue.offer(queue.poll());
            size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingOneQueues_225 queueToStack = new ImplementStackUsingOneQueues_225();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.top(); // 返回 2
        queueToStack.pop(); // 返回 2
        queueToStack.empty(); // 返回 False
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */