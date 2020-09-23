import java.util.HashMap;

public class C8Q14REVIEW {

    private static char result(char c1, char oper, char c2) {
        switch (oper) {
            case '|':
                if (c1 == '0' && c2 == '0') return '0';
                else return '1';
            case '&':
                if (c1 == '1' && c2 == '1') return '1';
                else return '0';
            case '^':
                if (c1 != c2) return '1';
                else return '0';
        }
        return '*';
    }

    static boolean charToBool(char c) {
        return c == '1';
    }

    private static int booleanEvaluation (String eval, boolean desiredResult) {
        //return booleanEvaluation(eval, desiredResult, new HashMap<>());
        return countEval(eval, desiredResult, new HashMap<>());
    }

    /*private static int booleanEvaluation (String eval, boolean desiredResult, HashMap<String, Integer> memo) {
        if (eval.length() == 0) return 0;
        if (eval.length() == 1) {
            return charToBool(eval.charAt(0)) == desiredResult ? 1 : 0;
        }
        int sumResult = 0;
        for (int i = 0; i < eval.length()-1; i += 2) {
            char eval1 = eval.charAt(i);
            char oper = eval.charAt(i+1);
            char eval2 = eval.charAt(i+2);

            String newString = eval.substring(0, i) + result(eval1, oper, eval2) + eval.substring(i+3, eval.length());
            //if (memo.containsKey(newString)) sumResult += memo.get(newString);
            sumResult += booleanEvaluation(newString, desiredResult, memo);
        }
        //memo.put(eval, sumResult);
        return sumResult;
    }*/

    private static int countEval (String s, boolean result, HashMap<String, Integer> memo) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return charToBool(s.charAt(0)) == result ? 1 : 0;
        if (memo.containsKey(result + s)) return memo.get(result + s);

        int ways = 0;
        for (int i = 1; i < s.length(); i+=2) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i+1, s.length());
            int leftTrue = countEval(left, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightTrue = countEval(right, true, memo);
            int rightFalse = countEval(right, false, memo);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if (c == '^') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }

        memo.put(result + s, ways);
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(booleanEvaluation("1^0|0|1", false));
        System.out.println(booleanEvaluation("0&0&0&1^1|0", true));
        System.out.println(booleanEvaluation("1&0&0|1", true));
    }

}
