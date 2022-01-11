//LC - https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int result[] = new int[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            int maxSeq = 1;    
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    maxSeq = Math.max(maxSeq, result[j]+1);
                }
            }
            result[i] = maxSeq;
        }
        
        int maxSeq = 1;
        for(int i=0; i<nums.length; i++) {
            maxSeq = Math.max(maxSeq, result[i]);
        }
        
        return maxSeq;
    }
}
