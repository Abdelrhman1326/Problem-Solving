class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;

        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum() - nums[0];
        if (leftSum == rightSum) return 0;
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) return i;
        }

        return -1;
    }
}