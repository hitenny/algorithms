class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> pathNodes = new ArrayList<>();
        findNode(root, target, pathNodes);
        
        List<Integer> levelNodes = new ArrayList<>();
        for(int i=0; i<pathNodes.size(); i++) {
            //While finding k levels, do not cross the previous node, because it would be wrong distance. Hence sending it as block
            findKLevelDown(pathNodes.get(i), k-i, i == 0 ? null : pathNodes.get(i-1), levelNodes);
        }
            
        return levelNodes;
    }
    
    public void findKLevelDown(TreeNode node, int k, TreeNode block, List<Integer> levelNodes) {
        if(node == null || node == block || k < 0) {
            return;
        }    
        
        if(k == 0) {
            levelNodes.add(node.val);   
        }
        
        findKLevelDown(node.left, k-1, block, levelNodes);
        findKLevelDown(node.right, k-1, block, levelNodes);
    }
    
    public boolean findNode(TreeNode root, TreeNode target, List<TreeNode> pathNodes) {
        if(root == null) {
            return false;
        }
        
        if(root == target) {
            //Node is found, add to list and return true
            pathNodes.add(root);
            return true;
        }
        
        boolean fil = findNode(root.left, target, pathNodes);
        /*
        * If node is found in left subtree, add the node to list and return true
        */
        if(fil) {
            pathNodes.add(root);
            return true;
        }
        
        /*
        * If node is found in right subtree, add the node to list and return true
        */
        boolean fir = findNode(root.right, target, pathNodes);
        if(fir) {
            pathNodes.add(root);
            return true;
        }
        
        return false;
    }
}
