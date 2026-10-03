class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
            int distA = Math.abs(a - x);
            int distB = Math.abs(b - x);

            if(distA == distB){
                return b - a;
            }

            return distB - distA;
        });

        for(int nums : arr){
            maxHeap.offer(nums);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            list.add(maxHeap.poll());
        }

        Collections.sort(list);
        return list;
    }
}