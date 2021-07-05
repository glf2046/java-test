package alg.sort;

public class OddEvenSort {

    //refer to https://www.cnblogs.com/liuzhen1995/p/6433484.html
    private void getOddEvenSort2(int[] A){
        if(A.length == 1)
            return;

        //定义标准元素位置，最终结果是在该元素值的左边都是奇数，
        // 在该元素值的右边都是偶数
        int origin = 0;

        int i = 0;
        for(int j = 1;j < A.length;j++){
            //当A[j]为奇数时，右移一位，并交换A[i]和A[j]值，表明在i的左边均为奇数
            if(A[j] % 2 == 1){
                i++;
                if(i!=j) {
                    swap(A, i, j);
//                    System.out.println("swap: " + i + "," + j);
//                    for (int a : A) System.out.print(a + " ");
//                    System.out.println();
                }
            }
        }
        swap(A,i,origin);
    }

    //交换数组A的m位置和n位置上的值
    private void swap(int[] A, int m, int n){
        int temp = A[m];
        A[m] = A[n];
        A[n] = temp;
    }

    public static void main(String[] args){
        OddEvenSort test = new OddEvenSort();
        int[] B = {2,1,4,7,1,4,7,1,2,8,4,3,6,7,2,14,3,7,4,3,2,4,3,2,7};
        test.getOddEvenSort2(B);
        System.out.println("\n使用方法2：一前一后两指针往后扫描结果：");
        for (int aB : B) System.out.print(aB + " ");
    }
}
