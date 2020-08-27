import java.util.ArrayList;
import java.util.HashSet;

public class C8Q9 {

    static void helper (int remain, int owe, StringBuilder current, ArrayList<String> returnList) {
        if (remain == 0 && owe == 0) {
            returnList.add(current.toString());
            return;
        }
        if (remain > 0) {
            helper(remain-1, owe+1, new StringBuilder(current).append("("), returnList);
            if (owe > 0) {
                helper(remain, owe-1, new StringBuilder(current).append(")"), returnList);
            }
        } else {
            for (int i = 0; i < owe; i++) {
                current.append(")");
            }
            helper(0, 0, current, returnList);
        }
    }

    static ArrayList<String> parens (int n) {
        ArrayList<String> result = new ArrayList<>();
        helper(n, 0, new StringBuilder(), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(parens(5));
    }

}
