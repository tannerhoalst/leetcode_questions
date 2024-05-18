"""
You are given an integer array nums. You are initially positioned at the array's first index, 
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
"""
class Solution(object):
    def canJump(self, nums):

        length = len(nums)
        if length == 1:
            return True

        current_index = 0
        max_reach = 0

        while current_index <= max_reach:
            if max_reach >= length - 1:
                return True

            new_reach = current_index + nums[current_index]
            max_reach = max(max_reach, new_reach)
            current_index += 1

        return False