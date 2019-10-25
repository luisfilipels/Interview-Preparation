package Extras.HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwapsTwo {

    static boolean allTrue (boolean [] arr) {
        for (boolean b : arr) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    static int indexOfNextUnvisited (boolean [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                return i;
            }
        }
        return -1;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
            min = Integer.min(min, x);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= min;
        }
        ArrayList<Integer>[] adjList = new ArrayList[arr.length];
        for (int i = 0; i < arr.length; i++) {
            adjList[arr[i]] = new ArrayList<>();
            adjList[arr[i]].add(arr[arr[i]]);
        }
        boolean [] visited = new boolean[arr.length];
        Deque<Integer> queue = new ArrayDeque<>();
        int ans = 0;
        while (!allTrue(visited)) {
            int nextStart = indexOfNextUnvisited(visited);
            queue.add(nextStart);
            int bfsLength = 0;
            boolean cycleFound = false;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited[current] = true;
                for (int i = 0; i < adjList[i].size(); i++) {
                    if (adjList[current].get(i) == current) {
                        //System.out.println("Found " + (i+1) + " in right position.");
                        break;
                    }
                    if (visited[adjList[current].get(i)]) {
                        bfsLength++;
                        //System.out.println("Cycle found! Length: " + bfsLength);
                        cycleFound = true;
                        queue.clear();
                        break;
                    } else {
                        //System.out.println("Proceeding BFS from " + (current+1) + " to " + (i+1));
                        bfsLength++;
                        queue.add(adjList[current].get(i));
                        visited[adjList[current].get(i)] = true;
                    }
                }
            }
            if (cycleFound) {
                ans += bfsLength - 1;
            }
        }
        return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //int [] arr = {1, 3, 5, 2, 4, 6, 7};
        //int [] arr = {2, 3, 4, 1, 5};
        int [] arr = {4, 3, 1, 2};
        //int [] arr = new int[10000];
        //Scanner s = new Scanner(System.in);
        //for (int i = 0; i < 10000; i++) {
        //    arr[i] = s.nextInt();
        //}
        System.out.println(minimumSwaps(arr));
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}