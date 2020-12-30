import java.util.HashMap;

public class DesignAddAndSearchWordsDataStructure {

    static class TrieNode {
        char character;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isFinal = false;

        TrieNode(char c) {
            character = c;
        }
    }

    static class WordDictionary {
        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode('*');
        }

        public void addWord(String word) {
            TrieNode runner = root;
            char[] arr = word.toCharArray();
            for (char c : arr) {
                if (!runner.children.containsKey(c)) {
                    runner.children.put(c, new TrieNode(c));
                }
                runner = runner.children.get(c);
            }
            runner.isFinal = true;
        }

        public boolean search(String word) {
            TrieNode runner = root;
            char[] arr = word.toCharArray();
            return search(arr, runner, 0);
        }

        private boolean search(char[] word, TrieNode runner, int index) {
            if (index == word.length && runner.isFinal) return true;
            if (index == word.length) return false;
            if (word[index] == '.') {
                for (var entry : runner.children.entrySet()) {
                    boolean success = search(word, runner.children.get(entry.getKey()), index+1);
                    if (success) return true;
                }
                return false;
            }
            if (runner.children.containsKey(word[index])) {
                return search(word, runner.children.get(word[index]), index+1);
            } else return false;
        }
    }



    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        var result = wd.search("b..");

        System.out.println(result);
    }

}
