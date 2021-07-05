package alg.sort2;

public class InsertSortCopy {
    public static void main(String[] args) {
        int[] a = new int[]{9, 7, 2, 3, 5, 6, 9, 8};
        insert(a);

    }

    private static void insert(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int value = a[i];
            int j = i-1;
            while(j>=0 && value < a[j]){
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = value;

            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + ", ");
            }
            System.out.println();
        }
    }
}
