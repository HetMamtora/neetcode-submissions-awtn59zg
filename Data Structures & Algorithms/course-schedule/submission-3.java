class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            adjacency.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int result = queue.poll();
            count++;

            for(int neighbor : adjacency.get(result)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }

        if(count == numCourses){
            return true;
        } else {
            return false;
        }
    }
}
