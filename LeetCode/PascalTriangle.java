import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    private static List<List<Integer>> generate (int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();

        if (numRows == 0) return returnList;
        returnList.add(new ArrayList<>());
        returnList.get(0).add(1);
        if (numRows == 1) return returnList;

        for (int row = 1; row < numRows; row++) {
            returnList.add(new ArrayList<>());
            int currentRowIdx = returnList.size() - 1;
            returnList.get(currentRowIdx).add(1);
            for (int i = 1; i < returnList.get(currentRowIdx-1).size(); i++) {
                returnList.get(currentRowIdx).add(returnList.get(currentRowIdx-1).get(i) + returnList.get(currentRowIdx-1).get(i-1));
            }
            returnList.get(currentRowIdx).add(1);
        }

        return returnList;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

}
