class Solution {
public:
    int maxProduct(vector<int>& nums) {
        const int MAX_SAVE = 50;        // track lengths 1...50
        int n = nums.size();
        if (n == 0) return 0;

        int ans = nums[0];
        // dp[row][len] = {min_prod, max_prod} of subarray of length len ending at index i,
        // where row = i % MAX_SAVE, len in [1..MAX_SAVE].
        vector<vector<pair<int,int>>> dp(MAX_SAVE, vector<pair<int,int>>(MAX_SAVE+1));

        for (int i = 0; i < n; i++) {
            int row = i % MAX_SAVE;
            int num = nums[i];

            // length = 1
            dp[row][1] = { num, num };
            ans = max(ans, num);

            int prev_row = (i - 1 + MAX_SAVE) % MAX_SAVE;
            // lengths = 2..MAX_SAVE
            for (int len = 2; len <= MAX_SAVE; len++) {
                // only valid if we have at least `len` elements so far
                if (i >= len - 1) {
                    auto [pmin, pmax] = dp[prev_row][len - 1];
                    int cur_min = min({ num, pmin * num, pmax * num });
                    int cur_max = max({ num, pmin * num, pmax * num });
                    dp[row][len] = { cur_min, cur_max };
                    ans = max(ans, cur_max);
                }
                else {
                    // mark unused slots so we don't accidentally read them
                    dp[row][len] = { INT_MAX, INT_MIN };
                }
            }
        }

        return ans;
    }
};