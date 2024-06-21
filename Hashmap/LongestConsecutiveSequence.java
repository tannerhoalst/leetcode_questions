package Hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    //slightly faster
    public int longestConsecutiveArray(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) {
            return 0;
        }
        int currentConsecutive = 1;
        int maxConsecutive = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i -1]+1) {
                currentConsecutive++;
                if(currentConsecutive > maxConsecutive) {
                    maxConsecutive = currentConsecutive;
                }
            } else if (nums[i] != nums[i -1]) {
                currentConsecutive = 1;
            }
        }
        return maxConsecutive;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = sol.longestConsecutive(nums);
        System.out.println("Length of the longest consecutive elements sequence: " + result);  // Output should be 4
    }
}
