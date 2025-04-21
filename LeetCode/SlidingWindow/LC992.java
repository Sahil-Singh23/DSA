package DSA.LeetCode.SlidingWindow;

// Time: O(n), Space: O(n)

public class LC992 {
    public static void main(String[] args) {
        LC992Solution solution = new LC992Solution();
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        int result = solution.subarraysWithKDistinct(nums, k);
        System.out.println("Subarrays with exactly " + k + " distinct integers: " + result);
    }
}

class LC992Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {
        if (k == 0) return 0;

        int count = 0;
        int left = 0;
        java.util.HashMap<Integer, Integer> hm = new java.util.HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

            while (left < nums.length && hm.size() > k) {
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0) hm.remove(nums[left]);
                left++;
            }

            count += i - left + 1;
        }

        return count;
    }
}
