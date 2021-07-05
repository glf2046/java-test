package alg;

import java.util.HashMap;

public class Leet_535_tiny_url {
    public static void main(String[] args) {
        Codec codec = new Codec();
        for (int i = 0; i < 200; i++) {
            System.out.println(codec.decode(codec.encode(String.valueOf(i))));
        }
    }

    static class Codec {

        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String, String> map = new HashMap<>();
        int count = 1;

        public String getString() {
            int c = count;
            StringBuilder sb = new StringBuilder();
            while (c > 0) {
                c--;
                sb.append(chars.charAt(c % 62));
                c /= 62;
            }
            return sb.toString();
        }

        public String encode(String longUrl) {
            String key = getString();
            map.put(key, longUrl);
            count++;
            return "http://tinyurl.com/" + key;
        }

        public String decode(String shortUrl) {
            return map.get(shortUrl.replace("http://tinyurl.com/", ""));
        }
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/encode-and-decode-tinyurl/solution/tinyurlde-jia-mi-yu-jie-mi-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
