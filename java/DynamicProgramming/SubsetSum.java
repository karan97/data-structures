import java.util.*;
import java.io.*;
import java.lang.*;

class SubsetSum {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        System.out.println(makeChange(15, coins) ? "Possible" : "Not Possible");
    }

    public static boolean makeChange(int m, int[] coins) {
        int n = coins.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i < m + 1; i++) {
            dp[0][i] = false;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}