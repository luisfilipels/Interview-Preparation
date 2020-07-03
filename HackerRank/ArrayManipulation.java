package Extras.HackerRank;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayManipulation {

    // Correct solution
    /*
    Consider n = 12, and queries =
        {1 10  2}
        {2 6   3}
        {5 11 11}
        {7 12 12}

    The intervals represented are:

                  |--------|        -> 12
                  7        12
             |----------|           -> 11
             5         11
       |-------|                    -> 3
       2       6
    |-----------------|             -> 2
    1                 10

    If we were to overlap and add each of these intervals, we would have the following array:

    1dx =  1  2  3  4   5   6   7   8   9  10  11  12
    arr = [2, 5, 5, 5, 16, 16, 25, 25, 25, 25, 23, 12]
    idx =  0  1  2  3   4   5   6   7   8   9  10  11

    Consider each element of the above array. Its value increases when we reach a value of 1idx in which there is the
    beginning of an interval, and decreases when we reach a value of 1idx in which there is the end of an interval.
    Knowing this, we can create an array of size 'n', in which each position will represent the net increment (or
    decrement) that happens at that position. When that is done, we can iterate through each value of this array, adding
    up each position, and keeping track of the maximum value we have seen so far.

     */
    static long arrayManipulation (int n, int [][] queries) {
        long [] arr = new long[n];
        for (int [] query : queries) {
            arr[query[0]-1] += query[2];
            if (query[1] != arr.length) {
                arr[query[1]] -= query[2];
            }
        }
        long itt = 0;
        long returnValue = Long.MIN_VALUE;
        for (long i : arr) {
            itt += i;
            returnValue = Math.max(returnValue, itt);
        }
        return returnValue;
    }

    // "Brute force" solution.
    /*static long arrayManipulation (int n, int [][] queries) {
        long [] returnArray = new long[n];
        long maximum = Long.MIN_VALUE;
        for (int [] interval : queries) {
            for (int i = interval[0] - 1; i <= interval[1] - 1; i++) {
                returnArray[i] += interval[2];
                maximum = Math.max(returnArray[i], maximum);
            }
        }
        System.out.println(Arrays.toString(returnArray));
        return maximum;
    }*/



    public static void main(String[] args) {
        int [][] queries = new int[][] {
                {1, 10, 2},
                {2, 6, 3},
                {5, 11, 11},
                {7, 12, 12}
        };
        System.out.println(arrayManipulation(12, queries));
    }

}
