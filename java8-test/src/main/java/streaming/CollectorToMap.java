package streaming;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author guff
 * @since 2019-06-6:34 PM
 */
public class CollectorToMap {

    public static void main(String[] args) {
        Map<Integer, String> map = Arrays.stream(Color.values()).collect(Collectors.toMap(Color::getValue, Color::getDesc));

        Map<Integer, Color> map2 = Arrays.stream(Color.values()).collect(Collectors.toMap(Color::getValue, Function.identity()));

        Function<Integer, Integer> id = Function.identity();

        System.out.println(id.apply(3));


        System.out.println(map);
    }

    enum Color {
        GREEN(1, "green"),
        RED(2, "red");

        private Integer value;

        private String desc;

        Color(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
