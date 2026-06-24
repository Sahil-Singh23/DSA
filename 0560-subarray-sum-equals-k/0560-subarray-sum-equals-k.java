class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> hm = new HashMap<>();

        int preSum = 0;
        int cnt = 0;

        hm.put(0,1);
        for(int i= 0 ; i<n ; i++){
            preSum += nums[i];
            if(hm.containsKey(preSum-k)){
                cnt+=hm.get(preSum-k);
            }
            hm.put(preSum,hm.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}