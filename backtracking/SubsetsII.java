//https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        subset(result, new ArrayList<>(), nums, 0);

        return new ArrayList<>(result);

    }

    public void subset(List<List<Integer>> result , List<Integer> sub, int[] nums, int j) {
        if(!result.contains(sub))
            result.add(new ArrayList<>(sub));

        for(int i=j; i<nums.length; i++) {
            sub.add(nums[i]);
            subset(result, sub, nums, i+1);
            sub.remove(sub.size()-1);
        }
    }
}
