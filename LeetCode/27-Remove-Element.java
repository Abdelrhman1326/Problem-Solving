using System.Collections.Generic;
using System.Linq;

public class Solution {
    public int RemoveElement(int[] nums, int val) {
        List<int> indicesToRemove = new List<int>(); 
        
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] == val) {
                // remove
                int index = i - indicesToRemove.Count;
                indicesToRemove.Add(index);
            }
        } 
        
        for (int i = 0; i < indicesToRemove.Count; i++) {
            for (int j = indicesToRemove[i]; j < nums.Length - 1; j++) {
                nums[j] = nums[j + 1];
            }
            for (int j = nums.Length - 1; j > nums.Length - i - 2; j--) { 
                nums[j] = val;
            }
        }

        return nums.Length - indicesToRemove.Count;
    }
}