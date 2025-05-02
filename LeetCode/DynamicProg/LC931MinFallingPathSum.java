package DSA.LeetCode.DynamicProg;


public class LC931MinFallingPathSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        int result = sol.minFallingPathSum(matrix);
        System.out.println("Minimum Falling Path Sum: " + result);
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        return space(matrix);
        // int n = matrix.length;
        // int[][] dp = new int[n][n];
        // return tabu(matrix,dp);
        // for(int[] row : dp) Arrays.fill(row,(int)1e9);
        // int min=(int)1e9;
        // for(int i=0 ; i<matrix[0].length ; i++){
        //     min = Math.min(min,memo(matrix,i,0,dp));
        // }return min;
    }

    int memo(int[][] nums, int index, int row, int[][] dp) {
        if(row == nums.length - 1){
            return nums[row][index];
        }
        if(dp[row][index] != (int)1e9){
            return dp[row][index];
        }
        int down = (int)1e9;
        int right = (int)1e9;
        int left = (int)1e9;
        if(index > 0) left = nums[row][index] + memo(nums, index - 1, row + 1, dp);
        if(index < nums[0].length - 1) right = nums[row][index] + memo(nums, index + 1, row + 1, dp);
        down = nums[row][index] + memo(nums, index, row + 1, dp);
        return dp[row][index] = Math.min(left, Math.min(down, right));
    }

    int tabu(int[][] nums, int[][] dp) {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0){
                    dp[i][j] = nums[i][j];
                } else {
                    int down = (int)1e9;
                    int right = (int)1e9;
                    int left = (int)1e9;
                    if(j > 0) left = nums[i][j] + dp[i - 1][j - 1];
                    if(j < n - 1) right = nums[i][j] + dp[i - 1][j + 1];
                    down = nums[i][j] + dp[i - 1][j];
                    dp[i][j] = Math.min(left, Math.min(down, right));
                }
            }
        }

        int min = (int)1e9;
        for(int i = 0 ; i < n ; i++){
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

    int space(int[][] nums) {
        int n = nums.length;
        int[] cur = new int[n];

        for(int i = 0 ; i < n ; i++){
            int[] temp = new int[n];
            for(int j = 0 ; j < n ; j++){
                if(i == 0){
                    temp[j] = nums[i][j];
                } else {
                    int down = (int)1e9, right = (int)1e9, left = (int)1e9;
                    if(j > 0) left = nums[i][j] + cur[j - 1];
                    if(j < n - 1) right = nums[i][j] + cur[j + 1];
                    down = nums[i][j] + cur[j];
                    temp[j] = Math.min(left, Math.min(down, right));
                }
            }
            cur = temp;
        }

        int min = (int)1e9;
        for(int i = 0 ; i < n ; i++){
            min = Math.min(min, cur[i]);
        }
        return min;
    }
}
