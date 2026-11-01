class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] tmp_nums = new int[n];
        for (int i = 0; i < n; i++) {
            tmp_nums[i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            nums[newIndex] = tmp_nums[i];
        }
    }
}