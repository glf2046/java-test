package alg.sort;

public class HeapSortCopy {

    public static void main(String[] args) {
        int[] a = {2, 5, 8, 9, 3, 0, 1, 4, 7, 6};
        int len = a.length;
        for (int i = len/2; i >= 0; i--) {
            heapAdjust(a, i, len);
        }
        heapSort(a, len);
    }
    private static void heapSort(int[] a, int len){
        for (int i = len -1; i >=0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapAdjust(a, 0, i);
        }
    }

    //For all the potential 'parent' nodes(which has children)
    //If it's already the biggest, then end the processing
    //otherwise, go down to find the suitable position for it in the child branch recursively.
    private static void heapAdjust(int[] a, int parent, int len){
        int temp = a[parent];
        int left = 2*parent + 1; //left child
        int indexOfBiggerChildren = -1;

        while(left < len){
            //first compare right child(child+1) with left child, record the index of bigger one
            int right = left +1;
            indexOfBiggerChildren = left;
            if(right < len && a[right] > a[left]){
                indexOfBiggerChildren = right;
            }

            //if current parent is already the biggest one, then stop processing, this level tree structure is good(parent is biggest)
            if(temp > a[indexOfBiggerChildren]){
                break;
            }
            //If current parent is not the biggest, then find the suitable position in child branch recursively.
            a[parent] = a[indexOfBiggerChildren];

            parent = indexOfBiggerChildren;
            left = 2*indexOfBiggerChildren + 1;
        }
        //put the initial parent value to the new place which it is suited.
        a[parent] = temp;
    }
}
