class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_set = set(nums)

        for i, num in enumerate(nums):
            complement = target - num

            if complement in nums_set:
                # Need correct index of complement
                for j in range(i + 1, len(nums)):
                    if nums[j] == complement:
                        return [i, j]