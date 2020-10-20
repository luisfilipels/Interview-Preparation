import java.util.*;

public class WordLadder {

    private static boolean isOneEditAway (String word1, String word2) {
        int countDiff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) countDiff++;
            if (countDiff > 1) return false;
        }
        return countDiff == 1;
    }

    private static HashMap<String, ArrayList<String>> buildWordMap (List<String> wordList) {
        HashMap<String, ArrayList<String>> wordMap = new HashMap<>();

        for (String s : wordList) {
            wordMap.put(s, new ArrayList<String>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            for (int j = i; j < wordList.size(); j++) {
                String word2 = wordList.get(j);

                if (isOneEditAway(word1, word2)) {
                    wordMap.get(word1).add(word2);
                    wordMap.get(word2).add(word1);
                }
            }
        }

        return wordMap;
    }

    private static class Pair {
        String word;
        int distance;

        Pair(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
    }

    static int bfs(LinkedList<Pair> queue, HashMap<String, Integer> distances, HashSet<String> visited1, HashSet<String> visited2, HashMap<String, ArrayList<String>> wordMap) {
        Pair currentStart = queue.poll();
        String strStart = currentStart.word;
        int distStart = currentStart.distance;

        ArrayList<String> currentNeighborsStart = wordMap.get(strStart);
        for (String s : currentNeighborsStart) {
            if (visited2.contains(s)) {
                return distStart + distances.get(s);
            }

            if (!visited1.contains(s)) {
                visited1.add(s);
                distances.put(s, distStart+1);
                queue.add(new Pair(s, distStart+1));
            }
        }

        return -1;
    }


    private static int ladderLength (String beginWord, String endWord, List<String> wordList) {
        boolean foundEndWord = false;
        for (String word : wordList) {
            if (word.equals(endWord)) {
                foundEndWord = true;
                break;
            }
        }

        if(!foundEndWord) return 0;

        HashSet<String> visitedStart = new HashSet<String>();
        HashSet<String> visitedEnd = new HashSet<String>();
        visitedStart.add(beginWord);
        visitedEnd.add(endWord);

        wordList.add(endWord);
        wordList.add(beginWord);
        
        HashMap<String, ArrayList<String>> wordMap = buildWordMap(wordList);

        LinkedList<Pair> queueStart = new LinkedList<>();
        LinkedList<Pair> queueEnd = new LinkedList<>();
        queueStart.add(new Pair(beginWord, 1));
        queueEnd.add(new Pair(endWord, 1));

        HashMap<String, Integer> distances = new HashMap<>();
        distances.put(beginWord, 1);
        distances.put(endWord, 1);

        while (!queueStart.isEmpty() && !queueEnd.isEmpty()) {
            int r1 = bfs(queueStart, distances, visitedStart, visitedEnd, wordMap);
            if (r1 != -1) return r1;

            int r2 = bfs(queueEnd, distances, visitedEnd, visitedStart, wordMap);
            if (r2 != -1) return r2;
        }
        return 0;
    }

    // Simple BFS solution
    /*private static int ladderLength (String beginWord, String endWord, List<String> wordList) {
        boolean foundEndWord = false;
        for (String word : wordList) {
            if (word.equals(endWord)) {
                foundEndWord = true;
                break;
            }
        }

        if(!foundEndWord) return 0;

        HashSet<String> visited = new HashSet<String>();
        visited.add(beginWord);

        wordList.add(endWord);
        wordList.add(beginWord);
        HashMap<String, ArrayList<String>> wordMap = buildWordMap(wordList);

        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String str = current.word;
            int dist = current.distance;

            ArrayList<String> currentNeighbors = wordMap.get(str);
            for (String s : currentNeighbors) {
                if (s.equals(endWord)) {
                    return dist+1;
                }

                if (!visited.contains(s)) {
                    visited.add(s);
                    queue.add(new Pair(s, dist+1));
                }
            }
        }
        return 0;
    }*/

    public static void main(String[] args) {
        /*String beginWord = "hit";
        String endWord = "cog";

        String[] words = new String[] {
            "hot", "dot", "dog", "lot", "log", "cog"
        };*/

        String beginWord = "a";
        String endWord = "c";

        String[] words = new String[] {
                "a", "b", "c"
        };

        ArrayList<String> arr = new ArrayList<String>(Arrays.asList(words));

        System.out.println(ladderLength(beginWord, endWord, arr));
    }

}
