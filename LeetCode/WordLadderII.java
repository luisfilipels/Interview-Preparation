import java.util.*;

public class WordLadderII {

    private static class Pair {
        ArrayList<String> currentPath;
        HashSet<String> inPath = new HashSet<String>();

        Pair(ArrayList<String> arr) {
            currentPath = arr;
            inPath.addAll(arr);
        }
    }

    private static HashMap<String, ArrayList<String>> buildWordMap (List<String> wordList, String endWord) {
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

    private static boolean isOneEditAway (String word1, String word2) {
        int countDiff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) countDiff++;
            if (countDiff > 1) return false;
        }
        return countDiff == 1;
    }

    private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return new ArrayList<>();

        wordList.add(endWord);
        wordList.add(beginWord);
        HashMap<String, ArrayList<String>> wordMap = buildWordMap(wordList, endWord);

        LinkedList<Pair> queue = new LinkedList<>();

        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);

        queue.add(new Pair(list));

        List<List<String>> returnList = new ArrayList<>();
        HashSet<List<String>> inReturnList = new HashSet<>();

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                Pair current = queue.poll();
                HashSet<String> visited = current.inPath;
                ArrayList<String> currentPath = current.currentPath;
                String currentStr = currentPath.get(currentPath.size()-1);
                List<String> neighbors = wordMap.get(currentStr);

                for (String st : neighbors) {
                    if (st.equals(endWord)) {
                        ArrayList<String> newPath = new ArrayList<>(currentPath);
                        newPath.add(st);
                        if (!inReturnList.contains(newPath)) {
                            if (!returnList.isEmpty()) {
                                int length = returnList.get(returnList.size() - 1).size();
                                if (newPath.size() == length) {
                                    returnList.add(newPath);
                                    inReturnList.add(newPath);
                                } else {
                                    return returnList;
                                }
                            } else {
                                returnList.add(newPath);
                                inReturnList.add(newPath);
                            }
                        }
                    } else if (!visited.contains(st)) {
                        ArrayList<String> newPath = new ArrayList<>(currentPath);
                        newPath.add(st);
                        queue.add(new Pair(newPath));
                    }
                }
            }
        }

        return returnList;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        String[] words = new String[] {
            "hot", "dot", "dog", "lot", "log",
        };

        ArrayList<String> arr = new ArrayList<String>(Arrays.asList(words));

        System.out.println(findLadders(beginWord, endWord, arr));
    }

}
