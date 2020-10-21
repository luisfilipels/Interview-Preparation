package Extras.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    static public List<String> generateParenthesis(int n) {
        List<String> returnList = new ArrayList<>();
        helperMethod(returnList, "", n, n);
        return returnList;
    }

    static private void helperMethod(List<String> returnList, String current, int needToOpen, int needToClose) {
        if ((needToOpen == 0 && needToClose == 0)) {
            returnList.add(current);
        }
        if (needToClose < needToOpen || needToClose == -1 || needToOpen == -1) {
            return;
        }
        helperMethod(returnList, current + "(", needToOpen-1, needToClose);
        helperMethod(returnList, current + ")", needToOpen, needToClose-1);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
