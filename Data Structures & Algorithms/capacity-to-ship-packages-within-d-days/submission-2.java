class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0; 
        int right = 0;
        for(int weight : weights){
            left = Math.max(left, weight);
            right = right + weight;
        }

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canShip(weights, mid, days)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canShip(int[] weights, int capacity, int days){
        int currentLoad = 0;
        int daysNeeded = 1;

        for(int weight : weights){
            if(currentLoad + weight > capacity){
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad = weight + currentLoad;
        }

        return daysNeeded <= days;
    }
}