package alg.array;

public class Leet_4_MedianOfTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Leet_4_MedianOfTwoArray().findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //思路，两个数组中的所有元素按照从小到大取出，取到第(m+n)/2个元素就是
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[len1+len2];
        while (i < len1 && j < len2){
            while (i < len1 && nums1[i] <= nums2[j]){
                merged[k++] = nums1[i++];
            }

            while (i < len1 && j < len2 && nums1[i] > nums2[j]){
                merged[k++] = nums2[j++];
            }
        }

        while (i < len1){
            merged[k++] = nums1[i++];
        }

        while (j < len2){
            char c = '\0';
            merged[k++] = nums2[j++];
        }

        int middle = (len1 + len2)/2;
        if ((len1 + len2)%2 == 0){
            return (merged[middle -1] + merged[middle])/2.0;
        } else {
            return merged[middle];
        }
    }
}
