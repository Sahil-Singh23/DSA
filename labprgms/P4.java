package DSA.labprgms;

import java.util.*;
public class P4 {
    static int n;
    static int[][] cost= new int[10][10];
    static int[] indegree= new int[10];

    static void calculate(){
        for(int i=0 ; i<n ; i++){
            indegree[i]=0;
            for(int j=0 ; j<n ; j++){
                if(cost[j][i]==1) indegree[i]++;
            }
        }
    }
    static void sourceRemove(){
        
        int[] removed = new int[10];
        System.out.println("Topological ordering is ");
        for(int i=0 ; i<n ; i++){
            int j;
            calculate();
            for(j=0 ; j<n ; j++){
                if(removed[j]==0 && indegree[j]==0) break;
            }
            if(j==n){
                System.out.println("Graph is cyclic so no solution");
                return;
            }
            removed[j]=1;
            System.out.print(j+" ");
            for(int k=0 ; k<n ; k++) cost[j][k]=0;
        }
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of vertices :");
        n = sc.nextInt();
        System.out.println("Enter the cost matrix");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                cost[i][j] = sc.nextInt();
            }
        }
        sourceRemove();
    }
}
