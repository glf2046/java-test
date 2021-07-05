package com.lefeng.others;

public class Test{
    public static void main(String[] args){
        Test test = new Test();
        Bean1 bean1 = test.new Bean1();
        bean1.I++;
        Bean2 bean2 = new Bean2();
        bean2.J++;
        Bean bean =new Bean();
        Bean.Bean3 bean3 = bean.new Bean3();
        bean3.k++;
    }
    class Bean1{
        public int I = 0;
    }

    static class Bean2{
        public int J = 0;
    }
}

class Bean{
    class Bean3{
        public int k = 0;
    }
}
