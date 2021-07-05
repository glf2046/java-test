package alg;

public class PlusPlusProblem {
    public static void main(String[] args) {

        int i = 0;
        int b = ++i + ++i + ++i;
        System.out.println(b);

        int j = 0;
        //Note: For expression of "i++", there are two parts, one is the expression's value, the other is "i"'s value.
        //so here j++ as an expression, its value is 0, but as for j itself, its value is 1, but when assigning 'j++' to j,
        //it's assigning the expression's value to j, which is assigning '0' to j, so j instead is given a value of zero.
        j = j++;
        System.out.println(j);

        int a = 2;
        int c = 5;

        //same level operator's precedence and associativity is from right to left,
        //so first it does b/=2, get 3, then it does c+=3, get 8, then it does a*=8, get 16
        System.out.println(a*=c+=b/=2);
    }
}
