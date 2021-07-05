package alg.array;

public class Offer_05_replaceSpace {

    public static void main(String[] args) {
        System.out.println(new Offer_05_replaceSpace().replaceSpace("We are happy"));
    }
    public String replaceSpace(String s){
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }

        System.out.println("".replace(" ", "%20"));

        return result.toString();
    }
}
