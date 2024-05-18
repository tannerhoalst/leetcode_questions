"""
Given an integer array nums, return an array answer such that answer[i] 
is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
"""
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        n = len(nums)
        right = [1] * n  # python initialization of list with n 1s
        left = [1] * n  
        answer = [1] * n  
        
        #left[0] = 1 similar initialization for java
        for i in range(1, len(nums), 1):
            left[i] = left[i -1] * nums[i -1]

        #right[len(nums) -1] = 1 use similar initialization for java
        for i in range(len(nums)-2, -1, -1):
            right[i] = right[i +1] * nums[i +1]

        #this loop can be added to the two loops above to speed up time
        for i in range(n):
            answer[i] = left[i] * right[i]

        return answer
    