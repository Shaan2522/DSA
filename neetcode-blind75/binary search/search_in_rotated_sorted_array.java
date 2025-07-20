// https://leetcode.com/problems/search-in-rotated-sorted-array/

class search_in_rotated_sorted_array {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) return mid;
            // in the left sorted portion
            if(nums[mid] >= nums[left]) {
                if(nums[mid] < target || nums[left] > target) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            // in the right sorted portion
            else {
                if(nums[mid] > target || nums[right] < target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}