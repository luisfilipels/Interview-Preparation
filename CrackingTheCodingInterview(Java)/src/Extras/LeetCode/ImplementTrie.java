package Extras.LeetCode;

import java.util.HashMap;

public class ImplementTrie {

    static class Node {
        char character;
        HashMap<Character, Node> children;
        boolean endsWord;

        Node () {
            children = new HashMap<>();
            endsWord = false;
        }

        Node (char c) {
            character = c;
            children = new HashMap<>();
            endsWord = false;
        }
    }

    static class Trie {

        Node root;

        Trie() {
            root = new Node();
        }

        void insert (String word) {
            char [] wordChar = word.toCharArray();
            Node current = root;
            for (int i = 0; i < wordChar.length; i++) {
                if (!current.children.containsKey(wordChar[i])) {
                    current.children.put(wordChar[i], new Node(wordChar[i]));
                }
                current = current.children.get(wordChar[i]);
            }
            current.endsWord = true;
        }

        boolean search (String word) {
            char [] wordChar = word.toCharArray();
            Node current = root;
            for (int i = 0; i < wordChar.length; i++) {
                if (!current.children.containsKey(wordChar[i])) {
                    return false;
                }
                current = current.children.get(wordChar[i]);
            }
            if (current.endsWord) {
                return true;
            }
            return false;
        }

        boolean startsWith (String prefix) {
            char [] wordChar = prefix.toCharArray();
            Node current = root;
            for (int i = 0; i < wordChar.length; i++) {
                if (!current.children.containsKey(wordChar[i])) {
                    return false;
                }
                current = current.children.get(wordChar[i]);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
