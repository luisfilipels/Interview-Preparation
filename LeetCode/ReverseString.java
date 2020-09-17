import java.util.Stack;

public class ReverseString {

    static void swap (char [] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    // Optimal solution, two pointers. Time: O(n) Space: O(1)
    static public void reverseString(char[] s) {
        int n = s.length;
        int left = 0, right = n-1;

        while (left < right) {
            swap(s, left, right);
            left++; right--;
        }
    }

    // Stack solution. Time O(n), Space O(n). Doesn't obey question constraints, but is another way to face the problem.
    static public void reverseString2 (char[] s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s) {
            stack.push(c);
        }
        int n = s.length;
        for (int i = 0; i < n; i++) {
            s[i] = stack.pop();
        }
    }

    // Recursive solution. Same complexity as reverseString2
    static public void reverseString3 (char[] s) {
        reverseString3Helper(s, 0, s.length-1);
    }

    static public void reverseString3Helper (char[] s, int left, int right) {
        if (left > right) return;
        swap(s, left, right);
        reverseString3Helper(s, left+1, right-1);
    }

    public static void main(String[] args) {
        String s = "tas";
        char[] sar = s.toCharArray();
        reverseString3(sar);
        System.out.println(sar);
    }

}
