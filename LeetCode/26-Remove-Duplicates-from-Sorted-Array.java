class Solution {
    public int removeDuplicates(int[] nums) {
        int maxNum = Arrays.stream(nums).max().orElse(0);
        int minNum = Arrays.stream(nums).min().orElse(0);

        int freqLength = Math.abs(maxNum) + Math.abs(minNum) + 1;
        int indexShift = Math.abs(minNum); // -5 for example will be putten in the index 0, 5 will be in index 10

        boolean[] freq = new boolean[freqLength];
        Arrays.fill(freq, false);

        int stepsBackward = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i] + indexShift] == true) { // previously visited
                stepsBackward += 1; // future items will need 
                continue;
            }

            if (stepsBackward >= 0) {
                nums[i - stepsBackward] = nums[i];
                freq[nums[i] + indexShift] = true; // mark visited
            }
        }

        return (nums.length - stepsBackward);
    }
}