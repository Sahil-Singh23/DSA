package DSA.LeetCode.SlidingWindow;

/*  
   The problem requires finding the number of subarrays with sum exactly equal to `goal`.  
   To solve this optimally in O(n), we use the "at most" sliding window technique:  
   
   1️⃣ Find the number of subarrays with sum **≤ goal**.  
   2️⃣ Find the number of subarrays with sum **≤ goal - 1**.  
   3️⃣ Subtract (1) - (2) to get the count of subarrays with sum exactly equal to `goal`.  

   In the `helper` function:  
   - We iterate over the array while maintaining a window with `sum ≤ goal`.  
   - If `sum > goal`, we move `left` forward to reduce the sum.  
   - For each valid window, we add `(right - left + 1)` to `count`,  
     as all subarrays ending at `right` are valid.  
*/

public class LC930 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        Solutionq solution = new Solutionq();
        System.out.println(solution.numSubarraysWithSum(nums, goal));
    }
}

class Solutionq {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }
    
    private int helper(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, count = 0, sum = 0, right = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
