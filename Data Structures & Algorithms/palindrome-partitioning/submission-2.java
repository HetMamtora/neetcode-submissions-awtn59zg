class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void backtrack(String s, int start, List<String> current){
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start + 1; i <= s.length(); i++){
            String substring = s.substring(start, i);

            if(isPalindrome(s, start, i - 1)){
                current.add(substring);
                backtrack(s, i, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
