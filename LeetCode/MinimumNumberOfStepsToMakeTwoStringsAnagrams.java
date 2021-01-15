public class MinimumNumberOfStepsToMakeTwoStringsAnagrams {
    public int minSteps(String s, String t) {
        int n = s.length();

        int [] countS = new int[26];
        for (char c : s.toCharArray()) {
            countS[c - 'a']++;
        }

        int [] countT = new int[26];
        for (char c : t.toCharArray()) {
            countT[c - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.min(countS[i], countT[i]);
        }

        return n - count;
    }
}
