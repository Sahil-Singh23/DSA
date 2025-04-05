package DSA.DSA.LeetCode.SlidingWindow;
import java.util.Arrays;
// Time: O(n), Space: O(1)

public class LC3 {
    public static void main(String[] args) {
        LC33 solution = new LC33();
        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of Longest Substring Without Repeating Characters: " + result);
    }
}

class LC33 {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int left = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hash[(int) c] != -1) {
                left = Math.max(left, hash[(int) c] + 1);
            }
            hash[(int) c] = i;
            len = Math.max(len, i - left + 1);
        }

        return len;
    }
}

