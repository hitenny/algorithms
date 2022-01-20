//LC: https://leetcode.com/problems/binary-tree-right-side-view
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        Queue<TreeNode> queue = queue1;
        List<Integer> result = new ArrayList<>();
        
        if(root != null) {
            queue1.add(root);
        }
        
        while(!queue.isEmpty() || !queue2.isEmpty()) {
            while(!queue.isEmpty()) {
                TreeNode node = queue.remove();
                
                if(queue.isEmpty()) {
                    result.add(node.val);
                }
                
                if(node.left != null) {
                    queue2.add(node.left);
                }
                
                if(node.right != null) {
                    queue2.add(node.right);
                }
            }
            queue1 = queue;
            queue = queue2;
            queue2 = queue1;
        }
        return result;
    }
}
