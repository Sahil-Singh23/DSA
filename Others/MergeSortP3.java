package DSA.DSA.Others;
import java.util.Scanner;
import java.util.Random;
public class MergeSortP3 {
    static int count=0;
    static void merge(int b[], int[] c, int[] a){
        int i=0, j=0, k=0;
        int p=b.length;
        int q=c.length;
        while(i<p && j<q){
            count++;
            if(b[i]<c[j]){
                a[k++]=b[i++];
            }
            else{
                a[k++]=c[j++];
            }
        }
        while(i<p){
            a[k++]=b[i++];
        }
        while(j<q){
            a[k++]=c[j++];
        }
    }
    static void mergeSort(int[] a){
        int n=a.length;
        if(n>1){
            int p=n/2;
            int q=n-p;
            int[] b = new int[p];
            int[] c = new int[q];
            System.arraycopy(a, 0, b, 0, p);
            System.arraycopy(a,p,c,0,q);
            mergeSort(b);
            mergeSort(c);
            merge(b,c,a);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0 ; i<n ; i++) a[i]=r.nextInt(10000);
        mergeSort(a);
        System.out.println("Sorted numbers are ");
        for(int i=0 ; i<5 ; i++) System.out.print(a[i]+" ");
        System.out.println("\nBest case : "+(int)(n*Math.log(n)/Math.log(2)));
        System.out.println("Number of basic operations : "+ count);
        System.out.println("Worst case : "+(int)(n*Math.log(n)/Math.log(2)));
    }
}