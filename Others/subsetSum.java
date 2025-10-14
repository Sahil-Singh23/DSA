import java.util.*;
public class subsetSum {
    static int[] x, w;
    static int d;
    static String[] categories;
    public static void subsetSumm(int index, int sum){
        if(sum==d){
            System.out.println("Subset possible");
            for(int i =0 ; i<index ; i++){
                if(x[i]==1){
                    System.out.println(categories[i] + " : " + w[i]);
                    System.out.println();
                }
            }return;
        }
        if(index==w.length || sum>d){
            return;
        }
        x[index]=1;
        subsetSumm(index+1,sum+w[index]);
        x[index]=0;
        subsetSumm(index+1,sum);

    }
    public static void main(String[] args){
        int sum=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of categories :");
        int n = sc.nextInt();
        sc.nextLine();
        w = new int[n]; x = new int[n]; categories = new String[n];
        System.out.println("Enter the categories in increasing order of the budget ");
        for(int i=0 ; i<n ; i++){
            System.out.println("Enter the category name: ");
            categories[i] = sc.nextLine();
            System.out.println("Enter the category budget: ");
            w[i] = sc.nextInt();
            sc.nextLine();
            sum+=w[i];
        }
        System.out.println("Enter the budget for the event: ");
        d= sc.nextInt();
        if(sum<d || w[0]>d){
            System.out.println("No subset possible - Unable to host the events");
        }
        else{
            subsetSumm(0,0);
        }
    }
}
