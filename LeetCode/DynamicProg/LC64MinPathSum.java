package DSA.LeetCode.DynamicProg;

public class LC64MinPathSum {
    public int minPathSum(int[][] grid) {
        //int[][] dp = new int[grid.length][grid[0].length];
        // for(int[] r:dp) Arrays.fill(r,-1);
        // return memo(grid, grid.length-1, grid[0].length-1 ,dp);
        //return tabu(grid, grid.length-1, grid[0].length-1 ,dp);
        return spac(grid, grid.length-1, grid[0].length-1);
    }

    int memo(int[][] grid, int i, int j,int[][] dp){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0 ){
            return (int)1e9;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int up = grid[i][j]+ memo(grid, i-1, j,dp);
        int left = grid[i][j]+ memo(grid, i, j-1,dp);
        return dp[i][j]= Math.min(up,left);
    }

    int tabu(int[][] grid, int n, int m,int[][] dp){
        for(int i=0 ; i<=n ; i++){
            for(int j=0 ; j<=m ; j++){
                if(i==0 && j==0) dp[i][j]=grid[i][j];
                else{
                    int up = (int)1e9;
                    int left = (int)1e9;
                    if(i>0) up= grid[i][j]+dp[i-1][j];
                    if(j>0) left = grid[i][j]+dp[i][j-1];
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[n][m];
    }

    int spac(int[][] grid, int n, int m){
        int[] a = new int[m+1];
        for(int i=0 ; i<=n ; i++){
            int[] temp = new int[m+1];
            for(int j=0 ; j<=m ; j++){
                if(i==0 && j==0) temp[j]=grid[i][j];
                else{
                    int up = (int)1e9;
                    int left = (int)1e9;
                    if(i>0) up= grid[i][j]+a[j];
                    if(j>0) left = grid[i][j]+temp[j-1];
                    temp[j] = Math.min(up,left);
                }
            }
            a = temp;
        }
        return a[m];
    }

    public static void main(String[] args) {
        LC64MinPathSum sol = new LC64MinPathSum();
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        int result = sol.minPathSum(grid);
        System.out.println("Minimum Path Sum: " + result);
    }
}
