package Extras.LeetCode;

import java.util.*;

public class MeetingRoomsII {

    private static class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }

    /*
    Start by sorting, as is usually done in these kinds of questions.
    Next, create a Priority Queue that will hold ends of intervals. Why? For example:

    0----------------11
       5-----------9
          6-------8

    If we start by adding the end of [0 11], and compare that end with the start of the next interval, if we see
    that the start is less than such end, that means we have a conflict, and thus must add 1 to our counter. If at some
    point we see that the start of the current interval is greater than the value in our priority queue, we pop said value
    and continue, as to mean we have ended the meeting of some room.

     */
    private static int minMeetingRooms (Interval [] intervals) {
        Arrays.sort(intervals, (int1, int2) -> {
            return int1.start - int2.start;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int maxSize = 0;
        for (Interval interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval.end);
            } else {
                if (interval.start < pq.peek()) {
                    pq.offer(interval.end);
                } else {
                    while (!pq.isEmpty() && interval.start >= pq.peek()) {
                        pq.poll();
                    }
                    pq.offer(interval.end);
                }
            }
            maxSize = Math.max(maxSize, pq.size());
        }
        return maxSize;
    }

    // Simpler answer, but not as easy to understand
    /*private static int minMeetingRooms (Interval [] intervals) {
        int count = 0;
        PriorityQueue<Integer> boundingEnds = new PriorityQueue<>();
        for (Interval current : intervals) {
            if (boundingEnds.isEmpty()) {
                boundingEnds.offer(current.end);
                count++;
            } else {
                if (current.start <= boundingEnds.peek()) {
                    count++;
                    boundingEnds.offer(current.end);
                } else {
                    boundingEnds.poll();
                }
            }
        }
        return count;
    }*/

    public static void main(String[] args) {
        int [][] intervals = new int[][] {
                //{5, 13}, {12, 13}, {0, 11}, {7,8}, {15, 20}
                //{0, 11}, {5, 16}, {7,8}, {15, 20}, {16, 20}, {17, 19}, {18, 19}
                {1,18}, {18,23}, {15,29},{4,15}, {2, 11}, {5, 13}
        };



        Interval[] inputs = new Interval[intervals.length];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        System.out.println(minMeetingRooms(inputs));
    }

}
