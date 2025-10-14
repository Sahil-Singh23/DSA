import java.util.*;
public class hamil {
    static int n;
    static int[][] a;
    static int source;

    public static void path(int[] succ){
        System.out.print(source +" --> " );
        for(int j=succ[source] ; j!=0 ; j=succ[j]){
            System.out.print(j+ " --> ");
        }
        System.out.println(source);   
    }
    public static void ckt(int st, int[] succ, int visited){
        int[] temp = new int[n];
        if(visited==n && a[st][cource]==1){
            path(succ);
        }
        for(int i=0 ; i<n ; i++){
            if(a[st][i]==1 && succ[i]==0){
                succ[st]=i;
                System.arraycopy(succ, 0, temp, 0, n);
                ckt(i, temp, visited+1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cities: ");
        n = sc.nextInt();
        a = new int[n][n];
        int []succ = new int[n];
        System.out.println("Enter the roads between delivery locations/adjacency matrix");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                a[i][j] = sc.nextInt();
            }
        }
        ckt(source=0, succ, 1);
    }
}
