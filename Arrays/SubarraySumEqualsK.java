//LC: https://leetcode.com/problems/subarray-sum-equals-k
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int result = 0;
        sumMap.put(0, 1);
        
        int curSum = 0;
        for(int i=0; i<nums.length; i++) {
            curSum += nums[i];
            result += sumMap.getOrDefault(curSum-k, 0);
            
            sumMap.put(curSum, sumMap.getOrDefault(curSum, 0)+1);
        }
        return result;
    }
}
