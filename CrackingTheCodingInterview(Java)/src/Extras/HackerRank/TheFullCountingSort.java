package Extras.HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TheFullCountingSort {

    // For this one, just do all the work on main, as the time taken by the I/O + the time taken by actually solviung the
    // problem results in a TLE. So, it's better to just do I/O + processing in one go.

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(i, new ArrayList<>());
        }

        ArrayList<StringBuilder> count = new ArrayList<>(101);
        for (int i = 0; i < 101; i++) {
            count.add(i, new StringBuilder());
        }

        for (int i = 0; i < n; i++) {
            String[] tmp = bufferedReader.readLine().split(" ");

            int currentIndex = Integer.parseInt(tmp[0]);
            String currentString = tmp[1];
            if (i >= arr.size()/2) {
                count.get(currentIndex).append(currentString).append(" ");
            } else {
                count.get(currentIndex).append("- ");
            }
        }

        StringBuilder response = new StringBuilder();
        for (StringBuilder sb : count) {
            response.append(sb);
        }

        System.out.println(response.toString());

        bufferedReader.close();
    }

}
