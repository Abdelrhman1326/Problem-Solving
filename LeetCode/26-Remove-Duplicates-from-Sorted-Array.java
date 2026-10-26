public class Solution 
{
    public int RemoveDuplicates(int[] nums) 
    {
        if (nums.Length == 0) 
        {
            return 0;
        }

        int writeIndex = 1; 

        for (int readIndex = 1; readIndex < nums.Length; readIndex++) 
        {
            if (nums[readIndex] != nums[writeIndex - 1]) 
            {
                nums[writeIndex] = nums[readIndex];
                
                writeIndex++;
            }
        }

        return writeIndex;
    }
}