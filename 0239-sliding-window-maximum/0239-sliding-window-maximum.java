class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[n-k+1];
        int j=0;
        for(int i =0 ; i< n ; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) dq.pollLast();
            dq.offer(i);
            if(i>=k-1){
                if(!dq.isEmpty() && dq.peekFirst()<(i-k+1))dq.pollFirst();
                ans[j++] = nums[dq.peekFirst()];
            }
        }return ans;
    }
}