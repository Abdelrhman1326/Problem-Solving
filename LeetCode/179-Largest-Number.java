class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> nums_strings = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums_strings.add(String.valueOf(nums[i]));
        }

        nums_strings.sort((a, b) -> (b + a).compareTo(a + b));

        ArrayList<Character> chars_array = new ArrayList<>();
        for (String s : nums_strings) {
            for (char c : s.toCharArray()) {
                chars_array.add(c);
            }
        }

        if (chars_array.get(0) == '0') {
            return "0";
        }

        char[] result = new char[chars_array.size()];
        for (int i = 0; i < chars_array.size(); i++) {
            result[i] = chars_array.get(i);
        }

        return new String(result);
    }
}