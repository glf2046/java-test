package alg;

public class MinMaxTest {
    public static void main(String[] args) {
        int[] values = {2, 3, 10, 9, 5, 20};
        getMinMax(values, values.length);
        MinMax minMax = getMinMaxDivideConquor(values, 0, values.length-1);
        System.out.println(minMax);
    }

    private static MinMax getMinMaxDivideConquor(int[] values, int low, int high){
        //Check input
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if(high - low <=1){
            if(values[high] > values[low]){
                max = values[high];
                min = values[low];
            }else{
                min = values[high];
                max = values[low];
            }
        }else{
            int mid = (low + high)/2;
            MinMax leftResult = getMinMaxDivideConquor(values, low, mid);
            MinMax rightResult = getMinMaxDivideConquor(values, mid+1, high);
            min = Math.min(leftResult.min, rightResult.min);
            max = Math.max(leftResult.max, rightResult.max);
        }

        return new MinMax(min, max);
    }

    private static void getMinMax(int[] values, int length) {
         int min = values[0];
         int max = values[0];
         for(int i = 1; i <length; i++){
            if(values[i] > max){
                max = values[i];
            }else if(values[i] < min){
                min = values[i];
            }
         }

        System.out.println(min + ", " + max);
    }
    static class MinMax{
        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
        @Override
        public String toString() {
            return min + ", " + max;
        }
        public int min;
        public int max;
    }
}
