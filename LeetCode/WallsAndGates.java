package Extras.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class WallsAndGates {

    private static class Coordinate {
        int line, column;

        Coordinate (int line, int column) {
            this.line = line;
            this.column = column;
        }
    }

    private static boolean isValid (int[][] rooms, int l, int c, int distanceFrom) {
        if (l < rooms.length && l >= 0 && c < rooms[0].length && c >= 0 && rooms[l][c] != 0 && (rooms[l][c] == Integer.MAX_VALUE || rooms[l][c] > distanceFrom)) {
            return true;
        }
        return false;
    }

    private static void wallsAndGates (int[][] rooms) {

        Queue<Coordinate> queue = new ArrayDeque<>();
        for (int l = 0; l < rooms.length; l++) {
            for (int c = 0; c < rooms[0].length; c++) {
                if (rooms[l][c] == 0) {
                    queue.add(new Coordinate(l, c));
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int cl = current.line;
            int cc = current.column;
            if (isValid(rooms, cl + 1, cc, rooms[cl][cc])) {
                rooms[cl+1][cc] = rooms[cl][cc]+1;
                queue.add(new Coordinate(cl+1, cc));
            }
            if (isValid(rooms, cl, cc + 1, rooms[cl][cc])) {
                rooms[cl][cc+1] = rooms[cl][cc]+1;
                queue.add(new Coordinate(cl, cc+1));
            }
            if (isValid(rooms, cl - 1, cc, rooms[cl][cc])) {
                rooms[cl-1][cc] = rooms[cl][cc]+1;
                queue.add(new Coordinate(cl-1, cc));
            }
            if (isValid(rooms, cl, cc - 1, rooms[cl][cc])) {
                rooms[cl][cc-1] = rooms[cl][cc]+1;
                queue.add(new Coordinate(cl, cc-1));
            }
        }
    }

    private static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int [][] rooms = new int[][] {
                {inf, -1, 0, inf},
                {inf, inf, inf, -1},
                {inf, -1, inf, -1},
                {0, -1, inf, inf}
        };
        wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

}
