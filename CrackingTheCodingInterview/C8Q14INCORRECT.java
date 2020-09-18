import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class C8Q14INCORRECT {

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

    private static int booleanEvaluation (String eval, boolean desiredResult, HashMap<String, Integer> memo) {
        if (eval.length() == 1) {
            boolean result = eval.charAt(0) == '1';
            return result == desiredResult ? 1 : 0;
        }
        if (memo.containsKey(eval)) return memo.get(eval);
        int sumResult = 0;
        for (int i = 0; i < eval.length(); i++) {
            if (i != eval.length()-1 && (eval.charAt(i) == '0' || eval.charAt(i) == '1')) {
                char eval1 = eval.charAt(i);
                char oper = eval.charAt(i+1);
                char eval2 = eval.charAt(i+2);

                String newString = eval.substring(0, i) + result(eval1, oper, eval2) + eval.substring(i+3, eval.length());
                sumResult += booleanEvaluation(newString, desiredResult, memo);
            }
        }
        memo.put(eval, sumResult);
        return sumResult;
    }

    public static void main(String[] args) {
        System.out.println(booleanEvaluation("1^0|0|1", false, new HashMap<>()));
        System.out.println(booleanEvaluation("0&0&0&1^1|0", true, new HashMap<>()));
    }

}
