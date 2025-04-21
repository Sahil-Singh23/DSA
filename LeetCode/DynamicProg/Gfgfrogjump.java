package DSA.LeetCode.DynamicProg;

public class Gfgfrogjump {
    public static void main(String[] args) {
        Gfgfrogjump obj = new Gfgfrogjump();
        int[] height = {30, 10, 60, 10, 60, 50};
        System.out.println("Min Cost: " + obj.minCost(height));
    }

    int minCost(int[] height) {
        int[] dp = new int[height.length]; 
        // Arrays.fill(dp, -1);
        for (int i = 0; i < height.length; i++) dp[i] = -1;
        return space(height, height.length - 1);
    }

    // Memoization Approach
    int memo(int[] height, int n, int[] dp) {
        if (n == 0) {
            dp[0] = 0;
            return dp[0];
        }
        if (dp[n] != -1) return dp[n];
        int first = Math.abs(height[n] - height[n - 1]) + memo(height, n - 1, dp);
        if (n > 1) {
            int second = Math.abs(height[n] - height[n - 2]) + memo(height, n - 2, dp);
            dp[n] = Math.min(first, second);
            return dp[n];
        }
        dp[n] = first;
        return dp[n];
    }

    // Tabulation Approach
    int tab(int[] height, int n, int[] dp) {
        dp[0] = 0;
        if (n == 0) return 0;
        dp[1] = Math.abs(height[1] - height[0]);
        for (int i = 2; i <= n; i++) {
            int first = Math.abs(height[i] - height[i - 1]) + dp[i - 1];
            int sec = Math.abs(height[i] - height[i - 2]) + dp[i - 2];
            dp[i] = Math.min(first, sec);
        }
        return dp[n];
    }

    // Space Optimized Approach
    int space(int[] height, int n) {
        if (n == 0) return 0;
        int prev = 0;
        int cur = Math.abs(height[1] - height[0]);
        int nex = -1;

        for (int i = 2; i <= n; i++) {
            int f = Math.abs(height[i] - height[i - 1]) + cur;
            int s = Math.abs(height[i] - height[i - 2]) + prev;
            nex = Math.min(f, s);
            prev = cur;
            cur = nex;
        }
        return cur;
    }
}

