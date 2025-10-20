import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            Map<Integer, Integer> freq = new HashMap<>();

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
            }

            boolean haveAll = true;
            for (int i = 0; i < k; i++) {
                if (!freq.containsKey(i)) {
                    haveAll = false;
                    break;
                }
            }

            // Case 1: Already has MEX = k
            if (haveAll && !freq.containsKey(k)) {
                System.out.println(0);
                continue;
            }

            // Case 2: MEX should be 0 -> remove all 0s
            if (k == 0) {
                System.out.println(freq.getOrDefault(0, 0));
                continue;
            }

            // Case 3: General case
            int missing = 0;
            for (int i = 0; i < k; i++) {
                if (!freq.containsKey(i)) missing++;
            }

            int removeK = freq.getOrDefault(k, 0);

            // Fix: take the max, not sum
            System.out.println(Math.max(missing, removeK));
        }
        sc.close();
    }
}
