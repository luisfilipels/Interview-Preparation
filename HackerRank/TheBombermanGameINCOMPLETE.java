package Extras.HackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TheBombermanGameINCOMPLETE {

    static class Coordinate {
        int row, column;

        Coordinate(int r, int c) {
            row = r;
            column = c;
        }
    }

    static boolean isValid (int r, int c, int[][] seconds) {
        if (r >= 0 && r < seconds.length && c >= 0 && c < seconds[0].length) {
            return true;
        }
        return false;
    }

    static String[] bomberMan (int n, String[] grid) {
        int [][] seconds = new int[grid.length][grid[0].length()];
        int currentTime = 0;
        String[] response = new String[seconds.length];

        if (n >= 4 && n % 2 == 0) {
            for (int r = 0; r < seconds.length; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < seconds[0].length; c++) {
                    sb.append('O');
                }
                response[r] = sb.toString();
            }
            return response;
        }

        for (int l = 0; l < grid.length; l++) {
            for (int c = 0; c < grid[0].length(); c++) {
                if (grid[l].charAt(c) == 'O') {
                    seconds[l][c] = 4; // Bomb
                } else {
                    seconds[l][c] = -1; // Empty
                }
            }
        }

        while (currentTime <= n) {
            for (int l = 0; l < grid.length; l++) { // Reduce timers
                for (int c = 0; c < grid[0].length(); c++) {
                    if (seconds[l][c] > 0) {
                        seconds[l][c]--;
                    }
                }
            }

            if (currentTime < 2) {
                currentTime++;
                continue;
            }

            if (currentTime % 2 == 0) { // Plant bombs
                for (int l = 0; l < grid.length; l++) {
                    for (int c = 0; c < grid[0].length(); c++) {
                        if (seconds[l][c] == -1) {
                            seconds[l][c] = 3;
                        }
                    }
                }
            } // Detonate bombs
                ArrayList<Coordinate> toExplode = new ArrayList<>();
                for (int l = 0; l < grid.length; l++) {
                    for (int c = 0; c < grid[0].length(); c++) {
                        if (seconds[l][c] == 0) {
                            toExplode.add(new Coordinate(l,c));
                            /*seconds[l][c] = -1;
                            if (isValid(l-1, c, seconds)) {
                                seconds[l-1][c] = -1;
                            }
                            if (isValid(l, c-1, seconds)) {
                                seconds[l][c-1] = -1;
                            }
                            if (isValid(l+1, c, seconds)) {
                                seconds[l+1][c] = -1;
                            }
                            if (isValid(l, c+1, seconds)) {
                                seconds[l][c+1] = -1;
                            }*/
                        }
                    }
                }
                for (Coordinate co : toExplode) {
                    int l = co.row;
                    int c = co.column;
                    seconds[l][c] = -1;
                    if (isValid(l - 1, c, seconds)) {
                        seconds[l - 1][c] = -1;
                    }
                    if (isValid(l, c - 1, seconds)) {
                        seconds[l][c - 1] = -1;
                    }
                    if (isValid(l + 1, c, seconds)) {
                        seconds[l + 1][c] = -1;
                    }
                    if (isValid(l, c + 1, seconds)) {
                        seconds[l][c + 1] = -1;
                    }
                }
            currentTime++;
        }

        for (int r = 0; r < seconds.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < seconds[0].length; c++) {
                if (seconds[r][c] == -1) {
                    sb.append('.');
                } else {
                    sb.append('O');
                }
            }
            response[r] = sb.toString();
        }

        return response;
    }

    public static void main(String[] args) {
        /*int n = 3;
        String [] grid = new String[] {
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };*/

        int n = 5;
        String [] grid = new String[] {
                ".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O..."
        };

        String[] response = bomberMan(n, grid);

        for (String s : response) {
            System.out.println(s);
        }
    }

}
