//LC: https://leetcode.com/problems/regular-expression-matching
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        
        dp[0][0] = true;
        for(int i=1; i<s.length()+1; i++) {
            dp[0][i] = false;
        }
        
        for(int i=1; i<p.length()+1; i++) {
            if(p.charAt(i-1) == '*') {
                dp[i][0] = dp[i-2][0];
            }
            else {
                dp[i][0] = false;    
            }
        }
        
        for(int i=1; i<=p.length(); i++) {
            for(int j=1; j<=s.length(); j++) {
                if(s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(i-1) == '*') {
                    if(dp[i-2][j]) {
                        dp[i][j] = dp[i-2][j];    
                    }
                    else {
                        if(s.charAt(j-1) == p.charAt(i-2) || p.charAt(i-2) == '.') {
                            dp[i][j] = dp[i][j-1];
                        }
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[p.length()][s.length()];
    }
}
