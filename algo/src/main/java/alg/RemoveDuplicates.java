package alg;

public class RemoveDuplicates {

   public static void remove_duplicate(char[] str){
        if(str==null)
            return;
        int len=str.length;
        if(len<2)
            return;
        int i,j;
        for(i=0;i<len;++i){
            if(str[i]!='\0'){
                for(j=i+1;j<len;++j){
                    if(str[j]==str[i])
                        str[j]='\0';
                }
            }
        }
    }

    public static void main(String[] args) {
       char[] chars = {'a', 'b', 'a', 'a'};
        remove_duplicate(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.printf(chars[i] + ",");
        }
        System.out.println();
    }

}
