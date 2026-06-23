class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        
        for(int i=0 ; i<n ; i++){
            hm.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }

        for(List<Integer> ls: hm.values()){
            int size = ls.size();
            long pre[] = new long[size];
            pre[0]=ls.get(0);
            for(int i=1 ; i<size ; i++) pre[i]=pre[i-1]+ls.get(i);

            for(int k=0 ; k<size ; k++){
                int cur = ls.get(k);
                long left = (long)cur*k - (k==0?0:pre[k-1]);
                long right = (pre[size-1]-pre[k])-((long)cur*(size-k-1));
                ans[cur]= left+right;
            }
        }
        return ans;
    }
}