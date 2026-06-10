class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){
            tank = tank + (gas[i] - cost[i]);
            totalGain = totalGain + (gas[i] - cost[i]);

            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }

        if(totalGain < 0){
            return -1;
        }

        return start;
    }
}
