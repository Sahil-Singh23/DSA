class Solution {
    public int maxDigitRange(int[] nums) {
        
        int n = nums.length;
        int maxRange = Integer.MIN_VALUE;
        int[] ranges = new int[n];

        for(int i=0 ; i<n ; i++){
            int cur = nums[i];
            int smallest = 10;
            int largest = -1;
            while(cur>0){
                int digit = cur%10;
                smallest = Math.min(smallest,digit);
                largest = Math.max(largest,digit);
                cur/=10;
            }
            int range = largest - smallest;
            ranges[i] =  range;
            maxRange = Math.max(range,maxRange);
        }
        int ans = 0;
        for(int i=0 ; i<n ; i++){
            if(ranges[i]==maxRange) ans += nums[i];
        }
        return ans;
    }
}