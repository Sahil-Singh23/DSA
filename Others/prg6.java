package DSA.Others;
import java.util.*;
public class prg6 {
    static int n;
    static float m,p[],w[];
    public static void greedyKn(){
        float profit = 0, max,u=m;
        int k=0;
        System.out.println("Items selected are: ");
        for(int i=0 ; i<n ; i++){
            max=0;
            for(int j=0 ; j<n; j++){
                float ra = p[j]/w[j];
                if(ra>max){
                    max = ra;
                    k=j;
                }
            }
            if(w[k]>u){
                System.out.println(k+1);
                System.out.println("The fraction selected is: "+ (u / w[k]));
                profit += (p[k] * (u / w[k]));
                break;
            }else{
                System.out.println(k+1);
                System.out.println("The fraction selected is: "+ 1);
                profit+= p[k];
                u-=w[k];
            }
            p[k]=0;
        }
        System.out.println("Maximum profit is :"+profit);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items ");
        n = sc.nextInt();
        
        p= new float[n];
        w= new float[n];
        System.out.println("Enter the profits: " );
        for(int i=0 ; i<n ; i++) p[i] = sc.nextFloat();
        System.out.println("Enter the weights: " );
        for(int i=0 ; i<n ; i++) w[i] = sc.nextFloat();
        System.out.println("Enter the knapsack capacity :");
        m = sc.nextFloat();
        greedyKn();
    }
}
