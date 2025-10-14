package DSA.labprgms;

import java.util.*;
public class P6 {
    static int n;
    static float p[],w[],m;

    static void greedKnapsack(){
        float u=m,max=0;
        int k=-1;
        int profit=0;
        System.out.println("Items selected are: ");
        
        for(int i=0 ; i<n ; i++){
            max=0;
            for(int j=0; j<n ; j++){
                float maxRatio = p[j]/w[j];
                if(maxRatio>max){
                    max=maxRatio;
                    k=j;
                } 
            }
            if(w[k]>u){
                System.out.println(k+1);
                System.out.println("Fraction selected is "+(u/w[k]));
                profit+= (u/w[k])*p[k];
                break;
            }else{
                System.out.println(k+1);
                System.out.println("Fraction selected is 1");
                profit+= p[k];
                u-=w[k];
            }
            p[k]=0;
        }
        System.out.println("Max total profit is :"+profit);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        n=sc.nextInt();
        p= new float[n];
        w= new float[n];
        System.out.println("Enter the profits of the items: ");
        for(int i=0 ; i<n ; i++) p[i]= sc.nextFloat();
        System.out.println("Enter the weights of the items: ");
        for(int i=0 ; i<n ; i++) w[i]= sc.nextFloat();
        System.out.println("Enter the capacity of the knapsack: ");
        m = sc.nextFloat();
        greedKnapsack();
    }
}
