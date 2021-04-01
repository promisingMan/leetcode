package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

class 用两个栈实现队列_剑指offer_09 {
    Deque<Integer> in;
    Deque<Integer> out;

    public 用两个栈实现队列_剑指offer_09() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            if (in.isEmpty()) {
                return -1;
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */