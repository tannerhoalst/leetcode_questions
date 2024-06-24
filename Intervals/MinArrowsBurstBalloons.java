package Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsBurstBalloons {
        public int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }

        int arrows = 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int currentEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        MinArrowsBurstBalloons sol = new MinArrowsBurstBalloons();
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        int result = sol.findMinArrowShots(points);
        System.out.println("Minimum number of arrows needed: " + result);  // 2
    }
}
