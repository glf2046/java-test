package alg.sort;

public class Pop {
    public static void main(String[] args) {
        int[] a = new int[]{9, 7, 2, 3, 5, 6, 9, 8};
        popFirstKItems(a, 4);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    //top k problem
    private static void popFirstKItems(int[] a, int k){
        int len = a.length;

        if(len < 1){
            return;
        }

        for(int i = 0; i < k; i++){
            for (int j = i+1; j < len; j++) {
                if(a[j] < a[i]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    private static void pop(int[] a){
        int len = a.length;

        if(len < 1){
            return;
        }

        for(int i = 0; i < len; i++){
            for (int j = i+1; j < len; j++) {
                if(a[j] < a[i]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    private static void popMaxToMin(int[] a) {
        int len = a.length;

        if (len < 1) {
            return;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
}
