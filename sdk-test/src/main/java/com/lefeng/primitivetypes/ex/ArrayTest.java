package com.lefeng.primitivetypes.ex;

public class ArrayTest {
    public static void main(String[] args) {
        // Create an array of String
        String[] name = new String[5];

        // A runtime error as name[0] is null
        int len = name[0].length();

        // Assign a valid string object to all elements of the array
        for (int i = 0; i < name.length; i++){
            name[i] = "name" + ( i + 1 );
        }

        // Now you can get the length of the first element
        int len2 = name[0].length(); // Correct. len2 has value 5
    }
}
