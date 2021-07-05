package com.lefeng.string;

public class StringInternTest {
    //############################################################
    //##### https://www.baeldung.com/java-string-pool #####
    //############################################################
    //can print the stats of string pool using jvm flag "-XX:+PrintStringTableStatistics"
    //it will print as following:
    //    SymbolTable statistics:
    //    Number of buckets       :     20011 =    160088 bytes, avg   8.000
    //    Number of entries       :     12978 =    311472 bytes, avg  24.000
    //    Number of literals      :     12978 =    500920 bytes, avg  38.598
    //    Total footprint         :           =    972480 bytes
    //    Average bucket size     :     0.649
    //    Variance of bucket size :     0.652
    //    Std. dev. of bucket size:     0.807
    //    Maximum bucket size     :         6
    //    StringTable statistics:
    //    Number of buckets       :     60013 =    480104 bytes, avg   8.000
    //    Number of entries       :    100924 =   2422176 bytes, avg  24.000
    //    Number of literals      :    100924 =   7262264 bytes, avg  71.958
    //    Total footprint         :           =  10164544 bytes
    //    Average bucket size     :     1.682
    //    Variance of bucket size :     1.118
    //    Std. dev. of bucket size:     1.057
    //    Maximum bucket size     :         6

    static String baseString = "hello-world";
    static int count = 0;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println(this.getClass());
                    System.out.println(this.hashCode());
                    if (count == 0) {
                        baseString += "ex";
                    }
                    System.out.println(baseString);
                    count++;
                    System.out.println(count);
                }
            }
        };

        new StringInternTest().test(runnable);

//        for (int i = 0; i < 1000; i++) {
//            new String(baseString + i).intern();
//        }
    }

    private void test(Runnable runnable) {
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
