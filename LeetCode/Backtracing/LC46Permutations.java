package DSA.LeetCode.Backtracing;

import java.util.*;

public class LC46Permutations {

    public static void main(String[] args) {
        LC46Permutations obj = new LC46Permutations();
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = obj.permute(nums);
        System.out.println("All permutations of " + Arrays.toString(nums) + ":");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans);
        return ans;
    }

    private void solve(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            ans.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            solve(index + 1, nums, ans);
            swap(index, i, nums); // backtrack
        }
    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
