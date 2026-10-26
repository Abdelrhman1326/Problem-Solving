class Solution {
private:
    vector<string> combinations;
    void generateParenthesis(int len, string str, int left_openings, int left_closings) {
        if (str.length() == len) {
            combinations.push_back(str);
            return;
        }

        if (left_openings > 0) {
            generateParenthesis(len, (str + "("), left_openings - 1, left_closings);
        }

        if (left_closings > 0 && left_openings < left_closings) {
            generateParenthesis(len, (str + ")"), left_openings, left_closings - 1);
        }
    }

public:
    vector<string> generateParenthesis(int n) {
        generateParenthesis((n * 2), "", n, n);
        return combinations;
    }
};