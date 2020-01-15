package Extras.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

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
