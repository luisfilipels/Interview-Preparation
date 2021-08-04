import java.util.ArrayList;
import java.util.List;

interface Token {
    String getValue();
}

public class TextJustification {

    static class SpaceToken implements Token {
        StringBuilder value = new StringBuilder();

        SpaceToken() {
            increment();
        }

        public void increment() {
            value.append(" ");
        }

        @Override
        public String getValue() {
            return value.toString();
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    static class WordToken implements Token {
        StringBuilder value = new StringBuilder();

        WordToken(String initialValue) {
            value.append(initialValue);
        }

        @Override
        public String getValue() {
            return value.toString();
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> returnList = new ArrayList<>();
        int countChars = 0;
        int i = 0;
        for (int j = 0; j < words.length; j++) {
            countChars += words[j].length();
            if (countChars > maxWidth) {
                countChars = 0;
                j--;
                List<Token> tokensToAdd = buildTokenList(i, j, maxWidth, words);
                i = j+1;
                List<SpaceToken> spaces = buildSpaceList(tokensToAdd);
                int currentSize = getCurrentSize(tokensToAdd);
                incrementSpacesTillMaxWidth(maxWidth, spaces, currentSize);
                StringBuilder sb = new StringBuilder();
                for (Token t : tokensToAdd) {
                    sb.append(t.getValue());
                }
                returnList.add(sb.toString());
            } else {
                countChars++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (i < words.length) {
            sb.append(words[i++]);
            if (i != words.length) sb.append(" ");
        }
        if (sb.length() != 0) {
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            returnList.add(sb.toString());
        }

        return returnList;
    }

    private static void incrementSpacesTillMaxWidth(int maxWidth, List<SpaceToken> spaces, int currentSize) {
        while (currentSize < maxWidth) {
            for (SpaceToken space : spaces) {
                space.increment();
                currentSize++;
                if (currentSize >= maxWidth) break;
            }
        }
    }

    private static List<SpaceToken> buildSpaceList(List<Token> tokensToAdd) {
        List<SpaceToken> spaces = new ArrayList<>();
        for (Token t : tokensToAdd) {
            if (t instanceof SpaceToken) spaces.add((SpaceToken) t);
        }
        return spaces;
    }

    private static List<Token> buildTokenList(int i, int j, int maxWidth, String[] words) {
        List<Token> tokensToAdd = new ArrayList<>();
        for (; i <= j; i++) {
            tokensToAdd.add(new WordToken(words[i]));
            tokensToAdd.add(new SpaceToken());
        }
        if (tokensToAdd.size() > 2) tokensToAdd.remove(tokensToAdd.size()-1);
        else {
            if (tokensToAdd.get(0).getValue().length() + tokensToAdd.get(1).getValue().length() > maxWidth) {
                tokensToAdd.remove(tokensToAdd.size()-1);
            }
        }
        return tokensToAdd;
    }

    private static int getCurrentSize(List<Token> list) {
        int currentSize = 0;
        for (Token t : list) {
            currentSize += t.getValue().length();
        }
        return currentSize;
    }

    public static void main(String[] args) {
        // "What","must","be","acknowledgment","shall","be"
        // "This", "is", "an", "example", "of", "text", "justification."
        // "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"
        String[] words = new String[] {
                "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"
        };
        System.out.println(fullJustify(words, 20));
    }

}
