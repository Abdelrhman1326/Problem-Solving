class Solution {
    public boolean canJump(int[] nums) {
        // what to compare, when to stop on an index:
        // when the prev jump left jump distance is <= the current cell's jump value

        int prev_jump_index = 0;

        for (int i = 1; i < nums.length; i++) {
            int left_jump_distance = nums[prev_jump_index] - (i - prev_jump_index);

            if (left_jump_distance >= 0 && left_jump_distance <= nums[i]) {
                prev_jump_index = i;
            }
        }
        
        return nums[prev_jump_index] >= (nums.length - prev_jump_index - 1);
    }
}