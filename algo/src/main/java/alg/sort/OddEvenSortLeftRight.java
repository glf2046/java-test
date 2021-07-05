package alg.sort;

public class OddEvenSortLeftRight {
    //解法1：一头一尾指针往中间扫描
    private void getOddEvenSort1(int[] A){
        if(A.length == 1)
            return;
        int begin = 0;
        int end = A.length - 1;
        while(begin < end){
            if(A[begin] % 2 == 1)   //当A[begin]为奇数时
                begin++;
            else if(A[end] % 2 == 0) //当A[end] 为偶数时
                end--;
            else                 //当A[begin]不是奇数且A[end]不是偶数时
                swap(A,begin,end);
        }
    }

    //交换数组A的m位置和n位置上的值
    private void swap(int[] A, int m, int n){
        int temp = A[m];
        A[m] = A[n];
        A[n] = temp;
    }

    public static void main(String[] args){
        OddEvenSortLeftRight test = new OddEvenSortLeftRight();
        int[] A = {2,1,4,7,1,4,7,1,2,8,4,3,6,7,2,14,3,7,4,3,2,4,3,2,7};
        test.getOddEvenSort1(A);
        System.out.println("使用方法1：一头一尾指针往中间扫描结果：");
        for (int aA : A) System.out.print(aA + " ");
    }
}
