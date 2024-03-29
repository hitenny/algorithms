public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    height(result, root);
    return result;
}
 
// traverse the tree bottom-up recursively
private int height(List<List<Integer>> list, TreeNode root){
    if(root==null)
        return -1;
 
    int left = height(list, root.left);
    int right = height(list, root.right);
    int curr = Math.max(left, right)+1;
 
    // the first time this code is reached is when curr==0,
    //since the tree is bottom-up processed.
    if(list.size()<=curr){
        list.add(new ArrayList<Integer>());
    }
 
    list.get(curr).add(root.val);
 
    return curr;
}
