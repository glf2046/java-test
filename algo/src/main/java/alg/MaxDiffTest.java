package alg;

public class MaxDiffTest {

    public static void main(String[] args) {
        int[] values = {2, 3, 10, 9, 5, 20};
        System.out.println(getMaxDiffTricky(values, values.length));
    }

    private static int getMaxDiff(int[] values, int length) {
        int maxDiff = -1;
        for(int i = 0; i <length; i++){
            for(int j = i+1; j < length; j++){
                if(values[j] - values[i] > maxDiff){
                    maxDiff = values[j] - values[i];
                }
            }
        }

        return maxDiff;
    }

    private static int getMaxDiffTricky(int[] values, int length){
        int maxDiff = -1;
        int min = values[0];
        int currentValue;
        for(int i = 1; i < length; i++){
            currentValue = values[i];
            if(currentValue - min > maxDiff){
                maxDiff = currentValue -min;
            }
            if(currentValue< min){
             min = currentValue;
            }
        }

        return maxDiff;
    }
}
