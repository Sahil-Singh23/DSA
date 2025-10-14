import java.util.*;
public class P11_SubsetSum {
    static int[] subset,a;
    static int budget;
    static String[] categories;

    static void subsetSum(int index, int sum){
        if(sum==budget){
            System.out.println("Possible subset ");
            for(int i=0 ; i<a.length; i++){
                if(subset[i]==1) {
                    System.out.print(categories[i]+" : "+a[i]);
                    System.out.println();
                }
            }
            return;
        }
        if(sum>budget || index==a.length) return;
        subset[index]=1;
        subsetSum(index+1, sum+a[index]);
        subset[index]=0;
        subsetSum(index+1, sum);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of categories: ");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the categories and their corresponding budgets: (in increasing order)");
        int sum=0;

        a=new int[n];categories= new String[n]; subset=new int[n];
        for(int i=0 ; i<n ; i++){
            System.out.println("Enter the catogory name: ");
            categories[i]=sc.nextLine();
            System.out.println("Enter the category budget: ");
            a[i]= sc.nextInt();
            sc.nextLine();
            sum+= a[i];
        }
        System.out.println("Enter the event budget: ");
        budget = sc.nextInt();
        if(sum<budget || a[0]>budget){
            System.out.println("No possible subset - no event ");
        }else{
            subsetSum(0, 0);
        }
    }
}
