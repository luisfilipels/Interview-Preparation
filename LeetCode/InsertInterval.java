import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class InsertInterval {

    private static boolean intervalsOverlap (int[] i1, int[] i2) {
        return Math.max(i1[0], i2[0]) <= Math.min(i1[1], i2[1]);
    }

    private static int[][] insert (int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {
                    newInterval
            };
        }

        int n = intervals.length;
        ArrayList<int[]> intervalsList = new ArrayList<>();

        HashSet<Integer> indicesToIgnore = new HashSet<>();
        int indexToAdd = -2;

        if (intervals[0][0] > newInterval[1]) {
            indexToAdd = -1;
        } else if (intervals[n-1][1] < newInterval[0]) {
            indexToAdd = n;
        }

        if (indexToAdd == -2) {
            for (int i = 0; i < n; i++) {
                if (intervalsOverlap(intervals[i], newInterval)) { // Conflict
                    indicesToIgnore.add(i);
                    newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                } else if (i >= 1 && intervals[i-1][1] < newInterval[0] && intervals[i][0] > newInterval[1]) {
                    indexToAdd = i-1;
                }
            }
        }

        boolean newIntervalAdded = false;
        if (indexToAdd == -1) intervalsList.add(newInterval);
        for (int i = 0; i < n; i++) {
            if (!indicesToIgnore.contains(i)) {
                intervalsList.add(intervals[i]);
                if (i == indexToAdd) intervalsList.add(newInterval);
            } else {
                if (!newIntervalAdded) {
                    newIntervalAdded = true;
                    intervalsList.add(newInterval);
                }
            }
        }
        if (indexToAdd == n) intervalsList.add(newInterval);

        int[][] returnArray = new int[intervalsList.size()][2];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = intervalsList.get(i);
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
