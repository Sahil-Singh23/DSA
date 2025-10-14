
import java.util.*;

public class P3 {
    static int count;
    static void merge(int[] a, int b[], int[] c){
        int p=b.length,q=c.length;
        int i=0,j=0,k=0;
        while(i<p && j<q){
            count++;
            if(b[i]<c[j]){
                a[k++]=b[i++];
            }else{
                a[k++]=c[j++];
            }
        }
        while(i<p) a[k++] = b[i++];
        while(j<q) a[k++] = c[j++];
    }
    static void mergesort(int[] a){
        if(a.length<=1) return;
        int p= a.length/2;
        int q= a.length-p;
        int[] b = new int[p];
        System.arraycopy(a, 0, b, 0, p);
        int[] c= new int[q];
        System.arraycopy(a, p, c, 0, q);
        mergesort(b);
        mergesort(c);
        merge(a, b, c);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter the number of elements :");
        int n = sc.nextInt();
        int a[]= new int[n];
        for(int i=0 ; i<n ; i++) a[i]= r.nextInt(10000);
        mergesort(a);
        System.out.println("Sorted elements are: ");
        for(int i=0 ; i<10 ; i++) System.out.print(a[i]+" ");
        System.out.println("\nBest case :"+(int)(n*Math.log(n)/Math.log(2)));
        System.out.println("Basic operations count: "+count);
        System.out.println("Worst case :"+(int)(n*Math.log(n)/Math.log(2)));     
    }
}
