import java.util.*;
public class P2 {
    static int count=0;
    static int partion(int l,int r,int[] a){
        int pivot = a[l];
        int i=l;
        int j=r+1;
        while(i<j){
            do{
                i++;
                count++;
            }while(i<=r && a[i]<=pivot);
            do{
                j--;
                count++;
            }while(j>=l && a[j]>pivot);
            if(i<j){
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp = a[l];
        a[l]=a[j];
        a[j]=temp;
        return j;
    }
    public static void quickSort(int l,int r, int[] a){
        if(l>=r) return; //* 
        int s = partion(l, r, a);
        quickSort(l, s-1, a);
        quickSort(s+1, r, a);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Random r= new Random();
        System.out.println("Enter the number of elements : ");
        int n= sc.nextInt();
        int[] a = new int[n];
        for(int i=0 ; i<n ; i++) a[i]= r.nextInt(10000);
        quickSort(0, n-1, a);
        System.out.println("Sorted elements are");
        for(int i=0 ; i<10; i++) System.out.print(a[i]+" ");

        
        System.out.println("\nBest case: "+ (int)(n*Math.log(n)/Math.log(2)));
        System.out.println("Total number of basic opeartions: "+count);
        System.out.println("Worst case: "+ (n*n));
    }
}
