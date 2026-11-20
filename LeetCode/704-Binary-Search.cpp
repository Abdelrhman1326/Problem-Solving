class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        int traget_index = -1;

        while (left <= right) {
            int middle = left + (right-left)/2;
            if (nums[middle] == target) {
                traget_index = middle;
                break;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return traget_index;
    }
};