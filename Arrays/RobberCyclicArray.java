//LC: https://leetcode.com/problems/house-robber-ii

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(findMaxSimple(nums, 0, nums.length-1), findMaxSimple(nums, 1, nums.length));
        
    }
    
    int findMaxSimple(int[] nums, int start, int end) {
        int include = nums[start];
        int exclude = 0;
        
        for(int i=start+1; i<end; i++) {
            int previ = include;
            include = nums[i]+exclude;
            exclude = Math.max(exclude, previ);
        }
        
        return Math.max(include, exclude);
    }
}
