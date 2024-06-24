package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
        public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // while interval[i] upperbound is less than new interval lowerbound, add it
        while (i < n && intervals[i][1] < newInterval[0]) {
            results.add(intervals[i]);
            i++;
        }

        // while interval[i] lowerbound is lessthan or equal to newInterval upperbound, create new interval and add it
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        results.add(newInterval);

        // add the remaining intervals
        while (i < n) {
            results.add(intervals[i]);
            i++;
        }
        
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval sol = new InsertInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = sol.insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
