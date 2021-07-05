package com.lefeng.syntax;

public class BreakTest {
    public static void main(String[] args) {
        System.out.println("##################### \"break\" is used to exit from a inner block or a specified labeled block.");
        //"break" is used to exit from a inner block or a specified labeled block.
        //Refer to: http://techbus.safaribooksonline.com/9781430266532/sec36_xhtml#X2ludGVybmFsX0h0bWxWaWV3P3htbGlkPTk3ODE0MzAyNjY1MzIlMkZzZWMxNl85NzgxNDMwMjY2NTI1X2NoMDVfeGh0bWwmcXVlcnk9

        //Instead "continue" can be used within loops(for/while).
        int d2 = 20;
        label2:{
            if (d2 > 10) {
                System.out.println(d2);
            } else {
                break label2;
            }

            System.out.println("");
        }

        System.out.println("");
    }
}
