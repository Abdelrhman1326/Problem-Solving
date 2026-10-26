public class Solution {
    public int ClimbStairs(int n) {
        // S(n) = S(n - 1) + S(n - 2)
        if (n == 1) return 1;
        if (n == 0) return 0;
        List<int> S = new List<int>();
        S.Add(1);
        S.Add(2);

        for (int i = 2; i < n; i++) {
            S.Add(S[i - 1] + S[i - 2]);
        }

        return S[n - 1];
    }
}