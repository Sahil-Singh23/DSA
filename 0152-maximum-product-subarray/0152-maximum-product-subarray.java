class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int pre = 1;
        int suf = 1;
        int max = -(int)1e9;

        for(int i=0 ; i<n ; i++){
            pre*=nums[i];
            max = Math.max(max,pre);
            if(pre==0) pre = 1;
        }
        for(int i=n-1 ; i>=0 ; i--){
            suf*=nums[i];
            max = Math.max(max,suf);
            if(suf==0) suf = 1;
        }
        return max;
    }
}