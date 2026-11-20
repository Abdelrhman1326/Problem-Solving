/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* productExceptSelf(int* nums, int numsSize, int* returnSize) {
    *returnSize = numsSize;
    int prefix[numsSize];
    int suffix[numsSize];

    *prefix = 1;
    for (int i = 1; i < numsSize; i++) {
        *(prefix + i) = *(prefix + i - 1) * *(nums + i - 1);
    }

    *(suffix + numsSize - 1) = 1;
    for (int i = numsSize - 2; i >= 0; i--) {
        *(suffix + i) = *(suffix + i + 1) * *(nums + i + 1);
    }

    int* ans = malloc(sizeof(int) * numsSize);
    for (int i = 0; i < numsSize; i++) {
        *(ans + i) = *(prefix + i) * *(suffix + i);
    }

    return ans;
}