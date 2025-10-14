package DSA.labprgms;

import java.util.*;
public class P12_Hamiltonion {
    static int n;
    static int[][] graph;
    static int start;
    static void printPath(int[] next){
        System.out.print(start+" -> ");
        for(int i=next[start] ; i!=start ; i=next[i]){
            System.out.print(i+ " -> ");
        }
        System.out.println(start);
    }

    static void findCycle(int curr,int[]next,int visited){
        int temp[]= new int[n];
        if(visited==n && graph[curr][start]==1){
            printPath(next);
            return;
        }
        for(int i=0 ; i<n ; i++){
            if(graph[curr][i]==1 && next[i]==0 && i!=start){
                next[curr]=i;
                System.arraycopy(next, 0, temp, 0, n);
                findCycle(i, temp, visited+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of cities: ");
        n=sc.nextInt();
        graph= new int[n][n];
        int[] next = new int[n];
        System.out.println("Enter the adj matrix: ");
        for(int i=0; i<n; i++){
            for(int j=0 ; j<n ; j++){
                graph[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the source : ");
        start=sc.nextInt();
        findCycle(start, next, 1);
    }
}



