//LC: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while(low < high) {
            mid = (low+high)/2;
            if(nums[mid] < nums[high]) {
                //min is between low and mid
                high = mid;
            }
            else if(nums[mid] > nums[high]) {
                //min is between mid+1 and high since mid cannot be min
                low = mid+1;
            }
            else {
                //mid == high. so reduce high and continue
                high--;
            }
        }

        return nums[low];
    }
}
