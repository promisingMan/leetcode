package stack_queue;

import java.util.HashMap;
import java.util.LinkedList;

class ValidParentheses_20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>(3);
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        if (s == null || s.length() == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char charStr = s.charAt(i);
            if (map.containsKey(charStr)) {
                stack.addFirst(charStr);
            } else {
                if (stack.isEmpty() || !map.get(stack.removeFirst()).equals(charStr)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}