package alg.two_pointers;

/**
 * 1055. 形成字符串的最小路径
 * https://leetcode-cn.com/problems/shortest-way-to-form-string/
 */
public class Leet_1055_form_string_shortest_path {
    public static void main(String[] args) {
        String source = "x";
//        String target = "xzyxzd";
        String target = "xxx";

        System.out.println(shortestWay(source, target));
    }

    /**
     * 双指针法，每次在target中查找source的子序列，总和不超过target的长度。
     */
    public static int shortestWay(String source, String target) {
        int i, j = 0;
        int count = 0;
        //如果能匹配，最坏的情况是target中的每个元素都需要对照着source的全集找一遍，
        // 这样最多找length遍，因为count从0开始，count的最大值就是length-1,但因为这种情况不满足题目要求？
        //所以如果count=length，那么就是不匹配，有些元素不在source中。瞎找了length遍，这时候while循环中：j<target.length()一直满足条件，
        // 直到count++达到length,
        while (j < target.length() && count < target.length()) {
            i = 0;
            while (i < source.length() && j < target.length()) {
                if (source.charAt(i) == target.charAt(j)) {
                    ++i;
                    ++j;
                } else {
                    //如果对应的源位置不等于目标位置，那么源指针继续往后移动一次（也就是保证了只要顺序出现在源数组就可以，中间可以不同
                    ++i;
                }
            }

            count++;
        }
        return count < target.length() ? count : -1;
    }
}
