class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] currentMerge = intervals[0];
        List<int[]> result = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= currentMerge[1]){
                currentMerge[1] = Math.max(currentMerge[1], intervals[i][1]);
            } else{
                result.add(currentMerge);
                currentMerge = intervals[i];
            }
        }
        
        result.add(currentMerge);
        return result.toArray(new int[0][]);
    }
}
