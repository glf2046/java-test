package alg.sort;

public class PatternMatching {
    public static void main(String[] args) {
       String s = "abdabceg";
       char[] t = s.toCharArray();
       String s1 = "abc";
       char[] p = s1.toCharArray();
       int pos = patternMatch(t, p);
        System.out.println(pos);
    }

    private static int patternMatch(char[] t, char[] p){

        int tLen = t.length;
        int pLen = p.length;
        int tPos = 0;
        int pPos = 0;

        int i = 0;
        while(i < tLen - pLen && tPos < tLen && pPos < pLen){
            if(t[tPos] == p[pPos]){
               if(pPos == pLen-1){
                   return i;
               }
                pPos++;
               tPos++;
            }else{
                pPos = 0;
                i++;
                tPos = i;
            }
        }
        return -1;
    }
}
