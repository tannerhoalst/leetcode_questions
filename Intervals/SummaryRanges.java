package Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) {
            return ranges;
        }
        
        int start = nums[0];
        
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // End of the current range
                if (start == nums[i - 1]) {
                    ranges.add(String.valueOf(start));
                } else {
                    ranges.add(start + "->" + nums[i - 1]);
                }
                
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        
        return ranges;
    }

    public static void main(String[] args) {
        SummaryRanges sol = new SummaryRanges();
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> result = sol.summaryRanges(nums);
        System.out.println(result);  // Output should be [0->2, 4->5, 7]
    }
}
