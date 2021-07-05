package alg.sort;
public class MergeSortCopy {
    public static void main(String[] args) {
        int[] a = new int[]{4, 7, 2, 3, 5, 6, 9, 8};
        sort(a, 0, a.length-1);
    }
    private static void sort(int[] a, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            sort(a, low, mid);
            sort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }
    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid +1;
        int k = 0;
        while(i <= mid && j <= high){
            if(a[i] < a[j]){
                temp[k] = a[i];
                i++;
            }else{
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = a[i];
            k++;
            i++;
        }
        while(j <= high){
            temp[k] = a[j];
            k++;
            j++;
        }
        System.arraycopy(temp, 0, a, low, temp.length);
    }
}
