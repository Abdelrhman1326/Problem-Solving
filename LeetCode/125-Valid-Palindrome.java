class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        ArrayList<Character> str = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                str.add(c);
            }
        }

        int left = 0, right = str.size() - 1;
        if (right == 0) return true;
        while (left <= right) {
            if (str.get(left) == str.get(right)) {
                left++; right--;
            } else {
                return false;
            }
        }

        return true;
    }
}