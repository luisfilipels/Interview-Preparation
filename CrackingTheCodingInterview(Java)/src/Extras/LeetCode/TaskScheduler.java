package Extras.LeetCode;

import java.util.Arrays;

public class TaskScheduler {

    static private int leastInterval (char [] tasks, int n) {
        int[] count = new int[26];
        for (char c: tasks)
            count[c - 'A']++;
        Arrays.sort(count);
        int time = 0;
        while (count [25] != 0) {
            int i = 0;
            while (i <= n) {
                if (count[25] == 0) break;
                if (i < 26 && count[25-i] > 0) count[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(count);
        }
        return time;
    }

    public static void main(String[] args) {
        String input = "AAABBBBCCD";
        System.out.println(leastInterval(input.toCharArray(), 3));
    }
}
