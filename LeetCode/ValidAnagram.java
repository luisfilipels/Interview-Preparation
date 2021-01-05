public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] countS = new char[26];
        for (char c : s.toCharArray()) {
            countS[c - 'a']++;
        }

        char[] countT = new char[26];
        for (char c : t.toCharArray()) {
            countT[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) return false;
        }

        return true;
    }

}
