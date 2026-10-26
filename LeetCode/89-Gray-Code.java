public class Solution {
    public IList<int> GrayCode(int n) {
        IList<int> list = new List<int> { 0 };

        for (int i = 0; i < n; i++) {
            // The value to add to the reflected sequence is 2^i
            // We use the bit shift operator (1 << i) for efficient calculation of 2^i
            int powerOfTwo = 1 << i; 

            // Reflect the existing sequence: Iterate backward through the current list.
            for (int j = list.Count - 1; j >= 0; j--) {
                // Add the powerOfTwo offset to the reflected element and append it.
                // This ensures only the i-th bit is flipped from the previous element.
                list.Add(list[j] + powerOfTwo);
            }
        }

        return list;
    }
}
