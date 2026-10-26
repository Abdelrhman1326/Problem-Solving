class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        map<int, set<char>> mp;
        int maxSize = INT_MAX;
        for (string str : strs) {
            maxSize = min(maxSize, (int)str.length());
            for (int i = 0; i < str.length(); i++) {
                mp[i].insert(str[i]);
            }
        }

        int max = -1;
        for (int i = 0; i < maxSize; i++) {
            if (mp[i].size() == 1) {
                max += 1;
            } else {
                break;
            }
        }

        if (max == -1) return "";
        string ans = "";
        string sample = strs[0];
        for (int i = 0; i <= max; i++) {
            ans.push_back(sample[i]);
        }
        return ans;
    }
};