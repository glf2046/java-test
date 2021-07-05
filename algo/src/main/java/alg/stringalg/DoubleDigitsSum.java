package alg.stringalg;

/**
 * 求一个double类型各个位数字之和（第一位可能为负数，算一个负数），也可能有小数点
 */
public class DoubleDigitsSum {
    public static void main(String[] args) {
        System.out.println((int)3.45/1);
        System.out.println((int)4.5/1);
        System.out.println((int)4.7/1);
    }

    private int doubleDigitsSum(double d){
        int places = 0;
        double temp = d;
        boolean isNegative = d < 0;
        if (isNegative) {
            d = d * -1;
        }
        while ((temp = temp / 10) > 1) {
            places++;
        }

        double temp2 = d;
        
        int sum = 0;
        while (d > 1 && places >=0) {
            sum += d / places * Math.pow(10, places);
            d -= places * Math.pow(10, places);
            places--;
        }

        double part2 = temp2;

        return -1;
    }
}
