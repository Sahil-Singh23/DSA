package DSA.LeetCode.Arrays;

import java.util.HashSet;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();

        for (int i : nums) {
            hs.add(i);
        }
        int max = 1;
        for (Integer h : hs) {
            if (!hs.contains(h - 1)) {
                int cur = h;
                int len = 1;
                while (hs.contains(cur + 1)) {
                    len++;
                    cur++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC128 solution = new LC128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence: " + solution.longestConsecutive(nums));
    }
}
