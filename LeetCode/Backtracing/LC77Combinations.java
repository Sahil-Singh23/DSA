package DSA.LeetCode.Backtracing;

import java.util.*;

public class LC77Combinations {

    public static void main(String[] args) {
        LC77Combinations obj = new LC77Combinations();
        int n = 4, k = 2;

        List<List<Integer>> result = obj.combine(n, k);
        System.out.println("Combinations of " + n + " choose " + k + ":");
        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, 1, k, ans, new ArrayList<>());
        return ans;
    }

    void solve(int n, int index, int k, List<List<Integer>> ans, ArrayList<Integer> temp) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (index > n) {
            return;
        }

        // Include the current index
        temp.add(index);
        solve(n, index + 1, k, ans, temp);

        // Exclude the current index (backtrack)
        temp.remove(temp.size() - 1);
        solve(n, index + 1, k, ans, temp);
    }
}

