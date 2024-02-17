//https://leetcode.com/problems/combination-sum/submissions/1177530486

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        combinationSum(result, target, 0, new ArrayList<>(), candidates, 0);

        return result;
    }

    public void combinationSum(List<List<Integer>> result, int target, int sum, List<Integer> currentResult, int[] candidates, int j) {
        if(target == sum) {
            result.add(new ArrayList<>(currentResult));
        }

        if(sum > target) {
            return;
        }

        for(int i=j; i<candidates.length; i++) {
            currentResult.add(candidates[i]);
            combinationSum(result, target, sum+candidates[i], currentResult, candidates, i);
            currentResult.remove(currentResult.size()-1);
        }
    }
}
