package alg.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{4, 7, 2, 3, 5, 6, 9, 8};
        sort(a, 0, a.length -1);
        print(a, a.length);
    }

    private static void print(int[] a, int len){
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    public static void sort(int[] a,int low,int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }
}
