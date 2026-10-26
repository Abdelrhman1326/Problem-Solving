class Solution {
public:
    bool isPalindrome(int x) {
        string number = to_string(x);
        // 123 -> length = 3, stop when i = 1 -> length / 2
        int limit = number.length() / 2;
        int fullLength = number.length();
        bool palindrome = true;
        for (int i = 0; i < limit; i++) {
            if (number[i] != number[fullLength - i - 1]) {
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }
};