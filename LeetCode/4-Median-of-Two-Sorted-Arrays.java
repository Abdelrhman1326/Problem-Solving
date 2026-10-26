public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int totalLength = nums1.Length + nums2.Length;
        int[] merged = new int[totalLength];
        
        Array.Copy(nums1, 0, merged, 0, nums1.Length);
        Array.Copy(nums2, 0, merged, nums1.Length, nums2.Length);
        
        Array.Sort(merged); 
        
        if ((totalLength % 2) == 0) {
            int med2Index = totalLength / 2;
            int med1Index = med2Index - 1;
            
            int atMed1 = merged[med1Index];
            int atMed2 = merged[med2Index];
            
            return ((double)atMed1 + (double)atMed2) / 2.0;
        } else {
            int medIndex = totalLength / 2;
            
            return (double)merged[medIndex];
        }
    }
}