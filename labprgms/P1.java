import java.util.*;
public class P1 {
    static int searchcount = 0;
    static int sortcount = 0;
    static int sequentialsearch(int[] a, int key){
        for(int i=0 ; i<a.length ; i++){
            searchcount++;
            if(a[i]==key){
                return i;
            }
        }
        return -1;
    }
    static void selectionsort(int[] a){
        for(int i=0 ; i<a.length ; i++){
            int p=i;
            for(int j=i+1 ; j<a.length ; j++){
                sortcount++;
                if(a[j]<a[p]) p=j;
            }
            if(p!=i){
                int temp = a[i];
                a[i] = a[p];
                a[p] = temp;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter the number of elements: (n > 5000)");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0 ; i<n ; i++) a[i] = r.nextInt(10000);
        int rnd = r.nextInt(n);
        System.out.println("Random number is: "+a[rnd]);
        System.out.println("Enter the key to search: ");
        int key = sc.nextInt();
        int index = sequentialsearch(a, key);
        if(index==-1){
            System.out.println("Key not found");
        }else{
            System.out.println("Key present at index: "+index);
        }
        System.out.println("Total number of basic search operations: "+searchcount);
        selectionsort(a);
        System.out.println("Sorted elements are ");
        for(int i=0 ; i<5 ; i++) System.out.println(a[i]);
        System.out.println("Total number of sort operations: "+sortcount);
    } 
}
