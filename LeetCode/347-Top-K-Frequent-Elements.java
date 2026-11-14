import java.util.*;

class Solution {
    private static record Pair(Integer key, Integer value) {}

    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Pair> freq = new ArrayList<>();

        int max_num = Integer.MIN_VALUE;
        int offset = Integer.MAX_VALUE;
        for (int num : nums) {
            max_num = Integer.max(max_num, num);
            offset = Integer.min(offset, num);
        }

        int sz = max_num - offset + 1;

        for (int i = 0; i < sz; i++) {
            freq.add(new Pair(-100000, -100000));
        }

        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] - offset;
            if (freq.get(idx).key() == -100000) {
                freq.set(idx, new Pair(nums[i], 1));
            } else {
                int old_freq = freq.get(idx).value();
                int old_key = freq.get(idx).key();
                freq.set(idx, new Pair(old_key, old_freq + 1));
            }
        }

        freq.sort((a, b) -> Integer.compare(b.value(), a.value()));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = freq.get(i).key();
        }

        return res;
    }
}