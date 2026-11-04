class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int prev_jump_index = 0;
        int count_jumps = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i + nums[i] > farthest) {
                farthest = i + nums[i];
            }

            if (i == prev_jump_index) {
                count_jumps++;
                prev_jump_index = farthest;
            }
        }

        return count_jumps;
    }
}