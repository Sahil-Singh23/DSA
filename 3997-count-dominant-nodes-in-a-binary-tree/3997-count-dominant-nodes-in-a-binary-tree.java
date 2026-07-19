/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countDominantNodes(TreeNode root) {
               if(root==null)return 0;
        
        int[] ans = new int[1];

        dfs(root,ans);
        return ans[0];
    }
    private int dfs(TreeNode root ,int[] ans){
        if(root.left == null && root.right == null){
            ans[0]++;
            return root.val;
        }

        int l = -1;
        int r = -1;
        if(root.left!=null) l = dfs(root.left,ans);
        if(root.right!=null) r = dfs(root.right,ans);

        //if(l==-1 && r==-1) return root.val;
        if(root.val>=l && root.val>=r) {
            ans[0]++; 
            return root.val;
        }else{
            return Math.max(r,l);
        }
    }
}