package alg.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Leet_20_ValidParenttheses {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(()(()))"));
        System.out.println(isValid("(()[()])"));
        System.out.println(isValid("{()[()]}"));
        System.out.println(isValid("{[][()]}"));
        System.out.println(isValid(")[][()]("));

    }

    public static boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        if (s.startsWith("(") || s.startsWith("[") || s.startsWith("{")) {
            char[] array = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            stack.push(array[0]);
            for (int i = 1; i < array.length; i++) {
                if (!stack.isEmpty() && matches(stack.peek(), array[i])) {
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }
            }

            return stack.size() == 0;
        }

        return false;
    }

    private static Map<Character, Character> PAIRS = new HashMap<>();

    static {
        PAIRS.put('(', ')');
        PAIRS.put('[', ']');
        PAIRS.put('{', '}');
        PAIRS.put(')', '\0');
        PAIRS.put(']', '\0');
        PAIRS.put('}', '\0');

    }

    private static boolean matches(char left, char right) {
        return PAIRS.get(left) == right;
    }
}
