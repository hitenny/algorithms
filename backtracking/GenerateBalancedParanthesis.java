//LC: https://leetcode.com/problems/generate-parentheses
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParanthesis("", 0, 0, n, result);
        
        return result;
    }
    
    public void generateParanthesis(String p, int open, int close, int n, List<String> result) {
        if(p.length() == 2*n) {
            result.add(p);
            return;
        }
        
        if(open < n) {
            generateParanthesis(p+"(", open+1, close, n, result);
        }
        
        if(close < open) {
            generateParanthesis(p+")", open, close+1, n, result);
        }
    }
}
