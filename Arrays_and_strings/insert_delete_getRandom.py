"""
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. 
Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. 
Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements 
(it's guaranteed that at least one element exists when this method is called). 
Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
"""
import random

class RandomizedSet(object):
    def __init__(self):
        self.nums = set()  # Set to store unique elements
        self.vals = []  # List to store elements for random access

    def insert(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val in self.nums:
            return False
        self.nums.add(val)
        self.vals.append(val)
        return True

    def remove(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val not in self.nums:
            return False
        self.nums.remove(val)
        idx = self.vals.index(val)
        # Move the last element to the index of the element to remove
        last_element = self.vals[-1]
        self.vals[idx] = last_element
        self.vals.pop()
        return True

    def getRandom(self):
        """
        :rtype: int
        """
        return random.choice(self.vals)