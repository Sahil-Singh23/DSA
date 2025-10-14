package DSA.labprgms;

import java.util.*;
public class P8_Dijakstras {
    static void dijakstra(int source, int[][] cost, int n){
        int[] tvertex= new int[n];
        int[] dist= new int[n];
        int min,u=0,v,i,j;
        System.arraycopy(cost[source], 0, dist, 0, n);
        tvertex[source]=1;
        dist[source]=0;

        for(i=0 ; i<n-1 ; i++){
            min= Integer.MAX_VALUE;
            for(j=0 ; j<n ; j++){
                if(tvertex[j]==0 && dist[j]<min){
                    min=dist[j];
                    u=j;
                }
            }
            tvertex[u]=1;
            for(v=0 ; v<n ; v++){
                if(tvertex[v]==0 && cost[u][v]!=Integer.MAX_VALUE){
                    dist[v] = Math.min(dist[v],dist[u]+cost[u][v]);
                }
            }
        }
        System.out.println("The minimum cost from source is");
        for(int k=0 ; k<n ; k++){
            System.out.println("From "+source+" to "+k+1+" city is "+dist[k]);
        }        
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of cities ");
        int n= sc.nextInt();
        int[][] cost= new int[n][n];
        System.out.println("Enter the cost between cities : ");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                cost[i][j] = sc.nextInt();
                if(cost[i][j]==0) cost[i][j]=Integer.MAX_VALUE;
            }
        }
        System.out.println("Enter the source city: ");
        int source= sc.nextInt();
        dijakstra(source, cost, n); 
    }
}
