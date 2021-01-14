import java.util.ArrayList;

public class AntiDiagonals {

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> returnArray = new ArrayList<>();

        int n = A.size();


        for (int c = 0; c < n; c++) {
            int r = 0;
            int tempC = c;
            returnArray.add(new ArrayList<>());
            ArrayList<Integer> ref = returnArray.get(returnArray.size()-1);
            while(tempC >= 0) {
                ref.add(A.get(r).get(tempC));
                tempC--;
                r++;
            }
        }

        for (int r = 1; r < n; r++) {
            int c = n-1;
            int tempR = r;
            returnArray.add(new ArrayList<>());
            ArrayList<Integer> ref = returnArray.get(returnArray.size()-1);
            while(tempR < n) {
                ref.add(A.get(tempR).get(c));
                c--;
                tempR++;
            }
        }

        return returnArray;
    }

}
