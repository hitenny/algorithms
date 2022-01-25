//LC: https://leetcode.com/problems/increasing-subsequences
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        findSequences(nums, new ArrayList<>(), 0, result);
        
        return new ArrayList<>(result);
    }
    
    public void findSequences(int[] nums, List<Integer> seq, int i, Set<List<Integer>> result) {
        if(seq.size() >= 2) {
           result.add(new ArrayList<>(seq));
        }
        if(i == nums.length) {
            return;
        }
        
        if(seq.isEmpty() || seq.get(seq.size()-1) <= nums[i]) {
            seq.add(nums[i]);
            findSequences(nums, seq, i+1, result);
            seq.remove(seq.size()-1);
        }
        
        findSequences(nums, seq, i+1, result);
    }
}
