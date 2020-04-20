package Extras.LeetCode;

import java.util.Stack;

public class PerformStringShifts {

    public static void main(String[] args) {
        /*String s = "mecsk";
        int [][] shift = new int[][] {
                {1,4},
                {0,5},
                {0,4},
                {1,1},
                {1,5},
        };*/
        String s = "wpdhhcj";
        int [][] shift = new int[][] {
                {0,7},
                {1,7},
                {1,0},
                {1,3},
                {0,3},
                {0,6},
                {1,2},
        };
        System.out.println(stringShift(s, shift));
    }

    public static String stringShift(String s, int[][] shift) {
        Stack<int[]> stack = new Stack<>();
        for (int[] arr : shift) {
            stack.push(arr);
        }
        int [] current = shift[shift.length-1];
        int i = shift.length-2;
        while(i >= 0) {
            int [] currentStack = shift[i--];
            if (currentStack[0] == current[0]) {
                current[1] += currentStack[1];
            } else {
                if (currentStack[1] > current[1]) {
                    current[0] = currentStack[0];
                    current[1] = currentStack[1] - current[1];
                } else {
                    current[1] = current[1] - currentStack[1];
                }
            }
        }
        if (current[1] == s.length()) return s;
        if (current[1] > s.length()) current[1] = current[1] % s.length();
        StringBuilder returnString = new StringBuilder();
        if (current[0] == 0) {
            for (int j = current[1]; j < s.length(); j++) {
                returnString.append(s.charAt(j));
            }
            for (int j = 0; j < current[1]; j++) {
                returnString.append(s.charAt(j));
            }
            return returnString.toString();
        } else {
            for (int j = s.length() - current[1]; j < s.length(); j++) {
                returnString.append(s.charAt(j));
            }
            for (int j = 0; j < s.length() - current[1]; j++) {
                returnString.append(s.charAt(j));
            }
            return returnString.toString();
        }


    }

}
