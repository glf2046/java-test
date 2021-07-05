package alg.heap_topk;
public class TopKViaQuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{9, 7, 2, 3, 5, 6, 9, 8};
        int k = 4;
        topK(a, k);
        printTopK(a, k);
    }

    private static void printTopK(int[] a, int k) {
        for (int i = 0; i < k; i++) {
            System.out.println(a[i]);
        }
    }

    private static void topK(int[] a, int k)
    {
        int len = a.length;
        if(len <= k) //数组元素个数小于k，则不需要处理
            return ;
        int low = 0;
        int high = len-1;
        int j = partition(a,low,high);  //找到划分位置j
        while(j!=k) //划分位置不是k则继续处理
        {
            if(k > j)    //k在分划点后面部分
                low = j+1;
            else
                high = j;   //k在分划点前面部分
            j = partition(a,low,high);
        }
    }
    private static int partition(int[] a, int low, int high)   //分划函数
    {
        if(high <= low)
            return low;
        int i=low;
        int j=high;
        while(i<j)
        {
            i++;
            while(i<high && a[i]>a[low])  //从前往后找小于等于a[low]的元素,找到后就准备交换到后面去
                i++;
            while(j>low && a[j]<a[low])  //从后往前找大于等于a[low]的元素，找到后就准备交换到前面去
                j--;
            if(i<j)  //交换
            {
                int swap = a[i];a[i] = a[j];a[j] = swap;
            }
        }
        int swap = a[low];  a[low] = a[j];  a[j] = swap;
        return j;   //返回分划点
    }
}
