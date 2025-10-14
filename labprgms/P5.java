package DSA.labprgms;

import java.util.*;
public class P5 {
    static void prims(int n, int[][] c,int source){
        int ne = 0;
        int[] vis = new int[n];
        int a=0,b=0, min=0,mincost=0;
        vis[source]=1;
        while(ne<n-1){
            min= Integer.MAX_VALUE;
            for(int i=0 ; i<n ; i++){
                if(vis[i]==1){
                    for(int j=0 ; j<n ; j++){
                        if(c[i][j]<min && vis[j]==0){
                            min=c[i][j];
                            a=i;
                            b=j;
                        }
                    }
                }
            }
            vis[b]=1;
            System.out.println("The cost to go from city "+a+" to city "+b+ " is "+ min);
            mincost+=min;
            ne++;
        }
        System.out.println("Total mst "+mincost);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cities: ");
        int n = sc.nextInt();
        System.out.println("Enter the cost matrix: ");
        int [][] c= new int[n][n];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                c[i][j] = sc.nextInt();
                if(c[i][j]==0){
                    c[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        System.out.println("Enter the source: ");
        int source= sc.nextInt();
        prims(n, c, source);
    }
}
