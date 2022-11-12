//LC: https://leetcode.com/problems/word-break-ii/submissions/841803047
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, wordDict, memo);
    }

    public List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        if(s.isEmpty()) {
            result.add("");
            return result;
        }

        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> out = dfs(s.substring(word.length()), wordDict, memo);
                for(String o : out) {
                    result.add(word + (o.isEmpty() ? "" : " ") + o);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    
}
