#https://leetcode.com/problems/h-index
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left = 0
        right = n -1
        citations.sort()

        while left <= right:
            mid = int((left + right)/2)
            if citations[mid] == (n - mid):
                return citations[mid]
            elif citations[mid] < (n - mid):
                left = mid +1
            else:
                right = mid -1

        
        return n -left