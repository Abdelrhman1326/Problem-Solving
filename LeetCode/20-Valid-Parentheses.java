import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (top == '(' && c == ')') {
                    stack.pop();
                    continue;
                }
                if (top == '{' && c == '}') {
                    stack.pop();
                    continue;
                }
                if (top == '[' && c == ']') {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}