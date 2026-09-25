class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int task : tasks){
            freq[task - 'A']++;
        }

        int maxCount = 0;
        for(int f : freq){
            maxCount = Math.max(maxCount, f);
        }

        int maxTasks = 0;
        for(int f : freq){
            if(f == maxCount){
                maxTasks++;
            }
        }

        return Math.max((maxCount - 1) * (n + 1) + maxTasks, tasks.length);
    }
}
