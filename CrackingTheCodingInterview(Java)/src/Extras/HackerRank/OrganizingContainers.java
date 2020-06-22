package Extras.HackerRank;

import java.util.ArrayList;
import java.util.Collections;

public class OrganizingContainers {

    static String organizingContainers(int [][] container) {
        ArrayList<Long> sumRows = new ArrayList<>();
        ArrayList<Long> sumCols = new ArrayList<>();

        for (int l = 0; l < container.length; l++) {
            long currSum = 0;
            for (int c = 0; c < container[0].length; c++) {
                currSum += container[l][c];
            }
            sumRows.add(currSum);
        }

        for (int c = 0; c < container.length; c++) {
            long currSum = 0;
            for (int l = 0; l < container[0].length; l++) {
                currSum += container[l][c];
            }
            sumCols.add(currSum);
        }

        Collections.sort(sumCols);
        Collections.sort(sumRows);

        if (sumCols.equals(sumRows)) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {0,2,1},
                {1,1,1},
                {2,0,0}
        };
        System.out.println(organizingContainers(input));
    }

}
