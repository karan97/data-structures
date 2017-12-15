import java.util.*;
import java.io.*;
import java.lang.*;

class RodCutting {
    public static void main(String[] args) throws IOException {
        int n = 8;
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price, n));
    }

    public static int cutRod(int[] price, int n) {
        int m = price.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(j >= i) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}