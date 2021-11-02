class Solution {
    public int rob(int[] nums) {
        int[] incSum = new int[nums.length];
        int[] excSum = new int[nums.length];
        
        incSum[0] = nums[0];
        excSum[0] = 0;
        
        for(int i=1; i<nums.length; i++) {
            incSum[i] = nums[i] + excSum[i-1];                //Max sum at index i including i = nums[i] + sum excluding previous index
            excSum[i] = Math.max(incSum[i-1], excSum[i-1]);   //Max sum at index i excluding i = max of sum excluding previous index and  sum including previous index
        }
        
        return Math.max(incSum[nums.length-1], excSum[nums.length-1]);
    }
}
