class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        int visited[] = new int[n];
        List<List<Integer>> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lis.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            lis.get(edge[0]).add(edge[1]);
            lis.get(edge[1]).add(edge[0]);
        }
        int cnt = 0;
        for(int i=0 ; i<n ; i++){
            if(visited[i]==0){
                int counts[] = new int[2];
                dfs(i,visited,lis,counts);
                int v = counts[0];
                int e = counts[1]/2;

                if(e== (v*(v-1))/2) cnt++;
            } 
        }
        return cnt;
    }
    private void dfs(int i, int[] visited, List<List<Integer>> lis,int counts[]){
        
        visited[i]=1;
        counts[0]++;
        counts[1]+=lis.get(i).size();

        for(int cur:lis.get(i)){
            if(visited[cur]==0){
                dfs(cur,visited,lis,counts);
            }
        }

    }
}