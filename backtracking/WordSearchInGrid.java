
//LC: https://leetcode.com/problems/word-searchclass Solution {
    public boolean exist(char[][] board, String word) {
        
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                boolean visited[][] = new boolean[board.length][board[0].length];
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int k, boolean visited[][]) {
        
        if(k == word.length()) {
            return true;
        }
        
        if(i < 0 || j < 0 || i > board.length-1 || j > board[i].length-1 ||  visited[i][j]) {
            return false;
        }
        
        if(board[i][j] != word.charAt(k)) {
            return false;
        }
        
        visited[i][j] = true;
        boolean ret = dfs(board, i, j+1, word, k+1, visited) ||
        dfs(board, i+1, j, word, k+1, visited) ||
        dfs(board, i-1, j, word, k+1, visited) ||
        dfs(board, i, j-1, word, k+1, visited);
        visited[i][j] = false;
        
        return ret;
    }
}
