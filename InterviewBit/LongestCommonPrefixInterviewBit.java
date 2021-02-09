import java.util.ArrayList;

public class LongestCommonPrefixInterviewBit {

    int minSize (ArrayList<String> A) {
        int min = Integer.MAX_VALUE;

        for (String s : A) {
            min = Math.min(min, s.length());
        }

        return min;
    }

    public String longestCommonPrefix(ArrayList<String> A) {
        int min = minSize(A);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < min; i++) {
            Character current = null;
            for (String s : A) {
                if (current == null) {
                    current = s.charAt(i);
                } else {
                    if (s.charAt(i) != current) {
                        return sb.toString();
                    }
                }
            }
            sb.append(current);
        }

        return sb.toString();
    }

}
