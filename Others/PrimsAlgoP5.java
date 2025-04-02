package DSA.DSA.Others;
import java.util.*;
public class PrimsAlgoP5 {
    static void prims(int [][] c, int n, int source){
        int ne=0 , a=0,b=0,min=0,mincost=0;
        int tvertex[] =  new int[n];
        tvertex[source] =1;
        while(ne < n-1){
            min = Integer.MAX_VALUE;
            for(int i=0 ; i<n ; i++){
                if(tvertex[i]==1)
                for(int j=0 ; j<n ; j++){
                    if(c[i][j] < min && tvertex[j]==0){
                        min=c[i][j];
                        a=i;
                        b=j;
                    }
                }
            }
            System.out.println("Pipeline from city "+a+" city "+b+" with cost "+min+" units");
        mincost+=min;
        tvertex[b]=1;
        ne++;
        }
        System.out.println("Cost of urban water supply "+mincost);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of cities : ");
        int n = sc.nextInt();
        int[][] c = new int[n][n];
        System.out.println("Enter the cost of laying pipeline between two cities: ");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                c[i][j] = sc.nextInt();
                if(c[i][j]==0){
                    c[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        System.out.print("Enter the source : ");
        int source = sc.nextInt();
        prims(c,n,source);
    }
}
