"""
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. 
The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. 
Do not include any extra spaces.
"""
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        words = s.split(" ")

        reversed_words = []
        for i in range(len(words) -1, -1, -1):
            if bool(words[i]):
                reversed_words.append(words[i])

        # .join() iterates over the reversed_words list and add " " in between
        return " ".join(reversed_words)