class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0, maxFrequency = 0, left = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));

            if((right - left + 1) - maxFrequency > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
