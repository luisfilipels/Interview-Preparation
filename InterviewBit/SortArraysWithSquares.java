import java.util.ArrayList;

public class SortArraysWithSquares {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> returnList = new ArrayList<>();

        int n = A.size();
        int r;

        for (r = 0; r < n; r++) {
            int x = A.get(r);
            if (x > 0) {
                break;
            }
        }

        int l = r-1;

        while(r < n && l >= 0) {
            int atRight = A.get(r) * A.get(r);
            int atLeft = A.get(l) * A.get(l);

            if (atRight < atLeft) {
                returnList.add(atRight);
                r++;
            } else {
                returnList.add(atLeft);
                l--;
            }
        }

        if (r == n) {
            while (l >= 0) {
                returnList.add(A.get(l) * A.get(l));
                l--;
            }
        } else if (l < 0) {
            while (r < n) {
                returnList.add(A.get(r) * A.get(r));
                r++;
            }
        }

        return returnList;
    }

}
