// https://leetcode.com/problems/binary-tree-maximum-path-sum/

class Solution {
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        calcSum(root);
        return maxSum;
    }
    
    private int calcSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int l = calcSum(root.left);  //return current max sum of left sub-tree
        int r = calcSum(root.right); //return current max sum of right sub-tree
            
        int sum = root.val + l + r;  //sum of left, right and root
        int curMaxSum = Math.max(root.val, root.val + Math.max(l, r));  // Take max of root or root + max of left or right sub-tree
        maxSum = Math.max(maxSum, Math.max(curMaxSum, sum));            // Take max of all sums
        
        return curMaxSum;
    }
}
