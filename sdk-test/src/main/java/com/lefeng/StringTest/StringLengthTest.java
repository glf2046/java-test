package com.lefeng.StringTest;

/**
 * @author guff
 * @since 2019-10-29 9:53 PM
 */
public class StringLengthTest {
    public static void main(String[] args) {

        StringBuilder s = null;
        try {
            s = new StringBuilder();
            while(true){
                s.append("hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello");
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.out.println("OutOfMemoryError error ##########");
            System.out.println(s.length());
        } finally {
        }
    }
}
