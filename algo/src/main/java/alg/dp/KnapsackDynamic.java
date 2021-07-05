package alg;

/**
 * 0-1（完全）背包问题
 */
public class KnapsackDynamic {
    public static void main(String[] args) {
        int n = 5; //item count
        int m = 10; //total weight
        int[] w = {2, 2, 6, 5, 4};
        int[] p = {6, 3, 5, 4, 6};
        boolean[] x = new boolean[n];
        knapsackDynamic(w, p, n, m, x);
    }

    private static void knapsackDynamic(int[] w, int[] p, int n, int m, boolean[] x) {
        int i, j;
        int v;
        int[][] opt = new int[n+1][m+1];
        for(i = 0; i <= n; i++){
             opt[i][0] = 0;
        }
        for(i = 0; i <= m; i++){
            opt[0][i] = 0;
        }
        for(i = 1; i <= n; i++){
            for(j = 1; j <=m; j++){
                if(j < w[i-1])
                    opt[i][j] = opt[i-1][j];
                 if(j >= w[i-1]) {
                     opt[i][j] = Math.max(opt[i - 1][j - w[i - 1]] + p[i - 1], opt[i - 1][j]);
                }
            }
        }
        j=m;
        for(i = n; i >0; i--){
            if(opt[i][j] > opt[i-1][j]){
                x[i-1] = true;
                j -= w[i-1];
            }
        }
        v = opt[n][m];
        System.out.println(v);

        for(boolean b : x){
            System.out.print(b + ",  ");
        }
        System.out.println("");
        System.out.println("#######################################");
        for(i = 0; i <= n; i++){
            for(j = 0; j <=m; j++){
                System.out.print(opt[i][j] + ",  ");
            }
            System.out.println();
        }
    }
}
