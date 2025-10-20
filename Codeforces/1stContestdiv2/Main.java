import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            
            // Calculate prefix maximums
            long[] prefixMax = new long[n];
            prefixMax[0] = a[0];
            for (int i = 1; i < n; i++) {
                prefixMax[i] = Math.max(prefixMax[i - 1], a[i]);
            }
            
            long cost = 0;
            // Only need to check even indices (0-based) as valleys
            for (int i = 0; i < n; i += 2) {
                long upperBound;
                if (i == 0) {
                    // First element should be less than second element
                    upperBound = prefixMax[1] - 1;
                } else {
                    // Valley should be less than the previous peak's prefix max
                    upperBound = prefixMax[i - 1] - 1;
                }
                
                if (a[i] > upperBound) {
                    cost += a[i] - upperBound;
                }
            }
            
            out.println(cost);
        }
        out.flush();
    }
}