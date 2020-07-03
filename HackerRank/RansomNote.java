package Extras.HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> countWords = new HashMap<>();
        for (String s : magazine) {
            if (!countWords.containsKey(s)) {
                countWords.put(s, 1);
            } else {
                int count = countWords.get(s);
                countWords.replace(s, count+1);
            }
        }
        for (int i = 0; i < note.length; i++) {
            if (!countWords.containsKey(note[i])) {
                System.out.println("No");
                return;
            } else {
                int count = countWords.get(note[i]);
                if (count == 0) {
                    System.out.println("No");
                    return;
                }
                countWords.replace(note[i], count-1);
            }
        }
        System.out.println("Yes");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String [] magazine = {"give", "me", "one", "grand", "today", "night"};
        String [] note = {"give", "me", "one", "grand", "today"};
        //String [] magazine = {"two", "times", "three", "is", "not", "four"};
        //String [] note = {"two", "times", "two", "is", "four"};
        checkMagazine(magazine, note);
        /*String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();*/
    }
}
