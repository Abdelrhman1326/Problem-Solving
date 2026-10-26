public class Solution {
    public int MaxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int current_max = nums[0];

        for (int i = 1; i < nums.Length; i++) {
            current_max = Math.Max(nums[i], current_max + nums[i]);
            max_so_far = Math.Max(max_so_far, current_max);
        }

        return max_so_far;
    }
}
