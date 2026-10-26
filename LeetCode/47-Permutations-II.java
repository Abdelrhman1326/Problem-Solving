class Solution
{
public:
    vector<vector<int>> permuteUnique(vector<int> &nums)  // Changed function name from permute to permuteUnique
    {
        vector<vector<int>> answers;
        vector<int> prefix;
        // take the nums in a map:
        map<int, int> unique_nums;
        for (int i = 0; i < nums.size(); i++)
        {
            unique_nums[nums[i]]++; // increment the counter by one for each occurence
        }
        recursive_perm(unique_nums, prefix, answers, nums.size());
        return answers;
    }

private:
    void recursive_perm(map<int, int> &unique_nums, vector<int> prefix, vector<vector<int>> &answers, int total_length)
    {
        // base case:
        if (prefix.size() == total_length)
        {
            answers.push_back(prefix);
            return;
        }

        for (auto& pair : unique_nums)
        {
            if (pair.second == 0) {
                continue;
            }
            
            prefix.push_back(pair.first);
            pair.second--;
            
            // Recursive call
            recursive_perm(unique_nums, prefix, answers, total_length);
            
            // Backtrack
            prefix.pop_back();
            pair.second++; // Restore count
        }
    }
};