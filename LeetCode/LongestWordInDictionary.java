import java.util.*;

public class LongestWordInDictionary {

    private static class TrieNode {
        char character;
        boolean isFinal;

        String soFar = "";

        HashMap<Character, TrieNode> children;

        TrieNode(char c, boolean isFinal) {
            this.character = c;
            this.isFinal = isFinal;
            children = new HashMap<>();
        }
    }

    private static String addWordToTrie(HashMap<Character, TrieNode> rootMap, String word) {
        TrieNode runner = rootMap.get('*');
        boolean isContinuous = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char nextChar = word.charAt(i);
            if (runner.children.containsKey(nextChar)) {
                runner = runner.children.get(nextChar);
                if (runner.isFinal && isContinuous) {
                    sb.append(nextChar);
                } else if (!runner.isFinal) {
                    isContinuous = false;
                }
            } else {
                runner.children.put(nextChar, new TrieNode(nextChar, false));
                runner = runner.children.get(nextChar);
                if (i == word.length()-1) {
                    runner.isFinal = true;
                    if (isContinuous) {
                        sb.append(nextChar);
                    }
                } else {
                    isContinuous = false;
                }
            }
        }
        if (isContinuous) return sb.toString();
        else return "";
    }

    // Solution with sorting. 20ms.
    private static String longestWord(String[] words) {
        Arrays.sort(words, (x1, x2) -> {
            return x1.length() - x2.length();
        });

        HashMap<Character, TrieNode> rootMap = new HashMap<>();
        rootMap.put('*', new TrieNode('*', false));

        PriorityQueue<String> pq = new PriorityQueue<String>(Comparator.naturalOrder());

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String result = addWordToTrie(rootMap, word);
            if (result.length() > max) {
                max = result.length();
                pq.clear();
                pq.add(result);
            } else if (result.length() == max) {
                pq.add(result);
            }
        }

        return pq.poll();
    }

    //=============================================//

    private static void addWordToTrie2(HashMap<Character, TrieNode> rootMap, String word) {
        TrieNode runner = rootMap.get('*');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char nextChar = word.charAt(i);
            sb.append(nextChar);
            if (runner.children.containsKey(nextChar)) {
                runner = runner.children.get(nextChar);
            } else {
                runner.children.put(nextChar, new TrieNode(nextChar, false));
                runner = runner.children.get(nextChar);
                runner.soFar = sb.toString();
            }
            if (i == word.length()-1) {
                runner.isFinal = true;
            }
        }
    }

    private static String bfs (HashMap<Character, TrieNode> rootMap) {
        Queue<TrieNode> queue = new ArrayDeque<>();
        queue.add(rootMap.get('*'));

        PriorityQueue<String> pq = new PriorityQueue<String>(Comparator.naturalOrder());
        int maxSize = 0;

        while(!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TrieNode node = queue.poll();
                if (node.soFar.length() > maxSize) {
                    pq.clear();
                    pq.add(node.soFar);
                    maxSize = node.soFar.length();
                } else if (node.soFar.length() == maxSize) {
                    pq.add(node.soFar);
                }
                for (TrieNode child : node.children.values()) {
                    if (child.isFinal) {
                        queue.add(child);
                    }
                }
            }
        }

        return pq.poll();
    }

    // Solution that uses a BFS.
    private static String longestWord2 (String [] words) {
        HashMap<Character, TrieNode> rootMap = new HashMap<>();
        rootMap.put('*', new TrieNode('*', false));

        for (int i = 0; i < words.length; i++) {
            addWordToTrie2(rootMap, words[i]);
        }

        return bfs(rootMap);
    }

    public static void main(String[] args) {
        String [] words = new String[] {
                "a", "banana", "app", "appl", "ap", "apply", "apple"
        };

        System.out.println(longestWord2(words));
    }

}
