package DSA.LeetCode.DynamicProg;

import java.util.Arrays;

public class LC198_HouseRobber {
    
    // Main method to test the solution
    public static void main(String[] args) {
        LC198_HouseRobber solver = new LC198_HouseRobber();
        
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};

        System.out.println("Max robbed (space optimized) from nums1: " + solver.rob(nums1)); // Output: 4
        System.out.println("Max robbed (space optimized) from nums2: " + solver.rob(nums2)); // Output: 12
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int ans = spac(nums,nums.length-1);
        return ans;
    }
    public int memo(int[] nums, int n,int[] dp){
        if(n==0) return dp[n]= nums[0];
        if(n==1) return dp[n]= Math.max(nums[n],nums[n-1]);
        if(dp[n]!=-1) return dp[n];
        int f =  nums[n]+memo(nums,n-2,dp);
        int sec = memo(nums,n-1,dp);
        return dp[n]= Math.max(f,sec);
    }
    public int tabu(int[] nums,int n, int[] dp){
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[0]);

        for(int i=2 ; i<=n ; i++){
            int f = nums[i]+dp[i-2];
            int s = dp[i-1];
            dp[i] = Math.max(f,s);
        }return dp[n];
    }
    public int spac(int[] nums,int n){
        int old = nums[0];
        int cur = Math.max(nums[1],nums[0]);
        int nex = 0;
        for(int i =2 ; i<=n ; i++){
            int f = nums[i]+old;
            int s = cur;
            nex=Math.max(f,s);
            old=cur;
            cur=nex;
        }return cur;
    }
}
