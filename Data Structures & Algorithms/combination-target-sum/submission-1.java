class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        return result;    
    }

    public void backtrack(int[] candidates, int target, int start, int currentSum, List<Integer> current){
        if(currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(currentSum > target){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            current.add(candidates[i]);

            backtrack(candidates, target, i, candidates[i] + currentSum, current);

            current.remove(current.size() - 1);
        }
    }
}
