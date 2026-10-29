class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] sorted = IntStream.concat(
            Arrays.stream(nums1, 0, m),
            Arrays.stream(nums2, 0, n)
        ).sorted().toArray();

        System.arraycopy(sorted, 0, nums1, 0, n + m);
    }
}