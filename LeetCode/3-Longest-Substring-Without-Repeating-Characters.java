class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int mx = 0;
        int l = 0;
        map<char,int> fr;
        int n = s.size();
        int cur = 0;
        for(int r = 0 ; r < n ;r++){
            fr[s[r]-'a']++;
            cur++;
            while(fr[s[r]-'a'] > 1){
                fr[s[l]-'a']--;
                cur--;
                l++;
            }
            mx = max(mx , cur);
        }
        return mx;
    }
};