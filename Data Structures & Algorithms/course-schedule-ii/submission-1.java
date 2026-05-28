class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] result = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            result[index++] = node;
            count++;

            for(int neighbor : adjacency.get(node)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }

        if(count == numCourses){
            return result;
        } else {
            return new int[]{};
        }
    }
}
