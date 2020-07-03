package Extras.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class ImageEditing {

    public static int largestMatrix(List<List<Integer>> arr) {
        int [][] maxArray = new int[arr.size()][arr.size()];
        int maxSquareSize = 0;
        for (int i = 0; i < maxArray.length; i++) {
            maxArray[0][i] = arr.get(0).get(i);
            maxArray[i][0] = arr.get(i).get(0);
        }
        for (int i = 1; i < arr.size(); i++) {
            for (int j = 1; j < arr.size(); j++) {
                if (arr.get(i).get(j) == 1) {
                    int sizeLeft = maxArray[i][j-1];
                    int sizeTop = maxArray[i-1][j];
                    int sizeTopLeft = maxArray[i-1][j-1];
                    int canSquareLeftAndTop = Math.min(sizeLeft, sizeTop);
                    maxArray[i][j] = Math.min(sizeTopLeft, canSquareLeftAndTop) + 1;
                    maxSquareSize = Math.max(maxSquareSize, maxArray[i][j]);
                }
            }
        }
        return maxSquareSize;
    }

    public static void main(String[] args) {
        int array[][] = {
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 0, 1},
        };
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < array.length; j++) {
                list.get(i).add(array[i][j]);
            }
        }
        System.out.println(largestMatrix(list));

    }

}
