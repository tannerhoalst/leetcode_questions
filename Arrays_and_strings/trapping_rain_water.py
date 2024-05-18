"""
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.
"""
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        
        if not height or len(height) < 3:
            return 0
        
        max_height_index = 0
        for i in range(1, len(height)):
            if height[i] > height[max_height_index]:
                max_height_index = i
        
        left_max = 0
        trapped_water = 0
        
        for i in range(max_height_index):
            if height[i] > left_max:
                left_max = height[i]
            trapped_water += left_max - height[i]
        
        right_max = 0
        for i in range(len(height) - 1, max_height_index, -1):
            if height[i] > right_max:
                right_max = height[i]
            trapped_water += right_max - height[i]

        return trapped_water
