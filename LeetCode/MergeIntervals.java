package Extras.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    private static boolean intervalsOverlap(int[] i1, int[] i2) {
        return Math.max(i1[0], i2[0]) <= Math.min(i1[1], i2[1]);
    }

    private static int[][] merge (int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });

        ArrayList<int[]> intervalsList = new ArrayList<>();

        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervalsOverlap(currentInterval, intervals[i])) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                intervalsList.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        intervalsList.add(currentInterval);

        int[][] returnArray = new int[intervalsList.size()][2];
        for (int i = 0; i < intervalsList.size(); i++) {
            returnArray[i] = intervalsList.get(i);
        }

        return returnArray;
    }

    // Old solution. Slower.
    /*private static int[][] merge (int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][] {};
        } else if (intervals.length == 1) {
            return intervals;
        }
        ArrayList<int[]> helperList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        Stack<int[]> stack = new Stack<>();

        for (int i = intervals.length-1; i >= 0; i--) {
            stack.push(intervals[i]);
        }

        while (stack.size() > 1) {
            int[] interval1 = stack.pop();
            int[] interval2 = stack.pop();

            if (interval2[0] <= interval1[1]) {
                if (interval2[1] < interval1[1]) {
                    stack.push(interval1);
                    continue;
                }
                interval1[1] = interval2[1];
                stack.push(interval1);
            } else {
                stack.push(interval2);
                helperList.add(interval1);
            }
        }
        helperList.add(stack.pop());

        int [][] returnArray = new int[helperList.size()][2];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = helperList.get(i);
        }
        return returnArray;

    }*/

    public static void main(String[] args) {
        //int [][] input = new int[][] {
        //         {1,4}, {4,5}, {6,8}, {8,10}, {15,18}
        //};
        int [][] input = new int[][] {
                {1,8}, {2,7}, {3,6}
        };
        int [][] result = merge(input);
        System.out.println(Arrays.deepToString(result));
    }

}
