import java.util.*;

public class KthSmallestElementInASortedMatrix {

    static class Element {
        int r, c;
        int value;

        Element(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    private static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>(
                Comparator.comparingInt(x -> x.value)
        );

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        pq.add(new Element(0, 0, matrix[0][0]));
        ArrayList<Integer> arr = new ArrayList<>();
        while (arr.size() < k) {
            Element top = pq.poll();
            arr.add(top.value);
            int r = top.r;
            int c = top.c;
            if (r + 1 < matrix.length && !visited[r+1][c]) {
                visited[r+1][c] = true;
                pq.add(new Element(r+1, c, matrix[r+1][c]));
            }
            if (c + 1 < matrix[0].length && !visited[r][c+1]) {
                visited[r][c+1] = true;
                pq.add(new Element(r, c+1, matrix[r][c+1]));
            }
        }
        return arr.get(arr.size()-1);
    }

    public static void main(String[] args) {
        int [][] matrix = new int[][] {
                {1, 5,  9},
                {10,11,13},
                {12,13,15},
        };
        System.out.println(kthSmallest(matrix, 8));
    }

}
