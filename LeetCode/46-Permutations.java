class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> answers;
        vector<int> prefix;
        recursive_perm(nums, prefix, answers);
        return answers;
    }

private:
    void recursive_perm(vector<int>& nums, vector<int> prefix, vector<vector<int>>& answers) {
        // Base case: when nums is empty, store the permutation
        if (nums.empty()) {
            answers.push_back(prefix);
            return;
        }
        
        // Loop through all numbers
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];

            // Copy the nums vector and remove the current number
            vector<int> remaining_nums = nums;
            remaining_nums.erase(remaining_nums.begin() + i);

            // Add num to the prefix and recurse
            vector<int> new_prefix = prefix;
            new_prefix.push_back(num);
            recursive_perm(remaining_nums, new_prefix, answers);
        }
    }
};
