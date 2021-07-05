import java.util.ArrayList;
import java.util.List;

/**
 * @author guff
 * @since 2020-04-12 23:06
 */
public class ObjectCount {
    public static void main(String[] args) {
        List<A> list = new ArrayList<A>();
        int count =  33554434;
        for (int i = 0; i < count; i++) {
            list.add(new A((byte) 1));
        }

        System.out.println(list.size());
    }
}

class A{
    byte aByte;

    public A(byte aByte) {
        this.aByte = aByte;
    }
}
