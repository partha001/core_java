# https://leetcode.com/problems/trapping-rain-water/
class Solution:
    def trap(self, height: List[int]) -> int:
        maxWater =0
        left =0
        right = len(height) -1
        leftMax = 0
        rightMax = 0
        while left<=right:
            if height[left] <= height[right]:
                if(leftMax < height[left]):
                    leftMax = height[left]
                else:
                    maxWater = maxWater + leftMax - height[left]
                left = left +1
            else:
                if rightMax < height[right]:
                    rightMax = height[right]
                else:
                    maxWater = maxWater + rightMax - height[right]
                right = right -1
        return maxWater
