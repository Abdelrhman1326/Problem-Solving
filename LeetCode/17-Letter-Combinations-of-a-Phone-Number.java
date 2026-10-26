class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return {};
        
        build_map();
        n = digits;
        solve("", 0);
        return result;
    }

private:
    map<int, vector<char>> nokia_map;
    string n;
    vector<string> result;

    void build_map() {
        nokia_map[2] = {'a', 'b', 'c'};
        nokia_map[3] = {'d', 'e', 'f'};
        nokia_map[4] = {'g', 'h', 'i'};
        nokia_map[5] = {'j', 'k', 'l'};
        nokia_map[6] = {'m', 'n', 'o'};
        nokia_map[7] = {'p', 'q', 'r', 's'};
        nokia_map[8] = {'t', 'u', 'v'};
        nokia_map[9] = {'w', 'x', 'y', 'z'};
    }

    void solve(string curr, int idx) {
        // Base case
        if (idx == n.size()) {
            result.push_back(curr);
            return;
        }

        // Transition
        char curr_num = n[idx];
        vector<char> &curr_vector = nokia_map[curr_num - '0'];
        for (char curr_c : curr_vector) {
            solve(curr + curr_c, idx + 1);
        }
    }
};
