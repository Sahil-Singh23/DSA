package DSA.labprgms;

import java.util.*;
public class P9_Floyd {
    static void floyd(int[][] d, int n){
        for(int i=0; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                for(int k=0 ; k<n ;k++){
                    d[i][j] = Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        int d[][] = new int[n][n];
        System.out.println("Enter the cost matrix: ");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                d[i][j]= sc.nextInt();
                if(d[i][j] ==0 && i!=j) d[i][j]= (int)1e8;
            }
        }
        floyd(d, n);

        System.out.println("Shortest travel time between all cities: ");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                System.out.print(d[i][j]+" ");
            }System.out.println();
        }
    }
}
