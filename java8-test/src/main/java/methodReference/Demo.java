package methodReference;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
        //对象实例语法	instanceRef::methodName
        list.forEach(new Demo2()::print);
    }

    public void foo(){
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
        //对象实例语法	instanceRef::methodName
        list.forEach(new Demo2()::print);
    }

}

class Demo2{
    public int print(String content){
        System.out.println(content);
        return 0;
    }
}
