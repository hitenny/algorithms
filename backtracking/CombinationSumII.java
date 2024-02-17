//https://leetcode.com/problems/combination-sum-ii/submissions/1177550625/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combSum(result, new ArrayList<>(), target, 0, candidates, 0);

        return new ArrayList<>(result);
    }

    public void combSum(List<List<Integer>> result, List<Integer> comb, int target, int sum, int[] candidates, int j) {
        if(sum == target) {
            result.add(new ArrayList<>(comb));
        }

        if(sum > target) {
            return;
        }

        for(int i=j; i<candidates.length; i++) {
            if(i > j && candidates[i] == candidates[i-1]) continue;
            comb.add(candidates[i]);
            combSum(result, comb, target, sum+candidates[i], candidates, i+1);
            comb.remove(comb.size()-1);
        }
    }
}
