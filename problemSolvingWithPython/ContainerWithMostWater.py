#https://leetcode.com/problems/container-with-most-water/description/

class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxWater = 0
        left = 0
        right = len(height)-1
        while(left<=right):
            minVal = min(height[left], height[right])
            maxWater = max(maxWater, minVal * (right - left))
            if minVal == height[left] :
                left = left +1
            else :
                right = right -1
        return maxWater