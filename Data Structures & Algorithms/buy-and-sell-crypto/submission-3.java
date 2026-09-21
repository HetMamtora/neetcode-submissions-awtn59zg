class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            int currentPrice = prices[i];

            if(currentPrice < minPrice){
                minPrice = currentPrice;
            }

            int profitToday = currentPrice - minPrice;
            if(profitToday > maxProfit){
                maxProfit = profitToday;
            }
        }
        return maxProfit;
    }
}
