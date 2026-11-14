class Solution {
    private final static Integer OFFSET = 100;
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[202];
        for (int i = 0; i < freq.length; i++)
            freq[i] = 0;
        for (int i = 0; i < nums.length; i++)
            freq[nums[i] + OFFSET]++;


        nums = Arrays.stream(nums)
                    .boxed()
                    .sorted((a, b) -> {
                        int freqCompare = Integer.compare(freq[a + OFFSET], freq[b + OFFSET]);
                        int numCompare = Integer.compare(b, a);

                        // if freqCompare != 0 return it else return numCompare
                        return freqCompare != 0 ? freqCompare : numCompare;
                    })
                    .mapToInt(num -> Integer.sum(num, 0))
                    .toArray();

        return nums;
    }
}