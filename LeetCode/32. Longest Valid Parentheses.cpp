class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.size();

        vector<int> dp(n, 0);
        vector<int> prev_open_index;

        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                prev_open_index.push_back(i);
            } else if (prev_open_index.size()) {
                int index = prev_open_index.back();
                prev_open_index.pop_back();

                int prev_len = (index > 0) ? dp[index - 1] : 0;
                dp[i] = (i - index + 1) + prev_len;
            }
        }
        
        int max_answer = 0;
        for (auto& answer : dp)
            max_answer = max(answer, max_answer);

        return max_answer;
    }
};