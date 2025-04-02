package DSA.DSA.LeetCode.SlidingWindow;

public class LC1358 {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int count = 0;
        int a = 0, b = 0, c = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == 'a') a++;
            else if (x == 'b') b++;
            else c++;
            
            if (a >= 1 && b >= 1 && c >= 1) {
                count += s.length() - i;
            }
            
            while (a >= 1 && b >= 1 && c >= 1) {
                x = s.charAt(left);
                if (x == 'a') a--;
                else if (x == 'b') b--;
                else c--;
                
                if (a >= 1 && b >= 1 && c >= 1) {
                    count += s.length() - i;
                }
                left++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        LC1358 solution = new LC1358();
        String testInput = "acbbcac";
        int result = solution.numberOfSubstrings(testInput);
        System.out.println("Number of valid substrings: " + result);
    }
}
