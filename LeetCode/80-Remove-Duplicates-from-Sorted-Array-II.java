class Solution {
    public int removeDuplicates(int[] nums) {
        int maxNum = Arrays.stream(nums).max().orElse(0);
        int minNum = Arrays.stream(nums).min().orElse(0);
        int freqSize = Math.abs(maxNum) + Math.abs(minNum) + 1;
        int[] freq = new int[freqSize];
        Arrays.fill(freq, 0);

        int indexShift = Math.abs(Math.min(maxNum, minNum));
        int stepsBackward = 0;
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i] + indexShift] += 1;
            if (freq[nums[i] + indexShift] > 2) {
                stepsBackward += 1;
            } else if (stepsBackward >= 0) {
                nums[i - stepsBackward] = nums[i];
            }
        }

        return nums.length - stepsBackward;
    }
}