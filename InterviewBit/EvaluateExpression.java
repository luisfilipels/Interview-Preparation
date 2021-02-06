import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

public class EvaluateExpression {

    static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    static int operation(int y, int x, char oper) {
        switch (oper) {
            case '+': return y + x;
            case '-': return y - x;
            case '*': return y * x;
            case '/': return y / x;
        }
        return 0;
    }

    static public int evalRPN(ArrayList<String> A) {

        Stack<Integer> stack = new Stack<>();

        for (String s : A) {
            if (isNumeric(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                char oper = s.charAt(0);
                int x = stack.pop();
                int y = stack.pop();
                stack.push(operation(y, x, oper));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = new String[] {
            "5", "1", "2", "+", "4", "*", "+", "3", "-"
        };

        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));

        System.out.println(evalRPN(list));
    }

}
