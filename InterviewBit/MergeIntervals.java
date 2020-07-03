package Extras.InterviewBit;

import java.util.ArrayList;

public class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval () {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Boolean> overlaps = new ArrayList<>();
        if (intervals.size() == 0 || newInterval.start > intervals.get(intervals.size()-1).start) {
            intervals.add(newInterval);
            return intervals;
        }
        for (int i = 0; i < intervals.size(); i++) {
            overlaps.add(true);
        }
        for (Interval interval : intervals) {
            if (Math.max(newInterval.start, interval.start) > Math.min(newInterval.end, interval.end)) {
                overlaps.set(intervals.indexOf(interval), false);
            }
        }
        int firstStart = newInterval.start;
        int lastEnd = newInterval.end;
        for (int i = 0; i < overlaps.size(); i++) {
            if (overlaps.get(i)) {
                firstStart = intervals.get(i).start;
                break;
            }
        }
        for (int i = overlaps.size()-1; i > 0; i--) {
            if (overlaps.get(i)) {
                lastEnd = intervals.get(i).end;
                break;
            }
        }
        for (int i = 0; i < overlaps.size(); i++) {
            while (overlaps.get(i)) {
                overlaps.remove(i);
                intervals.remove(i);
                if (intervals.size() == 0) {
                    intervals.add(newInterval);
                    return intervals;
                }
            }
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > firstStart) {
                intervals.add(i, new Interval(Math.min(firstStart, newInterval.start), Math.max(lastEnd, newInterval.end)));
                break;
            }
        }
        return intervals;

    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        //intervals.add(new Interval(3, 5));
        //intervals.add(new Interval(7, 9));
        insert(intervals, new Interval(1, 10));


        /*intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        insert(intervals, new Interval(4, 9));
        */
        for (Interval interval : intervals) {
            for (int i = 0; i < 1; i++) {
                System.out.print(interval.start);
                System.out.print(" ");
                System.out.print(interval.end);
            }
            System.out.println();
        }

    }
}
