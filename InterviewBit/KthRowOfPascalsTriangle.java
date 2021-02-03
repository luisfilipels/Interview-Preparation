import java.util.ArrayList;

public class KthRowOfPascalsTriangle {

    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> returnList = new ArrayList<>();
        returnList.add(1);
        if (A == 0) return returnList;

        returnList.add(1);
        if (A == 1) return returnList;

        ArrayList<Integer> temp;

        for (int i = 2; i <= A; i++) {
            temp = returnList;
            returnList = new ArrayList<>();
            returnList.add(1);
            for (int j = 1; j < i; j++) {
                returnList.add(temp.get(j) + temp.get(j-1));
            }
            returnList.add(1);
        }

        return returnList;
    }

}
