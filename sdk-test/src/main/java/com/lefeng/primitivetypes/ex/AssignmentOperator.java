package com.lefeng.primitivetypes.ex;

public class AssignmentOperator {
    public static void main(String[] args) {
        int i1;
        //Assignment operator's associativity is right-to-left, so statement like "int a = b = 10"
        //it will first starting the assignment from the right side, say "b = 10"
        //and the "=" operator's actual operation is to assign value of "10" to literal "b" and then returns the lvalue(left value) referring to the left operand.
        System.out.println(i1 = 200);
    }
}
