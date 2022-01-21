//LC: https://leetcode.com/problems/longest-common-subsequence
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //int[][] dp = new int[text1.length()][text2.length()]; 
        //return LCS(text1, text2, 0, 0, dp);
        
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        
        for(int i=0; i<=text1.length(); i++) {
            for(int j=0; j<=text2.length(); j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                
                else if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                } 
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
    
    // Recursive Top Down approach. DFS with memoization
    public int LCS(String text1, String text2, int i, int j ,int[][] dp) {
        if(i == text1.length() || j == text2.length()) {
            return 0;
        }
        
        if(dp[i][j] > 0) {
            return dp[i][j];
        }
        
        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + LCS(text1, text2, i+1, j+1, dp);
            return dp[i][j];
        }
        else {
            dp[i][j] = Math.max(LCS(text1, text2, i+1, j, dp), LCS(text1, text2, i, j+1, dp));
            return dp[i][j];
        }
    }
}

