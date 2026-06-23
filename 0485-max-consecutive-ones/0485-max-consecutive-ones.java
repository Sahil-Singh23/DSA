class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0,m=0;
        for(int i =0 ; i<nums.length ; i++){
            if(nums[i]==1){
                cnt++;
                if(cnt>m) m=cnt;
            }
            else{
                cnt=0;
            }
        }
        return m;
    }
}