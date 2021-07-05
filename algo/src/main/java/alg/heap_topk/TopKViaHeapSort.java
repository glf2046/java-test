package alg.heap_topk;

public class TopKViaHeapSort {

    public static void main(String[] args) {
        int k = 6;
        int[] a = {2, 5, 8, 9, 3, 0, 1, 4, 7, 6};
        //initialize a heap with 'k=4' initial elements.
        int[] initialHeap = {-1, -1, -1, -1, -1, -1};

        for (int i = 0; i < a.length; i++) {
            //  最小堆(堆顶是最小的，堆上总共有k个元素，其余k-1个元素都必堆顶大，所以是最大的k个元素。
            //   每次有新元素过来，只有比堆顶元素大才可以进入堆（调整到合适的位置）
            if(a[i] > initialHeap[0]){
                initialHeap[0] = a[i];
                heapAdjust(initialHeap, 0, initialHeap.length);
            }
        }

        //输出的结果就是按照二叉树（堆）的层次依次输出，所以可以根据输出很容易知道树的样子
        printPart(initialHeap, 0, initialHeap.length - 1);
    }

    /**
     * 最小堆(堆顶是最小的，堆上总共有k个元素，其余k-1个元素都必堆顶大，所以是最大的k个元素。
     * 每次有新元素过来，只有比堆顶元素大才可以进入堆（调整到合适的位置）
     * @param a
     * @param parent
     * @param len
     */
    private static void heapAdjust(int[] a, int parent, int len){
        int temp = a[parent];
        int left = 2*parent + 1; //left child
        //it's the smallest one(among left, right, parent) which gets transferred to new place
        int indexOfSmallerChildren = -1;

        while(left < len){
            //first compare right-child(left-child+1) with left child, record the index of bigger one
            int right = left +1;
            //assume left child is bigger one
            indexOfSmallerChildren = left;
            //if left side is smaller, then assign 'indexOfSmallerChildren' to 'right'
            if(right < len && a[right] < a[left]){
                indexOfSmallerChildren = right;
            }

            //if root node value is already smaller than the smallest of two children, i.e. the smallest, then no need to adjust
            if(temp < a[indexOfSmallerChildren]){
                break;
            }

            //otherwise, assign the smallest value to root node
            a[parent] = a[indexOfSmallerChildren];

            //smallest value(indexOfSmallerChildren's value) has been assigned to root node, but the root node's original value needs to be placed properly in the array
            //since indexOfSmallerChildren's value has been given to root node,
            //so we will find a proper place for old root node value in the branch of 'indexOfSmallerChildren''s.
            parent = indexOfSmallerChildren;
            //assign new array index to left, the ending condition is that the new left child is still within the array,
            //otherwise, the right child is not within the array too,(left+1), then how to compare the values with incoming/to-be-placed old root value?
            left = 2*indexOfSmallerChildren + 1;
        }
        //Finally, if the new 'parent'(denoted by array index of 'parent') has no children,
        //then 'parent' itself is the place where to put the initial parent value.
        a[parent] = temp;
    }

    // 打印序列
    public static void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }
}
