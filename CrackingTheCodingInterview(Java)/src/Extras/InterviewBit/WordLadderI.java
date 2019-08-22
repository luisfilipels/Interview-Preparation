package Extras.InterviewBit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class WordLadderI {

    static class Wrapper {
        String word;
        int len;
        Wrapper(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    static boolean isAdjacent (String word1, String word2) {
        int difference = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                difference++;
            }
            if (difference > 1) {
                return false;
            }
        }
        return true;
    }

    static public int ladderLength(String start, String end, ArrayList<String> dictV) {
        Deque<Wrapper> queue = new ArrayDeque<>();
        Wrapper item = new Wrapper(start, 1);
        queue.add(item);
        while (!queue.isEmpty()) {
            Wrapper current = queue.poll();

            for (int i = 0; i < dictV.size(); i++) {
                String temp = dictV.get(i);
                if (isAdjacent(current.word, temp)) {
                    item.word = temp;
                    item.len = current.len + 1;
                    queue.add(item);

                    dictV.remove(temp);
                    if (temp.equals(end)) {
                        return item.len - 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String start = "hot";
        String end = "cog";
        ArrayList<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        System.out.println(ladderLength(start, end, dict));
    }

}

/*
Horrible, non-functional code coming up ahead. If it became too complicated, its probably wrong.

static public void biDirBFS (String start, String end, HashMap<String, Boolean> dict, String [] wordList) {
        Deque<String> queueStart = new ArrayDeque<>();
        Deque<String> queueEnd = new ArrayDeque<>();
        HashMap<String, Boolean> visitedStart = (HashMap<String, Boolean>) dict.clone();
        HashMap<String, Boolean> visitedEnd = (HashMap<String, Boolean>) dict.clone();
        queueStart.add(start);
        queueEnd.add(end);
        visitedStart.replace(start, true);
        visitedEnd.replace(end, true);
        while (!queueStart.isEmpty() && !queueEnd.isEmpty()) {
            bfs(queueStart, visitedStart);
            bfs(queueEnd, visitedEnd);
            if (hasIntercept(visitedStart, visitedEnd, wordList)) {
                System.out.println("Found!");
                return;
            }
        }
        System.out.println("Not found!");
    }

    static boolean hasIntercept (HashMap<String, Boolean> visitedStart, HashMap<String, Boolean> visitedEnd, String [] words) {
        for (String word : words) {
            if (visitedStart.get(word).equals(visitedEnd.get(word)) && visitedStart.get(word)) {
                return true;
            }
        }
        return false;
    }

    static ArrayList<String> getAvailableWords (String start, String [] words) {
        ArrayList<String> returnArray = new ArrayList();
        for (String word : words) {
            int difference = 0;
            for (int i = 0; i < word.length(); i++) {
                if (start.charAt(i) != word.charAt(i)) {
                    if (difference == 0) {
                        difference++;
                    } else {
                        difference++;
                        break;
                    }
                }
            }
            if (difference == 1) {
                returnArray.add(word);
            }
        }
        return returnArray;
    }

    static public void bfs (Deque<String> queue, HashMap<String, Boolean> dict) {
        String current = queue.poll();
        ArrayList<String> wordList = getAvailableWords(current, dict.keySet().stream().toArray(String[]::new));
        for (String word : wordList) {
            if (!dict.get(word)) {
                dict.replace(word, true);
                queue.add(word);
            }
        }
    }*/