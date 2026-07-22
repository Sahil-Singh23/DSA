class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        if(n==0) return new int[]{-1,-1};

        int lb = n;
        int ub = n;
        int high = n-1;
        int low = 0;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }else if(nums[mid]>=target){
                lb = mid;
                high = mid-1;
            }
        }
        high = n-1;
        low = 0;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>target){
                ub = mid;
                high = mid-1;
            }else if(nums[mid]<=target){
                low = mid+1;
            }
        }
        if(lb==ub) return new int[]{-1,-1};
        return new int[]{lb,ub-1};
    }
}