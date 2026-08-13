class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0 ; i<n ; i ++) adj.add(new ArrayList<>()) ;
        
        for (int i=1 ; i<n ; i ++){
            int par = parent [i];
            adj.get(par).add(i);
        }
        int depth[] = new int[n];
        depth[0]= 1;
        
        // for(int i=0 ; i< n ; i++){
        //     List<Integer> cur = adj.get(i);
        //     for(Integer val:cur) depth[val] = depth[i]+1;
        // }
        // int height = 1;
        // for(int cur:depth) height = Math.max(cur,height);

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int height = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> lis = adj.get(cur);
            for(Integer i: lis){
                depth[i]=depth[cur]+1;
                height = Math.max(height,depth[i]);
                q.offer(i);
            }
        }
        
        long ans = 0;
        for(int i=0 ; i<n ; i++){
            ans += (long)nums[i]*((long)height-depth[i]+1);
        } 

        return ans;
    }
}