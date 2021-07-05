package alg.recursive;

public class PalindromicString {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(palindromic(s));
    }

    private static boolean palindromic(String s) {
        char[] chars = s.toCharArray();

        if (chars.length == 1) {
            return true;
        }

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
