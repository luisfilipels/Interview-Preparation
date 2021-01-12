import java.util.ArrayList;
import java.util.Collections;

public class MergeOverlappingIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (x, y) -> {
            return x.start - y.start;
        });

        ArrayList<Interval> returnArray = new ArrayList<>();

        Interval currentInterval = intervals.get(0);
        int n = intervals.size();

        for (int i = 1; i < n; i++) {
            Interval current = intervals.get(i);
            int start = Math.max(currentInterval.start, current.start);
            int end = Math.min(currentInterval.end, current.end);

            if (start <= end) {
                currentInterval.end = Math.max(currentInterval.end, current.end);
            } else {
                returnArray.add(currentInterval);
                currentInterval = current;
            }
        }
        returnArray.add(currentInterval);

        return returnArray;
    }
}
