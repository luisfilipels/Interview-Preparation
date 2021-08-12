import java.util.*;

public class SlidingPuzzle {

    static class Board implements Cloneable{
        int[][] configuration;
        int zeroRow = 0;
        int zeroCol = 0;

        Board(int[][] configuration) {
            this.configuration = new int[2][3];
            for (int r = 0; r < configuration.length; r++) {
                for (int c = 0; c < configuration[0].length; c++) {
                    this.configuration[r][c] = configuration[r][c];
                    if (configuration[r][c] == 0) {
                        zeroRow = r;
                        zeroCol = c;
                    }
                }
            }
        }

        private Board() { }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            super.clone();
            Board board = new Board();
            board.configuration = new int[2][3];
            for (int r = 0; r < configuration.length; r++) {
                for (int c = 0; c < configuration[0].length; c++) {
                    if (this.configuration[r][c] == 0) {
                        board.zeroRow = r;
                        board.zeroCol = c;
                    }
                    board.configuration[r][c] = this.configuration[r][c];
                }
            }
            return board;
        }

        private void swap(int r1, int c1, int r2, int c2) {
            int temp = configuration[r1][c1];
            configuration[r1][c1] = configuration[r2][c2];
            configuration[r2][c2] = temp;
        }

        public List<Board> getAllNeighbors() throws CloneNotSupportedException {
            List<Board> returnList = new ArrayList<>();

            if (zeroRow + 1 < 2) {
                swap(zeroRow, zeroCol, zeroRow+1, zeroCol);
                returnList.add((Board) this.clone());
                swap(zeroRow, zeroCol, zeroRow+1, zeroCol);
            }
            if (zeroRow - 1 >= 0) {
                swap(zeroRow, zeroCol, zeroRow-1, zeroCol);
                returnList.add((Board) this.clone());
                swap(zeroRow, zeroCol, zeroRow-1, zeroCol);
            }
            if (zeroCol + 1 < 3) {
                swap(zeroRow, zeroCol, zeroRow, zeroCol+1);
                returnList.add((Board) this.clone());
                swap(zeroRow, zeroCol, zeroRow, zeroCol+1);
            }
            if (zeroCol - 1 >= 0) {
                swap(zeroRow, zeroCol, zeroRow, zeroCol-1);
                returnList.add((Board) this.clone());
                swap(zeroRow, zeroCol, zeroRow, zeroCol-1);
            }

            return returnList;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Board board = (Board) o;
            return Arrays.deepEquals(configuration, board.configuration);
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(configuration);
        }

        @Override
        public String toString() {
            return "Board{" +
                    "configuration=" + Arrays.deepToString(configuration) +
                    '}';
        }
    }

    public static int slidingPuzzle(int[][] board) {
        final int[][] targetBoard = new int[][] {
                {1, 2, 3},
                {4, 5, 0}
        };

        Queue<Board> queue = new ArrayDeque<>();
        Board initialBoard = new Board(board);
        Board finalBoard = new Board(targetBoard);
        queue.add(initialBoard);
        HashSet<Board> visited = new HashSet<>();
        visited.add(initialBoard);

        if (initialBoard.equals(finalBoard)) return 0;

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                Board currentBoard = queue.poll();
                try {
                    List<Board> neighbors = currentBoard.getAllNeighbors();
                    for (Board b : neighbors) {
                        if (b.equals(finalBoard)) return distance;
                        if (visited.contains(b)) continue;
                        queue.add(b);
                        visited.add(b);
                    }
                } catch (CloneNotSupportedException e) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][][] boards = new int[][][] {
                {
                    {1,2,3},
                    {4,0,5}
                },
                {
                    {1,2,3},
                    {5,4,0}
                },
                {
                    {4,1,2},
                    {5,0,3}
                },
                {
                    {3,2,4},
                    {1,5,0}
                },
        };

        int[] results = new int[] {1, -1, 5, 14};

        for (int i = 0; i < results.length; i++) {
            int res = slidingPuzzle(boards[i]);
            if (results[i] != res) System.out.println("NO, expected " + results[i] + ", got " + res);
            else System.out.println("YES");
        }
    }

}
