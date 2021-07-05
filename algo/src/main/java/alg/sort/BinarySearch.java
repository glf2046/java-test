package alg.sort;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 7, 9, 24, 30, 40};

        int key = 24;
        int index = binarysearch(a, 0, a.length -1, key);
        System.out.println(index);
        int index2 = binarysearch_firstoccur(a, 0, a.length -1, 25);
        System.out.println("index2: " + index2);
    }

    //递归版本
    private static int binarysearch_firstoccur(int nums[], int low,int high, int key){
        if (low > high)
            return low;
        int mid = (low +high) / 2;
        if(nums[mid]>=key)
            return binarysearch_firstoccur(nums, low, mid-1, key);
        else
            return binarysearch_firstoccur(nums, mid + 1, high, key);
    }

    private static int binarysearch(int nums[], int low, int high, int key){
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == key)
                return mid;
            else if(nums[mid]>key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
