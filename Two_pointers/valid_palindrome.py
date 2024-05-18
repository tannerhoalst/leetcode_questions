"""
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and 
removing all non-alphanumeric characters, it reads the same forward and backward. 
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
"""
import re
class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        valid_characters = r'[^a-zA-Z0-9]' 
        cleaned_string = re.sub(valid_characters, '', s)
        lowercase_string = cleaned_string.lower()
        n = len(lowercase_string) 
        for i in range(n / 2):
            if(lowercase_string[i] != lowercase_string[n -1 -i]):
                return False
        
        return True
    