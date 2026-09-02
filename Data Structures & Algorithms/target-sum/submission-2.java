class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;

        for(int i = 0; i < n; i++){
            totalSum = totalSum + nums[i];
        }

        if((totalSum + target) % 2 != 0 ){
            return 0;
        }
        if(target > totalSum){
            return 0;
        }

        int p = (totalSum + target) / 2;
        if(p < 0){
            return 0;
        }
        
        int[] dp = new int[p + 1];
        dp[0] = 1;
        
        for(int num : nums){
            for(int j = p; j >= num; j--){
                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[p];
    }
}
