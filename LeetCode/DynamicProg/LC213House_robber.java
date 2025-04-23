package DSA.LeetCode.DynamicProg;

public class LC213House_robber {

    public static void main(String[] args) {
        LC213House_robber obj = new LC213House_robber();

        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {1, 2, 3};

        System.out.println("Max robbed (nums1): " + obj.rob(nums1)); // Output: 3
        System.out.println("Max robbed (nums2): " + obj.rob(nums2)); // Output: 4
        System.out.println("Max robbed (nums3): " + obj.rob(nums3)); // Output: 3
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return helper(nums, nums.length);
    }

    int helper(int[] nums, int n) {
        // Case 1: Rob from index 0 to n-2 (exclude last)
        int prev = 0;
        int cur = nums[0];
        int nex = -1;

        for (int i = 1; i < n - 1; i++) {
            int f = nums[i] + prev;
            int s = cur;
            nex = Math.max(f, s);
            prev = cur;
            cur = nex;
        }
        int val1 = cur;

        // Case 2: Rob from index 1 to n-1 (exclude first)
        prev = 0;
        cur = nums[1];
        nex = -1;

        for (int i = 2; i < n; i++) {
            int f = nums[i] + prev;
            int s = cur;
            nex = Math.max(f, s);
            prev = cur;
            cur = nex;
        }

        return Math.max(cur, val1);
    }
}

