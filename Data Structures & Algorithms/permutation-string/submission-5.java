class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        for(int right = 0; right < s2.length(); right++){
            
            char in = s2.charAt(right);
            map.put(in, map.getOrDefault(in, 0) - 1);

            if(right >= s1.length()){
                char out = s2.charAt(left);
                map.put(out, map.getOrDefault(out, 0) + 1);
                left++;
            }

            boolean isPermutation = true;
            for(int val : map.values()){
                if(val != 0){
                    isPermutation = false;
                    break;
                }

            }

            if(isPermutation){
                return true;
            }
        }
        return false;
    }
}
