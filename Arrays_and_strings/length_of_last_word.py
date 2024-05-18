"""
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.
"""
class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        words = s.split(" ")

        if not words:
            return 0

        filtered_words = []
        for word in words:
            if bool(word):
                filtered_words.append(word)

        return len(filtered_words[len(filtered_words) - 1])