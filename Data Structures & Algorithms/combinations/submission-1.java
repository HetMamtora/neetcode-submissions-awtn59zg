class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, new ArrayList<>());
        return result;
    }

    public void backtrack(int n, int k, int start, List<Integer> current){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i <= n - (k - current.size()) + 1; i++){
            current.add(i);
            backtrack(n, k, i+1, current);
            current.remove(current.size() - 1);
        }
    }
}