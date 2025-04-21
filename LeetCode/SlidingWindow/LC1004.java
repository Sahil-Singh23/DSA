package DSA.LeetCode.SlidingWindow;

// Time: O(n), Space: O(1)

public class LC1004 {
    public static void main(String[] args) {
        LC1004Solution solution = new LC1004Solution();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = solution.longestOnes(nums, k);
        System.out.println("Maximum number of consecutive 1's after flipping at most " + k + " zeros: " + result);
    }
}

class LC1004Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int len = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;
            if (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            } else {
                len = Math.max(len, i - left + 1);
            }
        }

        return len;
    }
}
