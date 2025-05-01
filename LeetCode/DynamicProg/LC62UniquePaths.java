package DSA.LeetCode.DynamicProg;

import java.util.Arrays;

public class LC62UniquePaths {
    public int uniquePaths(int m, int n) {
        // int dp[][] = new int[m][n];
        // for(int[] row: dp) Arrays.fill(row,-1); 
        // //return memo(m-1,n-1,m-1,n-1,dp);
        // return tabu(m-1,n-1,dp);
        if(m==1 || n==1 ) return 1;
        return space(m-1,n-1);
    }

    public int memo(int m, int n, int i, int j, int[][] dp){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0 || i > m || j > n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = memo(m, n, i-1, j, dp) + memo(m, n, i, j-1, dp);
    }

    public int tabu(int m, int n, int[][] dp){
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public int space(int m, int n){
        int[] prev = new int[n+1];
        Arrays.fill(prev, 1);
        int left = 1;
        for(int i = 1; i <= m; i++){
            int[] temp = new int[n+1];
            for(int j = 1; j <= n; j++){
                temp[j] = prev[j] + left;
                left = temp[j];
            }
            prev = temp;
            left = 1;
        }
        return prev[n];
    }

    // ---------------- Main method for testing ----------------
    public static void main(String[] args) {
        LC62UniquePaths sol = new LC62UniquePaths();
        int m = 3, n = 7;
        int result = sol.uniquePaths(m, n);
        System.out.println("Unique Paths from (0,0) to (" + (m-1) + "," + (n-1) + "): " + result);
    }
}
