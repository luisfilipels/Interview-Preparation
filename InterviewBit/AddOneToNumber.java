import java.util.ArrayList;

public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int n = A.size();

        int i = 0;
        while (A.get(i) == 0) {
            i++;
        }

        ArrayList<Integer> returnList = new ArrayList<>();

        for (; i < n; i++) {
            returnList.add(A.get(i));
        }

        int m = returnList.size();

        int carry = 1;
        for (i = m-1; i >= 0; i--) {
            returnList.set(i, returnList.get(i) + carry);
            if (!(returnList.get(i) == 0 && carry == 1)) {
                carry = 0;
            }
        }

        if (carry == 1) {
            returnList.add(0, 1);
        }

        return returnList;
    }

}
