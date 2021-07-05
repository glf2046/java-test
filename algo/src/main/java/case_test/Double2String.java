package case_test;

public class Double2String {
    public static void main(String[] args) {
        double ZERO = Math.pow(10, -6);
        double d1 = 123.123;
        int i1 = (int) d1;
        double d2 = d1 - i1;

        int sum = 0;
        while (i1 > 0) {
            int tempLeft = i1;
            int tempLoopTimes = 0;
            while (tempLeft > 10) {
                tempLeft /= 10;
                tempLoopTimes++;
            }

            sum += tempLeft;

            i1 -= tempLeft * Math.pow(10, tempLoopTimes);
        }


        System.out.println(sum);

        while (d2 > ZERO) {
            double tempLeft = d2;
            int tempLoopTimes = 0;
            while (tempLeft < 1) {
                tempLeft *= 10;
                tempLoopTimes++;
            }
            sum += (int) tempLeft;
            d2 -= ((int) tempLeft) * Math.pow(10, -tempLoopTimes);
        }

        System.out.println(sum);
//
//        System.out.println(i1);
//        System.out.println(d1-i1);
//
//        System.out.println(double2String(123.3));
//        System.out.println(s1);
    }

    public static int double2String(double d) {
        System.out.println(0.13 / 10);
        System.out.println("###############");
//        char[] result = new char[100];
//        while (d > 0) {
//            System.out.println(d);
//            d /= 10;
//        }
//        System.out.println(d*10 + '0');

        return 0;
    }
}
