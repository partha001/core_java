
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
       i = 0
       for a in range(len(nums)):
           if nums[a] != 0 :
               nums[i] = nums[a]
               i+=1

       for i in range(i,len(nums)):
            nums[i]=0
        