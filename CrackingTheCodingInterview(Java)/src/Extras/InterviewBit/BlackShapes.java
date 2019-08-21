package Extras.InterviewBit;

import java.util.ArrayList;

public class BlackShapes {

    static public int black(ArrayList<String> A) {
        int n = A.size();
        int m = A.get(0).length();
        int counter = 0;
        boolean [][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).charAt(j) == 'X' && !visited[i][j]) {
                    visit(i, j, visited, A);
                    counter++;
                }
            }
        }
        return counter;

    }

    static void visit(int i, int j, boolean[][]visited, ArrayList<String> A) {
        visited[i][j] = true;
        if (i-1 >= 0 && !visited[i-1][j] && A.get(i-1).charAt(j) == 'X') { // Previous line
            visit(i-1, j, visited, A);
        }
        if (j+1 < visited[i].length && !visited[i][j+1] && A.get(i).charAt(j+1) == 'X') { // Next column
            visit(i, j+1, visited, A);
        }
        if (i+1 < visited.length && !visited[i+1][j] && A.get(i+1).charAt(j) == 'X') { // Next line
            visit(i+1, j, visited, A);
        }
        if (j-1 >= 0 && !visited[i][j-1] && A.get(i).charAt(j-1) == 'X') { // Previous column
            visit(i, j-1, visited, A);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        A.add("OOOXOOO");
        A.add("OOXXXXO");
        A.add("OXXOOXO");

        //A.add("XXX");
        //A.add("OXO");
        //A.add("XXX");

        System.out.println(black(A));
    }

}
