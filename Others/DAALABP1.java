package DSA.DSA.Others;
import java.util.Random;
import java.util.Scanner;
public class DAALABP1 {
    static int searchCount=0;
    static int sortCount=0;
    public static int sequentialSearch(int a[], int key){
        for(int i=0 ;i<a.length ; i++){
            searchCount++;
            if(a[i]==key) return i;
        }
        return -1;
    }
    public static void selectionSort(int a[], int key){

        for(int i =0 ; i<a.length ; i++){
            int p=i;
            for(int j=i+1 ; j<a.length ; j++){
                sortCount++;
                if(a[j]<a[p]) p=j;
            }
            if(p!=i){
                int temp=a[i];
                a[i]=a[p];
                a[p]=temp;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter the number of elements (n > 5000) : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0 ; i<n ; i++) a[i]= r.nextInt(10000);
        int rnd = r.nextInt(a.length);
        System.out.println("Random number is "+a[rnd]);
        System.out.println("Enter the key to search: ");
        int key = sc.nextInt();
        int index = sequentialSearch(a, key);
        if(index!=-1){
            System.out.println("Key found at index: "+index);
        }else{
            System.out.println("Key not found" );
        }
        System.out.println("Number of basic operations for searching is : "+searchCount);
        selectionSort(a, key);
        System.out.println("Sorted numbers are");
        for(int i=0 ; i<5 ; i++) System.out.println(a[i]);
        System.out.println("Number of basic operations for sorting is : "+sortCount);
    }
}
