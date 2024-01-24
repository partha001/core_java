#https://leetcode.com/problems/first-missing-positive/

# TC: O(n)
# SC: O(n)
class Solution1:
    def firstMissingPositive(self, nums: List[int]) -> int:
        count = 1 
        nums = set(nums)
        while count in nums:
            count +=1
        return count


# TC: O(n)
# SC: O(1)
# this uses swap
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n=len(nums)
        for i in range(n):
            correctPos=nums[i]-1
            while 1<=nums[i]<=n and nums[i]!=nums[correctPos]:
                ## using comma operator to swap variables [https://www.javatpoint.com/python-swap-two-variables]
                nums[i],nums[correctPos]=nums[correctPos],nums[i]
                correctPos=nums[i]-1
        for i in range(n):
            if i+1!=nums[i]:
                return i+1
        return n+1