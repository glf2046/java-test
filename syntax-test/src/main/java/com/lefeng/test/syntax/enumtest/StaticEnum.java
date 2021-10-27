package com.lefeng.test.syntax.enumtest;

class StaticEnum {

    private EnumTest enumTest;

    private StaticEnum(EnumTest enumTest) {
        this.enumTest = enumTest;
    }

    private void fun1(){
        if(enumTest == EnumTest.VALUE1){
            System.out.println("value1");
            System.out.println(EnumTest.anotherValue);
        }
    }

    public static void main(String[] args) {
       StaticEnum staticEnum = new StaticEnum(EnumTest.VALUE1);
       staticEnum.fun1();
    }

    private enum EnumTest{

        VALUE0(0),
        VALUE1(1),
        VALUE2(2);

        private int code;
        public static int anotherValue;

        static {anotherValue = 11;}

        EnumTest(int code){
           this.code = code;
        }

        public boolean isInitialising(){
            return VALUE0.code == code;
        }
    }

    //can't inherit from Enum type, since it by default has a modifier of final
//
//    private enum SubEnumTest extends EnumTest{
//    }

}
