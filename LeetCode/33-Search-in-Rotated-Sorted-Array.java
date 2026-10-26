public class Solution {
    
    private int indexOfMin(int[] nums) {
        int n = nums.Length;
        if (n == 0) return -1;

        int left = 0;
        int right = n - 1;

        // If the array is already sorted, min is at index 0.
        if (nums[left] <= nums[right]) {
            return left;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Array is already sorted:
            if (mid + 1 < n && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            
            // If the left segment [left...mid] is sorted (nums[mid] >= nums[left]), 
            // the pivot (minimum) must be in the right half. Move left boundary past mid.
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } 
            // If the left segment is not sorted (nums[mid] < nums[left]), 
            // the pivot (minimum) must be in the left half, including mid.
            else {
                right = mid - 1;
            }
        }
        
        return -1; 
    }

    private int searchForTarget(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int Search(int[] nums, int target) {
        int n = nums.Length;
        if (n == 0) return -1;
        
        int minAt = indexOfMin(nums);

        if (nums[minAt] == target) return minAt;
        
        if (minAt > 0 && target >= nums[0] && target <= nums[minAt - 1]) {
            return searchForTarget(nums, 0, minAt - 1, target);
        }

        if (target >= nums[minAt] && target <= nums[n - 1]) {
            return searchForTarget(nums, minAt, n - 1, target);
        }

        return -1;
    }
}