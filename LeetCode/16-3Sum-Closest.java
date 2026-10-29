class Solution {
    private static int lowerBound(int[] array, int target) {
        int low = 0;
        int high = array.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (array[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int currentSum = nums[i] + nums[j];
                int complement = target - currentSum;

                int k = lowerBound(nums, complement);

                // Search left from the lower bound.
                for (int p = k - 1; p >= 0; p--) {
                    if (p == i || p == j) {
                        continue;
                    }

                    int sum = currentSum + nums[p];

                    if (Math.abs((long) target - sum)
                            < Math.abs((long) target - closestSum)) {
                        closestSum = sum;
                    }

                    break;
                }

                // Search right from the lower bound.
                for (int p = k; p < n; p++) {
                    if (p == i || p == j) {
                        continue;
                    }

                    int sum = currentSum + nums[p];

                    if (Math.abs((long) target - sum)
                            < Math.abs((long) target - closestSum)) {
                        closestSum = sum;
                    }

                    break;
                }
            }
        }

        return closestSum;
    }
}