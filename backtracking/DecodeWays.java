//LC: https://leetcode.com/problems/decode-ways
class Solution {
    public int numDecodings(String s) {
        if(s.isEmpty()) {
            return -1;
        }
        
        Map<Integer, Character> charMap = new HashMap<>();
        char ch = 'A';
        for(int i=0; i<26; i++) {
            charMap.put(i+1, ch);
            ch++;
        }
        
        Map<Integer, Integer> memo = new HashMap<>();
        return decode(s, 0, memo);
    }
    
    public int decode(String s, int index, Map<Integer, Integer> memo) {
        if(memo.containsKey(index)) {
            return memo.get(index);
        }
        
        if(index == s.length()) {
            return 1;
        }
        
        if(s.charAt(index) == '0') {
            return 0;
        }
        
        if(index == s.length()-1) {
            return s.charAt(index) == '0' ? 0 : 1;
        }
        
        
        int n = decode(s, index+1, memo);
        memo.put(index+1, n);
        int m = 0;
        if(index < s.length()-1 && Integer.valueOf(s.substring(index, index+2)) <= 26 && s.charAt(index) != '0') {
            m = decode(s, index+2, memo);
            memo.put(index+2, m);
        }
    
        return n+m;
    }
}
