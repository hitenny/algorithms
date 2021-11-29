//LC - https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        int i=0;
        int current = 0;
        while(i<nums.length-1) {
            if(nums[i] == current) {
                i++;
                continue;
            }
            
            int j=i+1;
            
            while(j<nums.length) {
                if(nums[j] == current) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                    break;
                }
                j++;
            }
            
            if(j == nums.length) {
                if(current == 0) {
                    current = 1;
                }
                else if(current == 1) {
                    current = 2;
                }
            }
        }
    }
}
