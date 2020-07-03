package Extras.HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CountTriplets {

    // DO NOT SORT THE ARRAY! THE QUESTION EXPLICITLY ASKS FOR INDICES IN THE ORIGINAL ARRAY!
    // https://www.youtube.com/watch?v=tBFZMaWP0W8

    static long countTriplets (List<Long> arr, long r) {
        HashMap<Long, Long> hashLeft = new HashMap<>();
        HashMap<Long, Long> hashRight = new HashMap<>();

        for (long l : arr) {
            hashRight.put(l, hashRight.getOrDefault(l, 0L) + 1);
        }

        long count = 0;

        for (int j = 0; j < arr.size(); j++) {
            long mid = arr.get(j);
            long getLeft = 0, getRight = 0;

            hashRight.put(mid, hashRight.getOrDefault(mid, 0L) - 1);

            if (hashLeft.containsKey(mid / r) && mid % r == 0) {
                getLeft = hashLeft.get(mid/r);
            }

            if (hashRight.containsKey(mid * r)) {
                getRight = hashRight.get(mid * r);
            }

            count += getLeft * getRight;

            hashLeft.put(mid, hashLeft.getOrDefault(mid, 0L) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        //long [] arr = new long[] {1L, 3L, 9L, 9L, 27L, 81L};
        long [] arr = new long[] {1L, 2L, 1L, 2L, 4L};
        ArrayList<Long> list = new ArrayList<>();
        for (long l : arr) {
            list.add(l);
        }
        /*list.add(1L);
        list.add(4L);
        list.add(16L);
        list.add(64L);*/

        System.out.println(countTriplets(list, 2L));
    }

}
