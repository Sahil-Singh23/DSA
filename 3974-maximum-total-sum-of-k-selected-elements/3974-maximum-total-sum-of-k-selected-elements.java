class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //top is the smallest ele

        for(int x:nums){
            minHeap.offer(x);
            if(minHeap.size()>k) minHeap.poll();
        }
        List<Integer> ls = new ArrayList<>();

        while(!minHeap.isEmpty()){
            int cur = minHeap.poll();
            ls.add(cur);
        }
        Collections.reverse(ls);
        long ans = 0;
        for(int cur: ls){
            if(mul>=1){
                ans+= (long)mul*cur;
            }else{
                ans+= cur;
            }
            mul--;
        }
        return ans;
    }
}