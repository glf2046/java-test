package stringJoinTest;

import java.util.StringJoiner;

public class testMerge {
    public static void main(String[] args) {
        /* Passing comma(,) as delimiter and opening bracket
         * "(" as prefix and closing bracket ")" as suffix
         */
        StringJoiner mystring = new StringJoiner(",", "(", ")");

        mystring.add("Negan");
        mystring.add("Rick");
        mystring.add("Maggie");
        mystring.add("Daryl");

        System.out.println("First String: "+mystring);

        /* Passing hyphen(-) as delimiter and string "pre"
         * as prefix and string "suff" as suffix
         */
        StringJoiner myanotherstring = new StringJoiner("-", "pre", "suff");

        myanotherstring.add("Sansa");
        myanotherstring.add("Imp");
        myanotherstring.add("Jon");
        myanotherstring.add("Ned");

        System.out.println("Second String: "+myanotherstring);

        /* Merging both the strings
         * The important point to note here is that the output string will be
         * having the delimiter prefix and suffix of the first string (the string
         * which is calling the merge method of StringJoiner)
         */
        StringJoiner mergedString = mystring.merge(myanotherstring);
        System.out.println(mergedString);
    }
}
