class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] sumGrid = new int[r][c];
        
        sumGrid[0][0] = grid[0][0];
        for(int i=1; i<r; i++) {
            sumGrid[i][0] = sumGrid[i-1][0] + grid[i][0];
        }
        for(int j=1; j<c; j++) {
            sumGrid[0][j] = sumGrid[0][j-1] + grid[0][j];
        }
        
        for(int i=1; i<r; i++) {
            for(int j=1; j<c; j++) {
                sumGrid[i][j] = grid[i][j] + Math.min(sumGrid[i-1][j], sumGrid[i][j-1]); 
            }
        }
        
        return sumGrid[r-1][c-1];
    }
}
