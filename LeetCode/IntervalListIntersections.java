import java.util.ArrayList;

public class IntervalListIntersections {

    int [] getIntersection (int [] i1, int [] i2) {
        int start = Math.max(i1[0], i2[0]);
        int end = Math.min(i1[1], i2[1]);

        if (start <= end) {
            return new int[] {start, end};
        } else {
            return new int[] {-1, -1};
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int n = firstList.length;
        int m = secondList.length;

        ArrayList<int[]> list = new ArrayList<>();

        while (i < n && j < m) {
            int [] intersect = getIntersection(firstList[i], secondList[j]);

            if (intersect[0] != -1) {
                list.add(intersect);
            }

            if (secondList[j][1] < firstList[i][1]) {
                j++;
            } else {
                i++;
            }
        }

        int[][] returnList = new int[list.size()][2];

        for (i = 0; i < list.size(); i++) {
            returnList[i] = list.get(i);
        }

        return returnList;
    }

}
