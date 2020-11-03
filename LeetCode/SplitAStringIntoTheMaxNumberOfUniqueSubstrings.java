import java.util.HashSet;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

    private static int maxUniqueSplit (String s) {
        HashSet<String> result = new HashSet<>();
        int[] max = new int[1];

        getSplit(s, 0, result, max);

        return max[0];
    }

    private static void getSplit(String s, int currentIndex, HashSet<String> uniques, int[] max) {
        if (currentIndex >= s.length()) {
            max[0] = Math.max(max[0], uniques.size());
            return;
        }

        for (int endIndex = currentIndex+1; endIndex <= s.length(); endIndex++) {
            String sub = s.substring(currentIndex, endIndex);
            if (uniques.contains(sub)) continue;
            uniques.add(sub);
            getSplit(s, endIndex, uniques, max);
            uniques.remove(sub);
        }
    }

    public static void main(String[] args) {
        String s = "aba";

        System.out.println(maxUniqueSplit(s));
    }

}

