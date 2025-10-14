package DSA.labprgms;

import java.util.*;
public class P7Krushkals {
    static void krushkals(int [][] c, int n){
        int[] p = new int[n];
        Arrays.fill(p, -1);

        int a=0,b=0,u=0,v=0,min,mincost=0,ne=0;
        while(ne<n-1){
            min=Integer.MAX_VALUE;
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){
                    if(c[i][j]<min){
                        min=c[i][j];
                        a=u=i;
                        b=v=j;
                    }
                }
            }
            while(p[u]!=-1) u=p[u];
            while(p[v]!=-1) v=p[v];

            if(u!=v){
                System.out.println("The cost to travel from "+a+" to "+b+" is "+min);
                mincost+=min;
                ne++;
                if(u<v) p[v]=u;
                else p[u]=v;
            }
            c[a][b]=c[b][a]=Integer.MAX_VALUE;
        }
        System.out.println("The total minimum cost is : "+mincost);
        
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.println("Enter the cost matrix: ");
        int[][] cost = new int[n][n];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                cost[i][j]= sc.nextInt();
                if(cost[i][j]==0) cost[i][j]=Integer.MAX_VALUE;
            }
        }
        krushkals(cost, n);
    }
}
