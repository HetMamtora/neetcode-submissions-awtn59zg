class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i <= heights.length; i++){
            int currHeight;
            if(i == heights.length){
                currHeight = 0;
            } else {
                currHeight = heights[i];
            }

            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int topIndex = stack.pop();
                int height = heights[topIndex];
                int rightBoundary = i;
                int leftBoundary;

                if(stack.isEmpty()){
                    leftBoundary = -1;
                } else {
                    leftBoundary = stack.peek();
                }

                int width = rightBoundary - leftBoundary - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }
        return maxArea;
    }
}
