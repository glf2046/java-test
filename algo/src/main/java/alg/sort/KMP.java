package alg.sort;

public class KMP {

    public static void main(String[] args) {
        String s = "aabcdaabd";
        char[] p = s.toCharArray();
        int[] next = new int[p.length];
        makeNext(p, next);
        for (int value : next) {
            System.out.print(value + ",");
        }
    }

    private static void makeNext(char[] p, int[] next){
        int q=0, k=0;
        int len = p.length;

        next[0] = 0;

        for(q = 1, k=0; q < len;q++){

             while(k > 0 && p[q] != p[k]){
                k = next[k-1];
            }

            if(p[q] == p[k]){
                k++;
            }
            next[q] = k;
        }
    }
}
