class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) { // the left side is cleanly sorted
                if (target >= nums[left] && target < nums[mid]) { // search in the left half
                    right = mid - 1;
                } else {
                    left = mid + 1; // search in the right half
                }
            } else { // the right half is cleanly sorted
                if (target > nums[mid] && target <= nums[right]) { // search in the right half
                    left = mid + 1;
                } else {
                    right = mid - 1; // search in the left half
                }
            }
        }

        return -1;
    }
}