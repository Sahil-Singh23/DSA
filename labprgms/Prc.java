package DSA.labprgms;

public class Prc {
    static int n;
    static int[][] graph;
    static int start;

    static void printPath(int[] next){
        System.out.print(start+" -> ");
        for(int i=next[start]; i!=start ; i=next[i]){
            System.out.print(i+" -> ");
        }
        System.out.println(start);        
    }
    static void findCycle(int curr,int[] next, int visited){
        int[] temp = new int[n];
        if(visited==n && graph[curr][start]==1){
            printPath(next);
            return;
        }
        for(int i=0 ; i<n; i++){
            if(graph[curr][i]==1 && next[i]==0 && i!=start){
                next[curr]=i;
                System.arraycopy(next,0,temp,0,n);
                findCycle(i,temp,visited+1);
            }
        }
    }

    static void dijakstra(int cost[][] , int n, int source){
        int tvertex[]= new int[n];
        int[] dist= new int[n];
        int min=0,u=0;
        System.arraycopy(cost[source], 0, dist, 0, n);
        tvertex[source]=1;
        dist[source]=0;
        for(int i=0 ;i<n-1 ; i++){
            min=Integer.MAX_VALUE;
            for(int j=0; j<n ; j++){
                if(tvertex[j]==0 && dist[j]<min){
                    min=dist[j];
                    u=j;
                }
            }
            tvertex[u]=1;
            for(int v=0 ; v<n; v++){
                if(tvertex[v]==0 && cost[u][v]!=Integer.MAX_VALUE){
                    dist[v]=Math.min(dist[v],dist[u]+cost[u][v]);
                }
            }
        }
        System.out.println(" The shortest travel time ");
        for(int v=0; v<n; v++)
            System.out.println("from "+source+" city to "+v+" city is " + dist[v]);
        
    }
}
