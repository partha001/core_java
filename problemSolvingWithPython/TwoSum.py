# https://leetcode.com/problems/two-sum
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mydict = {}
        n = len(nums)
        for i in range(n):
            complement = target - nums[i]
            if complement in mydict:
                return [mydict[complement], i]
            mydict[nums[i]] = i

        return []
        