package leecode;

import java.util.HashMap;
import java.util.Stack;

public class Al04 {

    private HashMap<Character, Character> mappings;
    public Al04() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                //栈里只放左括号
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Al04 al04 = new Al04();
        System.out.println(al04.isValid("[[]]{}{}{{[]}}()"));
    }

}
