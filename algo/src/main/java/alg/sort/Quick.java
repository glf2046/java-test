package alg.sort;

public class Quick {

    public static void main(String[] args) {
        int[] a = new int[]{4, 7, 2, 3, 5, 6, 9, 8};
        quick(a, 0, a.length -1);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i] +", ");
        }
        System.out.println();
    }

    private static void quick(int[] a, int low, int high){
        int len = a.length;
        if(len < 1){
            return;
        }
        if(low >= high){
            return;
        }
        int left = low;
        int right = high;

        int key = a[left];

        while(left < right) {
            while (left < right && a[right] >= key) {
                right--;
            }
            a[left] = a[right];

            while (left < right && a[left] <= key) {
                left++;
            }
            a[right] = a[left];
        }

        a[left] = key;
        quick(a, low, left -1);
        quick(a, left + 1, high);
    }
}
