class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        findPathSums(root, targetSum, path);
        return result;
    }
    
    public void findPathSums(TreeNode root, int targetSum, List<Integer> path) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            if(targetSum == root.val) {
                List<Integer> temp = new ArrayList<>(path);
                result.add(temp);  
                temp.add(root.val);
            }
            return;
        }
        
        path.add(root.val);
        findPathSums(root.left, targetSum-root.val, path);
        findPathSums(root.right, targetSum-root.val, path);
        if(path.size() > 0) {
            path.remove(path.size()-1);    
        }
    }
}
