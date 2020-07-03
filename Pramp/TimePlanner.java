package Extras.Pramp;

import java.util.Arrays;

public class TimePlanner {

    static int [] meetingPlanner (int[][] slotsA, int[][] slotsB, int dur) {
        int i = 0, j = 0;
        while (i < slotsA.length && j < slotsB.length) {
            int start = Math.max(slotsA[i][0], slotsB[j][0]);
            int end = Math.min(slotsA[i][1], slotsB[j][1]);

            if (end - start >= dur) {
                return new int[] {start, start + dur};
            }
            if (slotsA[i][1] > slotsB[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        return new int[] {};
    }

    /*
    // First solution. Brute force.
    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    for (int [] arrayA : slotsA) {
      for (int [] arrayB : slotsB) {
        int start = Math.max(arrayA[0], arrayB[0]);
        int end = Math.min(arrayA[1], arrayB[1]);
        if (start < end) {
          if (end - start >= dur) {
            return new int [] {start, start + dur};
          }
        }
      }
    }
    return new int [] {};
  }
     */

    public static void main(String[] args) {
        //int [][] slotsA = new int[][] {{10,50}, {60,120}, {140,210}};
        //int [][] slotsB = new int[][] {{0,15}, {60,70}};
        int [][] slotsA = new int[][] {{0,5},{50,70},{120,125}};
        int [][] slotsB = new int[][] {{0,50}};
        System.out.println(Arrays.toString(meetingPlanner(slotsA, slotsB, 8)));
    }

}
