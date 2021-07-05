package alg;

public class HanoiTest {

    private int steps = 1;

    private void move(int n, char from , char to){
        System.out.println("Step: " + steps++ + ", moving number " + n + " from " + from + " to " + to);
    }

    private void hanoi(int n, char from, char to, char middle){
        if(n < 1)
            return;
         if(n == 1){
            move(n, from, to);
         } else{
             hanoi(n - 1, from, middle, to);
             move(n, from, to);
             hanoi(n-1, middle, to, from);
         }
    }

    public static void main(String[] args) {
        int n = 10;
        new HanoiTest().hanoi(n, 'A', 'C', 'B');
    }
}
