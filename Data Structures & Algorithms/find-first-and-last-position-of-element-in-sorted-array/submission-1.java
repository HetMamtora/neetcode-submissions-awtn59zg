class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = firstSearch(nums, target);
        result[1] = lastSearch(nums, target);
        return result;
    }

    public int firstSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int firstOccurence = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                right = mid - 1;
                firstOccurence = mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return firstOccurence;
    }

    public int lastSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int lastOccurence = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                left = mid + 1;
                lastOccurence = mid;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return lastOccurence;
    }
}