package Extras.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    // New solution. Slightly faster, and uses less memory.
    private static int[][] merge (int[][] intervals) {
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

    }

    /*
    // Old solution.
    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][] {};
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        arrayList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int [] last = arrayList.get(arrayList.size()-1);
            if (intervals[i][0] >= last[0] && intervals[i][0] <= last[1]) {
                arrayList.get(arrayList.size()-1)[1] = Math.max(last[1], intervals[i][1]);
            } else {
                arrayList.add(intervals[i]);
            }
        }
        int [][] returnArray = new int[arrayList.size()][2];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = arrayList.get(i);
        }
        return returnArray;
    }
    */

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
