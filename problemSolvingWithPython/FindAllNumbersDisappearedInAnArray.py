#https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        i=0
        while i < len(nums):
           correctIndex = nums[i] -1
           if nums[i]>0 and nums[i]<=len(nums) and nums[correctIndex]!= nums[i]:
               nums[correctIndex], nums[i]= nums[i], nums[correctIndex]
           else :
                i= i+1
        
        result = []
        for i in range(len(nums)):
            if(i+1 != nums[i]):
                result.append(i+1)

        return result
        
        