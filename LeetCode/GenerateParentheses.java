package Extras.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    static public List<String> generateParenthesis(int n) {
        List<String> returnList = new ArrayList<>();
        helperMethod(returnList, "", n, n);
        return returnList;
    }

    static private void helperMethod(List<String> returnList, String current, int left, int right) {
        if ((left == 0 && right == 0)) {
            returnList.add(current);
        }
        if (right < left || right == -1 || left == -1) {
            return;
        }
        helperMethod(returnList, current + "(", left-1, right);
        helperMethod(returnList, current + ")", left, right-1);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

}
