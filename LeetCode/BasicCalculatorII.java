import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorII {

    private static int[] getNumber (String s, int start) {
        int j = start;
        StringBuilder sb = new StringBuilder();
        while (j < s.length() && Character.isDigit(s.charAt(j))) {
            sb.append(s.charAt(j));
            j++;
        }
        return new int[] {j, Integer.parseInt(sb.toString())};
    }

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

    private static int calculate (String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> opStack= new ArrayDeque<>();

        s = s.replaceAll("\\s+", "");

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int[] result = getNumber(s, i);
                i = result[0]-1;
                numStack.addLast(result[1]);
            } else {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    opStack.addLast(s.charAt(i));
                } else {
                    Deque<Integer> numQueue = new ArrayDeque<>();
                    Deque<Character>opQueue = new ArrayDeque<>();

                    numQueue.add(numStack.pollLast());
                    int j = i;
                    for (j = i; j < s.length(); j++) {
                        if (Character.isDigit(s.charAt(j))) {
                            int[] result = getNumber(s, j);
                            j = result[0]-1;
                            numQueue.add(result[1]);
                        } else {
                            if (s.charAt(j) == '+' || s.charAt(j) == '-') {
                                opStack.add(s.charAt(j));
                                break;
                            } else {
                                opQueue.add(s.charAt(j));
                            }
                        }
                    }
                    while(!opQueue.isEmpty()) {
                        int num1 = numQueue.poll();
                        int num2 = numQueue.poll();
                        char op = opQueue.poll();

                        int result = compute(num1, num2, op);

                        numQueue.addFirst(result);
                    }
                    numStack.add(numQueue.poll());
                    i = j;
                }
            }
        }

        while(!opStack.isEmpty()) {
            int num1 = numStack.pollFirst();
            int num2 = numStack.pollFirst();
            char oper = opStack.pollFirst();

            int result = compute(num1, num2, oper);

            numStack.addFirst(result);
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
        //String s = "3+2*2*3+5-2/2*3";
        String s = "1-1+1";
        System.out.println(calculate(s));
    }

}
