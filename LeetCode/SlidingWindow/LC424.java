package DSA.DSA.LeetCode.SlidingWindow;

public class LC424 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AABABBA";
        int k = 1;
        int result = solution.characterReplacement(s, k);
        System.out.println("Longest substring length: " + result);
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int maxf = 0, left = 0, len = 0, ch = 0;
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash[c - 'A']++;
            maxf = Math.max(maxf, hash[c - 'A']);
            ch = (i - left + 1) - maxf;

            if (ch > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            ch = (i - left + 1) - maxf;
            if (ch <= k) {
                len = i - left + 1;
            }
        }
        return len;
    }
}
