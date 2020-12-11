import java.util.*;

public class NonOverlappingIntervals {



    private static boolean intervalOverlaps (int [] i1, int [] i2) {
        return Math.max(i1[0], i2[0]) < Math.min(i2[1], i1[1]);
    }

    private static int eraseOverlapIntervals (int [][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[1] - i2[1];
        });

        int n = intervals.length;
        int [] currentInterval = intervals[0];
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (intervalOverlaps(currentInterval, intervals[i])) {
                count++;
            } else {
                currentInterval = intervals[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}
        };

        System.out.println(eraseOverlapIntervals(intervals));
    }

}
