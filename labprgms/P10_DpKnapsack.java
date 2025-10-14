package DSA.labprgms;

import java.util.*;
public class P10_DpKnapsack {
    static int n,m,p[],w[];
    static void dPknapsack(){
        int [][] v = new int[n+1][m+1];

        for(int i=0 ; i<=n ; i++){
            for(int j=0 ; j<=m ; j++){
                if(i==0 || j==0)v[i][j]=0;
                else if(w[i]<j) v[i][j]=v[i-1][j];
                else v[i][j] = Math.max(v[i-1][j],p[i]+v[i-1][j-w[i]]);
                System.out.println(v[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Max profit is "+v[n][m]);
        System.out.println("Items selected are: ");
        while(n!=0){
            if(v[n][m]!=v[n-1][m]){
                System.out.print(n+" ");
                m-=w[n];
            }n--;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        n = sc.nextInt();
        p = new int[n];
        w = new int[n];
        System.out.println("Enter the profits: ");
        for(int i=0 ; i<n ; i++) p[i] = sc.nextInt();
        System.out.println("Enter the weights: ");
        for(int i=0 ; i<n ; i++) w[i] = sc.nextInt();
        System.out.println("Enter the capacity of the knapsack: ");
        m = sc.nextInt();
        dPknapsack();
    }
}
