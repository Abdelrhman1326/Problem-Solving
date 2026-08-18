    class Solution {
    public:
        bool isMatch(string s, string p) {

            vector<char> str(s.length() + 1);
            vector<char> pat(p.length() + 1);

            for (int i = 0; i < s.length(); i++)
                str[i + 1] = s[i];

            for (int j = 0; j < p.length(); j++)
                pat[j + 1] = p[j];

            int n = s.length();
            int m = p.length();

            vector<vector<bool>> dp(n + 1, vector<bool>(m + 1, false));

            // empty string matches empty pattern
            dp[0][0] = true;

            // empty string matches patterns like:
            // ".*", "a*", "a*b*", "a*b*c*", ...
            for (int j = 2; j < m + 1; j++) {
                if (pat[j] == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    if (pat[j] == '*') {  
                        // zero occurances
                        if (j > 1)
                            dp[i][j] = dp[i][j - 2];

                        // one or more occurances
                        if (str[i] == pat[j - 1] || pat[j - 1] == '.')
                            dp[i][j] = dp[i][j] || dp[i - 1][j];

                    } else if (str[i] == pat[j] || pat[j] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }

            return dp[n][m];
        }
    };