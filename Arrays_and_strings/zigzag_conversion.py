"""
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows
"""
class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        
        if numRows == 1:
            return s 

        rows = [""] * numRows
        current_row = 0
        direction = 1

        for char in s:
            rows[current_row] += char
            current_row += direction
            
            if current_row == 0 or current_row == numRows - 1:
                direction = -direction
        
        zigzag_message = "".join(rows)
        return zigzag_message