package alg.sort2;

public class MergeSortCopy {
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

    private static void sort(int[] a, int low, int high) {

        int mid = (low + high)/2;

        if(low < high){
            sort(a, low, mid);
            sort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] b = new int[high - low + 1];

        int i = low;
        int j= mid+1;
        int k = 0;

        while(i <= mid && j <=high){
            if(a[i] <= a[j]){
                b[k++] = a[i++];
            }else{
                b[k++] = a[j++];
            }
        }

        while(i <= mid){
            b[k++] = a[i++];
        }

        while(j <= high){
            b[k++] = a[j++];
        }

        for (int l = 0; l < b.length; l++) {
            a[low++] = b[l];
        }
    }
}
