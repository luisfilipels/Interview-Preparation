import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorII {

    /*private static int[] getNumber (String s, int start) {
        int j = start;
        StringBuilder sb = new StringBuilder();
        while (j < s.length() && Character.isDigit(s.charAt(j))) {
            sb.append(s.charAt(j));
            j++;
        }
        return new int[] {j, Integer.parseInt(sb.toString())};
    }*/

    static int compute (int num1, int num2, char oper) {
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

    private static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        boolean isMultDiv = false;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') continue;
            if (Character.isDigit(s.charAt(i))) {
                int total = 0;
                int exp = 1;
                while(i >= 0 && Character.isDigit(s.charAt(i))) {
                    total += (s.charAt(i) - '0') * exp;
                    exp *= 10;
                    i--;
                }
                i++;
                numStack.add(total);
            } else {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    if (isMultDiv) {
                        isMultDiv = false;
                        while (!opStack.isEmpty() && (opStack.peek() == '*' || opStack.peek() == '/')) {
                            int num1 = numStack.pop();
                            int num2 = numStack.pop();
                            char op = opStack.pop();

                            int result = compute(num1, num2, op);

                            numStack.push(result);
                        }
                    }
                    opStack.push(s.charAt(i));
                } else {
                    opStack.push(s.charAt(i));
                    isMultDiv = true;
                }
            }
        }

        while (!opStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char op = opStack.pop();

            int result = compute(num1, num2, op);

            numStack.push(result);
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
        //String s = "3+2*2*3+5-2/2*3";
        //String s = "1-1+1";
        String s= "32 + 5 / 2";
        System.out.println(calculate(s));
    }

}
