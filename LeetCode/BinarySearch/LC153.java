package DSA.DSA.LeetCode.BinarySearch;
/*
 * Problem: Find the minimum element in a rotated sorted array (no duplicates)
 * LeetCode: 153. Find Minimum in Rotated Sorted Array
 * 
 * 🔍 Approach: Binary Search
 * -------------------------------------
 * 1. If the current search range [low..high] is sorted, nums[low] is the minimum.
 * 2. Eliminate the sorted half (as its minimum is already known).
 * 3. Always compare and store the minimum found so far.
 * 4. Optimization: The moment you detect that nums[low] <= nums[high],
 *    the minimum is nums[low] — break early.
 * 
 * ⏱️ Time Complexity: O(log n)
 * 📦 Space Complexity: O(1)
 */

 public class LC153 {

    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;

            // Entire subarray is sorted
            if (nums[low] <= nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }

            // Left half is sorted
            if (nums[mid] >= nums[low]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } 
            // Right half is sorted
            else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    // Driver code
    public static void main(String[] args) {
        LC153 sol = new LC153();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {11, 13, 15, 17};

        System.out.println("Min of nums1: " + sol.findMin(nums1)); // Output: 0
        System.out.println("Min of nums2: " + sol.findMin(nums2)); // Output: 11
    }
}
