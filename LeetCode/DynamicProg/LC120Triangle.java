package DSA.LeetCode.DynamicProg;
import java.util.*;

public class LC120Triangle {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        
        int result = sol.minimumTotal(triangle);
        System.out.println("Minimum Total Path Sum: " + result);
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //int dp[][] = new int[triangle.size()][triangle.size()];
        // for(int[] r : dp) Arrays.fill(r,-1);
        // return memo(triangle,0,0,dp);
        //return tabu(triangle,dp);
        return spac(triangle);
    }

    int memo(List<List<Integer>> triangle, int i, int row, int[][] dp) {
        if(row == triangle.size() - 1) {
            return triangle.get(row).get(i);
        }
        if(dp[row][i] != -1) return dp[row][i];

        int cur = triangle.get(row).get(i) + memo(triangle, i + 1, row + 1, dp);
        int nex = triangle.get(row).get(i) + memo(triangle, i, row + 1, dp);

        return dp[row][i] = Math.min(cur, nex);
    }

    int tabu(List<List<Integer>> triangle, int[][] dp) {
        int n = triangle.size() - 1;
        for(int i = 0; i <= n; i++) dp[n][i] = triangle.get(n).get(i);

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i + 1][j]; 
                int dia = triangle.get(i).get(j) + dp[i + 1][j + 1]; 
                dp[i][j] = Math.min(down, dia);
            }
        }
        return dp[0][0];
    }

    int spac(List<List<Integer>> triangle) {
        int[] a = new int[triangle.size()];
        int n = triangle.size() - 1;
        for(int i = 0; i <= n; i++) a[i] = triangle.get(n).get(i);

        for(int i = n - 1; i >= 0; i--) {
            int[] temp = new int[triangle.size()];
            for(int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + a[j]; 
                int dia = triangle.get(i).get(j) + a[j + 1]; 
                temp[j] = Math.min(down, dia);
            }
            a = temp;
        }
        return a[0];
    }
}
