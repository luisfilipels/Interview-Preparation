import java.util.Stack;

public class EvalReversePolishNotation {

    private static int runFunction(int num1, int num2, char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }

    private static int evalRPN (String [] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.length() >= 2 || (Character.isDigit(token.charAt(0)))) {
                int val = Integer.parseInt(token);
                stack.push(val);
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();

                stack.push(runFunction(num2, num1, token.charAt(0)));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[] {
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        };

        System.out.println(evalRPN(tokens));
    }

}
