package DSA.DSA.LeetCode.SlidingWindow;

/*  
   The problem requires finding the number of subarrays with exactly `k` odd numbers.  
   To solve this optimally in O(n), we use the "at most" sliding window technique:  
   
   1️⃣ Find the number of subarrays with **at most `k`** odd numbers.  
   2️⃣ Find the number of subarrays with **at most `k - 1`** odd numbers.  
   3️⃣ Subtract (1) - (2) to get the count of subarrays with exactly `k` odd numbers.  

   In the `helper` function:  
   - We iterate over the array while maintaining a window with `sum ≤ goal`.  
   - If `sum > goal`, we move `left` forward to reduce the sum.  
   - For each valid window, we add `(right - left + 1)` to `count`,  
     as all subarrays ending at `right` are valid.  
*/

public class LC1248 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        LC1248 solution = new LC1248();
        System.out.println(solution.numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, count = 0, sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += (nums[right] & 1);
            while (sum > goal) {
                sum -= (nums[left] & 1);
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
