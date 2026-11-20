class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();

        int maxLength = 0;
        int[] charFirstOccurrence = new int[128];
        Arrays.fill(charFirstOccurrence, -1);

        int currentLength = 1;
        charFirstOccurrence[s.charAt(0)] = 0;

        for (int i = 1; i < s.length(); i++) {
            if (charFirstOccurrence[s.charAt(i)] != -1) {
                maxLength = Math.max(maxLength, currentLength);
                int prevIndex = charFirstOccurrence[s.charAt(i)];
                currentLength = i - prevIndex;

                for (int j = prevIndex; j >= 0; j--) {
                    if (charFirstOccurrence[s.charAt(j)] == j) {
                        charFirstOccurrence[s.charAt(j)] = -1;
                    } else {
                        break;
                    }
                }
            } else {
                currentLength += 1;
            }

            charFirstOccurrence[s.charAt(i)] = i;
        }
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }
}