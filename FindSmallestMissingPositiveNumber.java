class Solution {
    public int firstMissingPositive(int[] nums) {
        //Set numbers outside range as infinity
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        
        /*
        Now array contains only positive numbers within the range 1 to n
        For each value multiply the value at the index(represented by that value)
        by -1. Essentially, we are making all values as negative. */
        for(int i=0; i<nums.length; i++) {
            int absNum = Math.abs(nums[i]);
            if(absNum > 0 && absNum <= nums.length) {
                if(nums[absNum-1] == Math.abs(nums[absNum-1])) {
                    nums[absNum-1] = -1 * nums[absNum-1];    
                }
            }
        }
        
        //Iterate through the array and find first positive number. 
        //Its index+1 is the missing number
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        
        //Else return next positive number
        return nums.length+1;
    }
}
