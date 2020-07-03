package Extras.LeetCode;

import Extras.InterviewBit.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingRoomsI {

    static class Interval {
        int start, end;
        Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static boolean canAttendMettings (int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] -i2[0];
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean canAttendMettings (List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> {
            return i1.start - i2.start;
        });

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i-1).end) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [][] intervals = new int[][] {{0,5},{6,8},{7,10},{12,15},{13,17}};
        //int [][] intervals = new int[][] {{5,8}, {9,15}};

        ArrayList<Interval> intervalsList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            intervalsList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        System.out.println(canAttendMettings(intervalsList));
    }

}
