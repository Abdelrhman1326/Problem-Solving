public class Solution
{
    private int maxLen = 0;
    private int start = 0;

    public string LongestPalindrome(string s)
    {
        int n = s.Length;

        if (n < 2)
        {
            return s;
        }

        for (int i = 0; i < n; i++)
        {
            // Case 1: Odd length palindromes (center is a single character s[i])
            // e.g., "b_a_b", center at 'a'
            Expand(s, i, i);

            // Case 2: Even length palindromes (center is between s[i] and s[i+1])
            // e.g., "c_bb_d", center between the two 'b's
            Expand(s, i, i + 1);
        }

        return s.Substring(start, maxLen);
    }

    /// <summary>
    /// Expands outwards from a given center (left, right) to find the longest palindrome.
    /// </summary>
    private void Expand(string s, int left, int right)
    {
        // Expand as long as indices are within bounds and characters match
        while (left >= 0 && right < s.Length && s[left] == s[right])
        {
            left--;
            right++;
        }

        // After the loop, the boundaries of the palindrome are (left + 1) and (right - 1).
        // The length is: (right - 1) - (left + 1) + 1 = right - left - 1

        int currentLen = right - left - 1;

        // If the current palindrome is longer than the longest one recorded, update the tracker.
        if (currentLen > maxLen)
        {
            maxLen = currentLen;
            // The starting index of the palindrome is (left + 1)
            start = left + 1;
        }
    }
}