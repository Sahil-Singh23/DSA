class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int visited[] = new int[n];
        int count =0;
        for(int i = 0 ; i<n ; i++){
            if(visited[i]==0){
                visited[i] = 1;
                count++;
                dfsSolver(i,isConnected,visited,n);
            }
        }
        return count;
    }
    void dfsSolver(int ind, int isConnected[][], int visited[],int n){
        
        for(int i=0 ; i<n ; i++){
            if(i!=ind && isConnected[ind][i] == 1 && visited[i]==0){
                visited[i] = 1;
                dfsSolver(i,isConnected,visited,n);
            }
        }
    }
}