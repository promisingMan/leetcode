package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingTwoQueues_225 {
    Queue<Integer> assist;
    Queue<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingTwoQueues_225() {
        assist = new LinkedList<>();
        stack = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        assist.offer(x);
        while (!stack.isEmpty()) {
            assist.offer(stack.poll());
        }
        Queue<Integer> temp = assist;
        assist = stack;
        stack = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return stack.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return stack.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingTwoQueues_225 queueToStack = new ImplementStackUsingTwoQueues_225();
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