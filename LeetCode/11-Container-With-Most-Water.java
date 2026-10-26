public class Solution {
    public int MaxArea(int[] height) {

        int maxArea = 0;
        int left = 0, right = height.Length - 1;
        while (left <= right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            
            maxArea = Math.Max(maxArea, Math.Abs(right - left) * (Math.Min(leftHeight, rightHeight)));

            if (leftHeight > rightHeight) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return maxArea;
    }
}