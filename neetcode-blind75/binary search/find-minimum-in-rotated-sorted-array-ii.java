// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

/* contains duplicate elements in the array.
 * imagine this array -> [2, 2, 2, 0, 1, 2]
 * the usual code wont work here */

class Main {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = (left+right)/2;
            // [4, 5, 6, 7, 0, 1, 2]
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } 
            // [11, 13, 15, 17]
            else if(nums[mid] < nums[right]) {
                right = mid;
            } 
            // [2, 2, 2, 0, 1, 2]
            else {
                right--;
            }
        }
        return nums[left];
    }
}
