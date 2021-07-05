package oom;

public class ConstantMemory {
    public static void main(String[] args) {


//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1 == str1.intern());
//        //java特殊？
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2 == str2.intern());
//        String str3 = new StringBuilder("ja").append("va1").toString();
//        System.out.println(str3 == str3.intern());


        //先运行这个代码
        String str3 = new StringBuilder("ni").append("hao").toString();
        System.out.println(str3==str3.intern());
        //通过上面的解释，运行结果为true.
        //再运行这个代码
        String str4 = new StringBuilder("nihao").toString();
        System.out.println(str4==str4.intern());
        //其结果是什么？应该还是true吧，毕竟通过上一个运行结果可以知道"nihao"这个字符串常量没有被预先加载到常量池中。
        //但是运行结果却是false.

        //确定的字符串在编译器就已经在常量池存在引用了，所以 new StringBuilder("nihao").toString() 和 new StringBuilder().append("nihao").toString()
        // 效果是一样的，运行System.out.println(str3==str3.intern()) 一定是false ,因为编译期常量池就存在了"nihao"。
        // 而new StringBuilder("ni").append("hao").toString();在编译器只存在"ni" 和 "hao", str3的值只存在堆中，str3.intern()
        // 会在常量池加载"nihao"并返回str3的引用，所以比较结果为true
        // 可以查看反编译指令
        /**
         * 参考：https://segmentfault.com/a/1190000011543995
         */
        String s2 = new StringBuilder("21").toString();
//        String s2 = new String("hello");
        System.out.println(s2 == s2.intern());





//        try {
//            List<String> list = new ArrayList<String>();
//            int item = 0;
//            while(true){
//                list.add(String.valueOf(item++).intern());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
    }

}
