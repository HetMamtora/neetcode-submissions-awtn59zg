class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] candidates, int target, int start, int currentSum, List<Integer> current){
        if(currentSum == target){
            result.add(new ArrayList<>(current));
        }
        if(currentSum > target){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }

            current.add(candidates[i]);
            backtrack(candidates, target, i + 1, currentSum + candidates[i], current);
            current.remove(current.size() - 1);
        }
    }
}
