package alg;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

public class RemoveDuplicatesFromArray {
    //LeetCode �C Remove Duplicates from Sorted Array (Java)
    public static int[] removeDuplicates(int[] A) {
        if (A.length < 2)
            return A;

        int j = 0;
        int i = 1;

        //cursor 'i' move forward to find a different
        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }

        int[] B = Arrays.copyOf(A, j + 1);

        return B;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,1};
        Hashtable ht = new Hashtable();
        for (int i = 0; i < arr.length; i++) {
            ht.put(arr[i], arr[i]);
        }

        Set<Integer> keySet = ht.keySet();
        for(int i :  keySet){
            System.out.println(i);
        }

    }
}