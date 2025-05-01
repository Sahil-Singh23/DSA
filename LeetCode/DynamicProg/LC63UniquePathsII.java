package DSA.LeetCode.DynamicProg;


import java.util.Arrays;

public class LC63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] r : dp) Arrays.fill(r, -1);
        // return memo(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, dp);
        // return tabu(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, dp);
        return spac(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    int memo(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (grid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = (memo(grid, i - 1, j, dp) + memo(grid, i, j - 1, dp));
    }

    int tabu(int[][] grid, int n, int m, int[][] dp) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (grid[i][j] == 1) dp[i][j] = 0;
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n][m];
    }

    int spac(int[][] grid, int n, int m) {
        int[] prev = new int[m + 1];
        for (int i = 0; i <= n; i++) {
            int[] temp = new int[m + 1];
            for (int j = 0; j <= m; j++) {
                if (grid[i][j] == 1) temp[j] = 0;
                else if (i == 0 && j == 0) temp[j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = temp[j - 1];
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[m];
    }

    // ---------------- Main method for testing ----------------
    public static void main(String[] args) {
        LC63UniquePathsII sol = new LC63UniquePathsII();
        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int result = sol.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Unique Paths (Space Optimized): " + result);
    }
}
