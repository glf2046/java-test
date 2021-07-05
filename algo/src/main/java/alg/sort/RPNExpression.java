package alg.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RPNExpression {
    public static void main(String[] args) {
        System.out.println((int)'9');
        System.out.println((int)'0');
        String s = "3*(5+4/2-1)";
        String s1 = "3*5+2";
        System.out.println(jisuan(parse(zb(s1))));
    }

    private static ArrayDeque<String> ms1 = new ArrayDeque<>();//生成逆波兰表达式的栈
    private static ArrayDeque<String> ms2 = new ArrayDeque<>();//运算栈

     //将字符串转换为中序表达式
    private static List<String> zb(String s) {
        List<String> ls = new ArrayList<>();//存储中序表达式
        int i = 0;
        StringBuilder str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add(String.valueOf(c));
                i++;
            } else {
                str = new StringBuilder();
                while (i < s.length() && (c = s.charAt(i)) >= 48
                        && (c = s.charAt(i)) <= 57) {
                    str.append(c);
                    i++;
                }
                ls.add(str.toString());
            }

        } while (i < s.length());
        return ls;
    }

     //将中序表达式转换为逆波兰表达式
    private static List<String> parse(List<String> ls) {
        List<String> lss = new ArrayList<>();
        for (String ss : ls) {
            if (ss.matches("\\d+")) {
                lss.add(ss);
            } else if (ss.equals("(")) {
                ms1.push(ss);
            } else if (ss.equals(")")) {
                while (ms1.peek() != null && !ms1.peek().equals("(")) {
                    lss.add(ms1.pop());
                }
                ms1.pop(); //pop  the remaining '('
            } else {
                while (ms1.size() != 0 && getValue(ms1.peek()) >= getValue(ss)) {
                    lss.add(ms1.pop());
                }
                ms1.push(ss);
            }
        }
        while (ms1.size() != 0) {
            lss.add(ms1.pop());
        }
        return lss;
    }

     //对逆波兰表达式进行求值
    public static int jisuan(List<String> ls) {
        for (String s : ls) {
            if (s.matches("\\d+")) {
                ms2.push(s);
            } else {
                int b = Integer.parseInt(ms2.pop());
                int a = Integer.parseInt(ms2.pop());
                if (s.equals("+")) {
                    a = a + b;
                } else if (s.equals("-")) {
                    a = a - b;
                } else if (s.equals("*")) {
                    a = a * b;
                } else if (s.equals("/")) {
                    a = a / b;
                }
                ms2.push(String.valueOf(a));
            }
        }
        
        return Integer.parseInt(ms2.pop());
    }

    /**
     * 获取运算符优先级
     * +,-为1 *,/为2 ()为0
     */
    public static int getValue(String s) {
        if (s.equals("+")) {
            return 1;
        } else if (s.equals("-")) {
            return 1;
        } else if (s.equals("*")) {
            return 2;
        } else if (s.equals("/")) {
            return 2;
        }
        return 0;
    }
}
