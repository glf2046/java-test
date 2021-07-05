package com.lefeng.exception;

/**
 * @author guff
 * @since 2020-04-10 16:58
 */
//https://www.cnblogs.com/qdhxhz/p/10765839.html

public class StackTraceTest {
    /**
     * public static void main(java.lang.String[]);
     *     Code:
     *        0: invokestatic  #2                  // Method foo:()I
     *        3: istore_1
     *        4: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *        7: iload_1
     *        8: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
     *       11: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       14: ldc           #5                  // String Finally
     *       16: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *       19: goto          52
     *       22: astore_1
     *       23: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       26: aload_1
     *       27: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     *       30: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       33: ldc           #5                  // String Finally
     *       35: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *       38: goto          52
     *       41: astore_2
     *       42: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       45: ldc           #5                  // String Finally
     *       47: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *       50: aload_2
     *       51: athrow
     *       52: return
     *     Exception table:
     *        from    to  target type
     *            0    11    22   Class java/lang/Exception
     *            0    11    41   any
     *           22    30    41   any
     *
     *   public static int foo();
     *     Code:
     *        0: iconst_3
     *        1: ireturn
     * }
     * @param args
     */

    /**
     * 为什么生成的字节码在goto后面会有astore_1, 有时候也有aload_1(如果你操作了这个异常对象，比如打印）？
     * 当有异常抛出的时候，jvm会取得异常信息，这个过程要获取很多debug信息，比如调用堆栈，行号，等等（比较耗时，所以慎用异常）
     * 这个异常对象会被保存在当前栈帧的局部变量表中的第一个位置，如果后续会用到这个异常对象，那么会调用iload_1，如果不需要，后续就不会有iload_1的指令，
     * 但是异常对象不会被覆盖，知道被处理完成或者重新抛出（athrow)，所以后续不会看到astore_1的命令。
     * @param args
     */
    public static void main(String[] args) {
        try {
            int s = foo();
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Finally");
        }
    }

    public static int foo() {
        return 3;
    }
}
