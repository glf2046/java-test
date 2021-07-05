package alg.sort;

public class Insert {

    public static void main(String[] args) {
        int[] a = new int[]{9, 7, 2, 3, 5, 6, 9, 8};
        insert(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    private static void insert(int[] a){

        int len = a.length;
        if(len < 1)
            return;

        for (int i = 0; i <len; i++) {
            int temp = a[i];
            int j = i;

            while(j > 0 && temp < a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }
}
