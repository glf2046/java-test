package alg.dp;

public class LongestCommonString {

    public static void main(String[] args) {
        String s1 = "xyxzyxyzzy";
        String s2 = "xzyzxyzxyzxy";
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        System.out.println(lcs(a, b));
    }

    private static int lcs(char[] a, char[] b) {
        int n = a.length;
        int m = b.length;

        int[][] L = new int[n + 1][m + 1];
        int[][] S = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            L[i][0] = 0;
        }

        for (int i = 0; i <= m; i++) {
            L[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                    S[i][j] = 1;
                } else if (L[i - 1][j] > L[i][j - 1]) {
                    L[i][j] = L[i - 1][j];
                    S[i][j] = 2;
                } else {
                    L[i][j] = L[i][j - 1];
                    S[i][j] = 3;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(L[i][j] + "    ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("#############################################");

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(S[i][j] + "    ");
            }
            System.out.println();
        }

        return Math.max(S[n + 1][m + 1], L[n + 1][m + 1]);
    }
}

