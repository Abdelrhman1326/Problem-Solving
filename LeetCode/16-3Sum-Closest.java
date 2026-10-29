class Solution {
    private static int lowerBound(int[] array, int target) {
        int low = 0;
        int high = array.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        long closestSum = (long) nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long currentSum = (long) nums[i] + nums[j];
                int complement = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, (long) target - currentSum));

                int k = lowerBound(nums, complement);

                for (int p = k - 1; p >= 0; p--) {
                    if (p == i || p == j) {
                        continue;
                    }
                    long sum = currentSum + nums[p];
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }
                    break;
                }

                for (int p = k; p < n; p++) {
                    if (p == i || p == j) {
                        continue;
                    }
                    long sum = currentSum + nums[p];
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }
                    break;
                }
            }
        }

        return (int)closestSum;
    }
}