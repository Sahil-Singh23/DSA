package DSA.LeetCode.DynamicProg;


import java.util.Arrays;

public class Gfggeekstrainging {

    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        int dp[][] = new int[n][4];
        for (int[] r : dp) Arrays.fill(r, -1);
        return memo(arr, n - 1, 3, dp);
        // return tab(arr, dp);
        // return space(arr);
    }

    int memo(int[][] arr, int day, int last, int[][] dp) {
        if (day == -1) {
            return 0;
        }
        if (dp[day][last] != -1) return dp[day][last];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) max = Math.max(arr[day][i] + memo(arr, day - 1, i, dp), max);
        }
        return dp[day][last] = max;
    }

    int tab(int[][] arr, int[][] dp) {
        int n = arr.length;
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    int space(int[][] arr) {
        int n = arr.length;
        int t0 = 0, t1 = 0, t2 = 0;

        for (int i = 0; i < n; i++) {
            int a = arr[i][0] + Math.max(t1, t2);
            int b = arr[i][1] + Math.max(t0, t2);
            int c = arr[i][2] + Math.max(t0, t1);
            t0 = a; t1 = b; t2 = c;
        }

        return Math.max(t0, Math.max(t1, t2));
    }

    public static void main(String[] args) {
        Gfggeekstrainging sol = new Gfggeekstrainging();

        int[][] arr = {
            {8, 7, 3},
            {10, 6, 3},
            {1, 1, 4},
            {10, 2, 9},
            {2, 10, 6},
            {4, 3, 6},
            {3, 6, 9},
            {7, 8, 8},
            {3, 3, 10},
            {5, 2, 10}
        };

        int ans = sol.maximumPoints(arr);
        System.out.println(ans); // Output: 77
    }
}

