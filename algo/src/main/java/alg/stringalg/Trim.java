package alg.stringalg;

public class Trim {

    public static void main(String[] args) {
        String a = "    hello     ";
        String result = trim(a);
        System.out.println("#####" + result + "##########");
    }

    private static String trim(String s){

        if(s == null){
            return null;
        }

        char[] a = s.toCharArray();

        int left = 0;
        int right = a.length-1;

        while(left <= right && a[left] == ' '){
            left++;
        }

        while(right >=0 && a[right] == ' '){
           right--;
        }

        return String.valueOf(a).substring(left, right+1);
    }
}
