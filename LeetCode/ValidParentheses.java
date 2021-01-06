import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> lastType = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    lastType.push('(');
                    break;
                case ')':
                    if (lastType.isEmpty() || lastType.peek() != '(') return false;
                    lastType.pop();
                    break;
                case '[':
                    lastType.push('[');
                    break;
                case ']':
                    if (lastType.isEmpty() || lastType.peek() != '[') return false;
                    lastType.pop();
                    break;
                case '{':
                    lastType.push('{');
                    break;
                case '}':
                    if (lastType.isEmpty() || lastType.peek() != '{') return false;
                    lastType.pop();
                    break;
            }

        }

        if (!lastType.isEmpty()) return false;
        return true;
    }

}
