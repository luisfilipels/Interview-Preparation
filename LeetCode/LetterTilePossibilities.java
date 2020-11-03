import java.util.HashSet;

public class LetterTilePossibilities {

    private static int numTilePossibilities (String tiles) {
        HashSet<String> results = new HashSet<>();
        helper(new StringBuilder(), tiles, new boolean[tiles.length()], results);

        return results.size();
    }

    private static void helper (StringBuilder sb, String tiles, boolean [] charsTaken, HashSet<String> set) {
        if (set.contains(sb.toString())) return;
        if (sb.length() != 0) {
            set.add(sb.toString());
        }

        for (int i = 0; i < tiles.length(); i++) {
            if (!charsTaken[i]) {
                sb.append(tiles.charAt(i));
                charsTaken[i] = true;
                helper(sb, tiles, charsTaken, set);
                sb.deleteCharAt(sb.length()-1);
                charsTaken[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }

}
