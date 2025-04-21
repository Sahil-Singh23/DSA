package DSA.LeetCode.DynamicProg;
// Time Complexity -> O(n)
// Space Complexity -> O(n) + O(n) (memoization) OR O(1) for iterative approach

import java.util.Arrays;

public class Lc70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    // Iterative Fibonacci-style approach (space optimized)
    public int f(int n, int[] dp) {
        int n1 = 0;
        int n2 = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;
        }
        return ans;
    }

    // Memoization (Top-down DP)
    public int memo(int n, int[] dp) {
        if (n <= 2) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = memo(n - 2, dp) + memo(n - 1, dp);
        return dp[n];
    }

    // Main method for testing
    public static void main(String[] args) {
        Lc70 sol = new Lc70();
        int n = 5;
        System.out.println("Ways to climb " + n + " stairs: " + sol.climbStairs(n));
    }
}
