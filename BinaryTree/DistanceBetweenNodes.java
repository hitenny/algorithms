int findDist(Node root, int a, int b) {
        Node lca = lca(root, a, b);
        return distance(lca, a, 0) + distance(lca, b, 0);
    }
    
    public int distance(Node node, int c, int d) {
        
        if(node == null) {
            return -1;
        }
        
        if(node.data == c) {
            return d;
        }    
        int l = distance(node.left, c, d+1);
        //System.out.println(d);
        if(l != -1)
            return l;
            
        return distance(node.right, c, d+1);
    }
    
    public Node lca(Node root, int a, int b) {
        if(root == null || root.data == a || root.data == b) {
            return root;
        }
        
        Node l = lca(root.left, a, b);
        Node r = lca(root.right, a, b);
        
        if(l != null && r != null) {
            return root;
        }
        
        return l == null ? r : l;
    }
