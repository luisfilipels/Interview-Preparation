package Extras.HackerRank;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.*;

public class StringComparator {

    static class Player {
        String name;
        int score;


    }

    static class Checker implements Comparator<Player> {
        public int compare(Player a, Player b) {
            if (a.score == b.score) {
                int n = Math.min(a.name.length(), b.name.length());
                for (int i = 0; i < n; i++) {
                    char charA = a.name.charAt(i);
                    char charB = b.name.charAt(i);
                    if (charA != charB) {
                        return charA - charB;
                    }
                }
                return a.name.length() - b.name.length();   // Remember to take care of the case in which a.name and b.name are the same until the last char of the smallest name!
            }

            return b.score - a.score;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name());
        String content = scanner.next();
        int caseCount = Integer.parseInt(content);
        ArrayList<Player> arr = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < caseCount; i++) {
            content = scanner.nextLine();
            String[] tokens = content.split(" ");
            Player p = new Player();
            p.name = tokens[0];
            p.score = Integer.parseInt(tokens[1]);
            arr.add(p);
        }
        Checker c = new Checker();
        Collections.sort(arr, c);
        for (Player p: arr) {
            System.out.println(p.name + " " + p.score);
        }
    }



}
