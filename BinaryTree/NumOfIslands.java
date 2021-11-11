class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                
                if(grid[i][j] == '1') {
                    
                    if(!visited[i][j]) {
                        islands++;
                        dfs(grid, i, j, visited);   
                    }
                }
            }
        }
        
        return islands;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        for(int m=i-1; m<=i+1; m++) {
            for(int n=j-1; n<=j+1; n++) {
                if(isValid(grid, m, n) && ((i==m || j==n) && !(i==m && j==n)) && !visited[m][n]) {
                    visited[m][n] = true;
                    if(grid[m][n] == '1') {
                        dfs(grid, m, n, visited);    
                    }
                }
            }
        }
    }
    
    private boolean isValid(char[][] grid, int i, int j) {
        return i>=0 && i<grid.length && j >=0 && j<grid[0].length;
    }
}
