from collections import defaultdict


class Solution:
    def maxFrequency(self, nums: list, k: int) -> int:
        nums.sort()
        left, right, total, length = 0, 0, 0, len(nums)
        
        frequency = 0
        while right < length:
            total += nums[right]
            while nums[right] * (right-left+1) - total > k:
                total -= nums[left]
                left += 1
            frequency = max(frequency, right-left+1)
            right += 1
        return frequency


s = Solution()
# 3
nums = [1, 2, 4]
k = 5
print(s.maxFrequency(nums, k))

# 2
nums = [1, 4, 8, 13]
k = 5
print(s.maxFrequency(nums, k))

# 1
nums = [3, 9, 6]
k = 2
print(s.maxFrequency(nums, k))
