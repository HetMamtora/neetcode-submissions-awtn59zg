class Solution {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return result;
        }
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, new StringBuilder(), mapping);
        return result;
    }

    public void backtrack(String digits, int index, StringBuilder current, String[] mapping){
        
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++){
            current.append(letters.charAt(i));
            backtrack(digits, index + 1, current, mapping);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
