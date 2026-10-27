import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> tripletSet = new HashSet<>();
        Map<Integer, List<Integer>> numberOccurrences = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numberOccurrences.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = -(nums[i] + nums[j]);

                if (numberOccurrences.containsKey(target)) {
                    List<Integer> indices = numberOccurrences.get(target);

                    int usedCount = 0;
                    if (nums[i] == target) usedCount++;
                    if (nums[j] == target) usedCount++;

                    if (usedCount < indices.size()) {
                        List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], target));
                        Collections.sort(list);
                        tripletSet.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(tripletSet);
    }
}