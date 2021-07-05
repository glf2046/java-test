package alg.sort2;

public class BinarySearchCopy {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 7, 9, 24, 30, 40};

        int key = 2;

        System.out.println(binarySearch_recursive(a, 0, a.length-1, key));
    }
    

    public static int binarySearch_recursive(int[] a, int low, int high, int key){
        if(low >= high)
            return low;

        int mid = (low + high)/2;

        if(a[mid] > key){
            return binarySearch_recursive(a, low, mid, key);
        }else if(a[mid] < key){
            return binarySearch_recursive(a, mid, high, key);
        }else{
            return mid;
        }
    }

    public static int binarySearch_iterate(int[] a, int low, int high, int key){
        while(low <= high){
            int mid = (low + high)/2;
            if(a[mid] == key){
                return mid;
            }else if(a[mid] < key){
                low = mid;
            }else{
                high = mid;
            }
        }

        return low;
    }
}
