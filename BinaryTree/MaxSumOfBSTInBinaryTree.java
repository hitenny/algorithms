class Solution {
    int maxBstSum = 0;
    
    class BSTNodeInfo {
        boolean isBst;
        int sum;
        int max;
        int min;
    }
    
    public int maxSumBST(TreeNode root) {
        maxSumBst(root);
        return maxBstSum;
    }
    
    private BSTNodeInfo maxSumBst(TreeNode root) {
        //All leaf nodes are bst
        if(root == null) {
            BSTNodeInfo info = new BSTNodeInfo();
            info.sum = 0;
            info.isBst = true; //leaf node is bst
            info.max = Integer.MIN_VALUE;
            info.min = Integer.MAX_VALUE;
            return info;
        }    
        
        BSTNodeInfo left = maxSumBst(root.left);
        BSTNodeInfo right = maxSumBst(root.right);
        
        BSTNodeInfo current = new BSTNodeInfo();
        
        /* 
        current node is bst if left subtree is bst and right subtree is bst
        and node val is less than min value in right subtree and greater than
        max value in left subtree
        */
        current.isBst = left.isBst && right.isBst && 
            root.val < right.min && root.val > left.max;
        
        //Set tree's max value in current node as max of current node value and max of left subtree and right subtree
        current.max = Math.max(root.val, Math.max(left.max, right.max));
      
        //Set tree's min value in current node as min of current node value and min of left subtree and right subtree
        current.min = Math.min(root.val, Math.min(right.min, left.min));
      
        //calculate sum of all nodes value till now
        current.sum = root.val + left.sum + right.sum;
        
        //Consider this sum only if subtree is bst
        if(current.isBst) {
            maxBstSum = Math.max(maxBstSum, current.sum);
        }
        
        return current;
    }
}
