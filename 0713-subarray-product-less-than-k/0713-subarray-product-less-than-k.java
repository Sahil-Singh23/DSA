class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        
        int n = nums.length;
        long prod = 1;
        int cnt = 0 ;
        int l = 0;

        for(int i =0 ; i<n ; i++){
            prod*= nums[i];
            while(prod>=k){
                prod/=nums[l];
                l++;
            }
            cnt+=(i-l+1);
            
        }
        return cnt;
    }
}