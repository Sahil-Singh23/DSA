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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root==null ) return ans;
        ArrayList<Integer> temp = new ArrayList<>();
        toLeaves(root,ans,temp);
        return ans;
    }
    public void toLeaves(TreeNode root,List<String> ans,ArrayList<Integer> temp){
        if(root.left==null && root.right == null){
            temp.add(root.val);
            ans.add(toString(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        if(root.left!=null){
            toLeaves(root.left,ans,temp);
        }if(root.right!=null){
            toLeaves(root.right,ans,temp);
        }
        temp.remove(temp.size()-1);
    }
    public String toString(ArrayList<Integer> temp){
        
        String ans = "";
        for(int i = 0 ; i<temp.size()-1 ; i++){
            ans+= Integer.toString(temp.get(i));
            ans+="->";
        }
        ans+=Integer.toString(temp.get(temp.size()-1));
        return ans;
    }

}