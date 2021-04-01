package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zengjia
 * @date 2021-03-29 21:50:18
 */
public class SortOfStacksLCCI_面试题_03_05 {
    Deque<Integer> stack;
    Deque<Integer> assist;

    public SortOfStacksLCCI_面试题_03_05() {
        stack = new LinkedList<>();
        assist = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || stack.peek() >= val) {
            stack.push(val);
        } else {
            while (!stack.isEmpty() && stack.peek() < val) {
                assist.push(stack.pop());
            }
            stack.push(val);
            while (!assist.isEmpty()) {
                stack.push(assist.pop());
            }
        }if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public void pop() {

    }

    public int peek() {
        return stack.peek() == null ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
