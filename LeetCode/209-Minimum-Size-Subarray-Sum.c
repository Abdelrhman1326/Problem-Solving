int minSubArrayLen(int target, int* nums, int numsSize) {
    int totalSum = 0;
    int minLength = numsSize + 1;
    int leftPtr = 0, rightPtr = 0;

    while (rightPtr < numsSize) {
        totalSum += *(nums + rightPtr);

        while (totalSum >= target) { // shrink from the left while still valid
            int length = rightPtr - leftPtr + 1;
            if (length < minLength) {
                minLength = length;
            }
            totalSum -= *(nums + leftPtr);
            leftPtr += 1;
        }

        rightPtr += 1;
    }

    return minLength == numsSize + 1 ? 0 : minLength;
}