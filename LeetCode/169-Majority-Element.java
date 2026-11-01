class Solution {
    public int majorityElement(int[] nums) {
        int majority_factor = nums.length / 2;
        Map<Integer, Integer> freq = new HashMap<>();
        Arrays.stream(nums).forEach(num -> freq.put(num, freq.getOrDefault(num, 0) + 1));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > majority_factor) {
                return entry.getKey();
            }
        }
        return -1;
    }
}