import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class InsertInterval {

    private static boolean intervalsOverlap (int[] i1, int[] i2) {
        return Math.max(i1[0], i2[0]) <= Math.min(i1[1], i2[1]);
    }

    private static int[][] insert (int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length+1][2];
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;

        Arrays.sort(newIntervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });

        ArrayList<int[]> list = new ArrayList<>();

        int[] currentInterval = newIntervals[0];
        for (int i = 0; i < newIntervals.length; i++) {
            if (intervalsOverlap(currentInterval, newIntervals[i])) {
                currentInterval[1] = Math.max(currentInterval[1], newIntervals[i][1]);
            } else {
                list.add(currentInterval);
                currentInterval = newIntervals[i];
            }
        }
        list.add(currentInterval);

        int[][] returnArray = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            returnArray[i] = list.get(i);
        }

        return returnArray;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {0, 2}, {4, 5}
        };

        System.out.println(Arrays.deepToString(insert(intervals, new int[]{-1, 1})));
    }

}
