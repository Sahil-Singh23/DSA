// it is very similar to house robber (we can convert it to house robber)
//the logic here is first we find the max value in the array then we 
// create another array (points), iterate through the nums array and for every occurance of nums[i] we add it to the points array 
// then we iterate through the points array where we either take an index or skip it, if we take the index f = we add it prev (we skipped the prev element) or we skip the current element in the case we s = curr (we did nt skip the prev one ) and then for the current element in points we see whats the max f or s and then set prev = cur, cur = nex for the next iteration 
// at the end we return cur value.



package DSA.LeetCode.DynamicProg;

import java.util.HashMap;

public class LC740_DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0; 
        if (nums.length == 1) return nums[0];
        
        // Step 1: Use a HashMap to track the total sum (points) for each number
        HashMap<Integer, Integer> pointsMap = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            pointsMap.put(num, pointsMap.getOrDefault(num, 0) + num);
            max = Math.max(max, num); // Track the maximum number
        }
        
        // Step 2: Dynamic programming setup, similar to previous solution
        int prev = 0, cur = 0;
        
        // Step 3: Iterate through all possible numbers (from 0 to max)
        for (int i = 0; i <= max; i++) {
            if (pointsMap.containsKey(i)) {
                int f = pointsMap.get(i) + prev; // Take current value
                int s = cur; // Skip current value
                int nex = Math.max(f, s); // Max of taking or skipping
                prev = cur;
                cur = nex;
            }
        }
        
        // Step 4: Return the result (maximum points)
        return cur;
    }

    public static void main(String[] args) {
        // Test the deleteAndEarn method
        LC740_DeleteAndEarn solution = new LC740_DeleteAndEarn();

        // Example test case
        int[] nums = {3, 4, 2};
        int result = solution.deleteAndEarn(nums);
        System.out.println("Max points: " + result);  // Output: 6
        
        // You can add more test cases here
        int[] nums2 = {2, 2, 3, 3, 3, 4};
        int result2 = solution.deleteAndEarn(nums2);
        System.out.println("Max points: " + result2);  // Output: 12
    }
}
