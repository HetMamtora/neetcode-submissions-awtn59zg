class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int n : set){
            if(!set.contains(n - 1)){
                
                int currentNum = n, currentStreak = 1;
                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }
                maxLength = Math.max(maxLength, currentStreak);
            }
        }
        return maxLength;
    }
}
