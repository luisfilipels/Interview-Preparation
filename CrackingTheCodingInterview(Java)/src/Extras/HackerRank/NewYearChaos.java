package Extras.HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    static int indexOf (int i, int[]q) {
        for (int j = 0; j < q.length; j++) {
            if (q[j] == i) {
                return j;
            }
        }
        return i;
    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        for (int i = 0; i < q.length; i++) {
            q[i]--;
        }
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - i > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Integer.max(0, q[i]-2); j < i + 1; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int [] queue = {2, 1, 5, 3, 4};
        minimumBribes(queue);
        /*int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();*/
    }
}

