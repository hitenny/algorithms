//LC: https://leetcode.com/problems/path-sum-iii/
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        return pathSum(root, targetSum, 0, prefixSum);
    }
    
    public int pathSum(TreeNode root, int targetSum, int pathSum, Map<Integer, Integer> prefixSum) {
        if(root == null) {
            return 0;
        }
        
        pathSum += root.val;
        
        int res = prefixSum.getOrDefault(pathSum-targetSum, 0);
        prefixSum.put(pathSum, prefixSum.getOrDefault(pathSum, 0) + 1);
        
        res += pathSum(root.left, targetSum, pathSum, prefixSum);
        res += pathSum(root.right, targetSum, pathSum, prefixSum);
        prefixSum.put(pathSum, prefixSum.get(pathSum) - 1);
        
        return res;
        
    }
}
