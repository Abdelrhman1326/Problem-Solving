public class Solution {
    public string Convert(string s, int numRows) {
        if (numRows == 1 || s.Length <= numRows) {
            return s;
        }

        int length = s.Length;
        int i = 0;

        Dictionary<int, List<char>> map = new Dictionary<int, List<char>>();
        for (int k = 0; k < numRows; k++) {
            map.Add(k, new List<char>());
        }

        int j = 0;
        string state = "down";

        while (i < length) {
            if (j == numRows - 1) {
                state = "up";
            }
            
            map[j].Add(s[i]);
            i += 1;

            if (state == "up") {
                j -= 1;
            } else {
                j += 1;
            }

            if (j == 0) {
                state = "down";
            }            
        }

        List<char> newS = new List<char>();
        for (i = 0; i < numRows; i++) {
            if (map.ContainsKey(i)) {
                 newS.AddRange(map[i]);
            }
        }

        string newStoString = string.Join("", newS);
        return newStoString;
    }
}