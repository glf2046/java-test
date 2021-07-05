package alg.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet_316_removeDuplicateLetters {

    public static void main(String[] args) {
        String s = "bcabc";
        removeDuplicateLetters(s);
    }
    public static void removeDuplicateLetters(String s) {
        int len = s.length();

        char[] chars = s.toCharArray();

        int[] lastIndex = new int[26];

        for(int i = 0; i < len; i++){
            lastIndex[chars[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();

        boolean[] visited = new boolean[26];

        for(int i = 0; i < len; i++){

            //只要是曾经
            if (visited[chars[i] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            stack.addLast(chars[i]);
            visited[chars[i] - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : stack) {
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());
    }
}
