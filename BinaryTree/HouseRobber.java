//LC: https://leetcode.com/problems/house-robber-iii
class Solution {
    public int rob(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        int[] res = robdfs(root);
        
        
        return Math.max(res[0], res[1]);
    }
    
    public int[] robdfs(TreeNode root) {
        if(root == null) {
            return new int[2];
        }
        
        int[] l = robdfs(root.left); 
        int[] r = robdfs(root.right);
        
        int[] res = new int[2];
        res[0] = l[1] + r[1] + root.val;
        res[1] = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return res;
    }
}
