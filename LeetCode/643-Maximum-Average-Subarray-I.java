class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double prefix = 0.0;
        for (int i = 0; i < k; i++) {
            prefix += nums[i];
        }

        double maxSum = prefix;
        for (int i = k; i < nums.length; i++) {
            prefix += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, prefix);
        }

        return maxSum / k;
    }
}