import java.util.*;
public class hamilton {
    static int n;
    static int[][] a;
    static int source;

    static void path(int succ[]){
        System.out.println(source+ "--> ");
        for(int j=succ[source]; j!=0 ; j=succ[j]){
            System.out.print(j+"-> ");            
        }
        System.out.println(source);
    }

    static void ckt(int st, int succ[], int visited){
        int[] temp = new int[n];

        if(visited==n && a[st][source]==1){
            path(succ);
            return;
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
        ckt(0, succ, 0);
    }
}
