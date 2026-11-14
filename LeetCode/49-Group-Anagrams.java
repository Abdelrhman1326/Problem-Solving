    import java.util.*;

    class Solution {
        private static record Str(Integer key, String value){}
        public List<List<String>> groupAnagrams(String[] strs) {
            ArrayList<Str> key_value_pair = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                key_value_pair.add(new Str(i, strs[i]));
            }

            int max_length = 0;
            for (int i = 0; i < key_value_pair.size(); i++) {
                Str str = key_value_pair.get(i);
                char[] chars = str.value().toCharArray();
                Arrays.sort(chars);
                String new_str_value = new String(chars);
                key_value_pair.set(i, new Str(str.key(), new_str_value));

                max_length = Integer.max(max_length, new_str_value.length());
            }

            // sort according to the strs
            key_value_pair.sort((a, b) -> a.value().compareTo(b.value()));

            List<List<String>> ans = new ArrayList<>();
            int i = 0;
            for (; i < key_value_pair.size() - 1; i++) {
                List<String> current = new ArrayList<>();
                current.add(strs[key_value_pair.get(i).key()]);
                while (i + 1 < key_value_pair.size() && (key_value_pair.get(i).value()).compareTo(key_value_pair.get(i + 1).value()) == 0) {
                    current.add(strs[key_value_pair.get(i + 1).key()]);
                    i++;
                }
                ans.add(current);
            }

            if (i != key_value_pair.size()) {
                ans.add(new ArrayList<>() {{
                    add(strs[key_value_pair.get(key_value_pair.size() - 1).key()]);
                }});
            }

            return ans;
        }
    }