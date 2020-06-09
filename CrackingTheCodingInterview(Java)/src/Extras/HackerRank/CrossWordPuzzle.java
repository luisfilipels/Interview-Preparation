package Extras.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CrossWordPuzzle {


    /**
     * I believe that if your interviewer gives you this question, they probably don't want you to succeed :P
     * You are to solve this question using recursion, with a brute-force strategy as there is no elegant and efficient
     * way to solve it (as far as I know).
     *
     * To solve it, I took the following steps:
     * 1 - Separate the words string into an array of String, that is easier to manage.
     * 2 - Get all possible coordinates in the crosswords that we can use to start a word.
     * 3 - Get all permutations of said words
     * 4 - For each of the combinations obtained from mixing each permutation and each coordinate, try filling the cross-
     * words in whichever valid way possible.
     */


    static class Coordinate {
        int l, c;

        enum  Direction{
            HORIZONTAL, VERTICAL
        }

        Direction d;

        Coordinate(int l, int c, Direction d) {
            this.l = l;
            this.c = c;
            this.d = d;
        }
    }

    /**
     * We can consider an element of our crosswords to be a possible start location of an horizontal word if there is not
     * an '-' in the position to the left of it.
     */
    static boolean checkCanStartWordHorizontal (String currentLine, int c) {
        if (c-1 >= 0) {
            if (currentLine.charAt(c-1) == '-') return false;
        }
        return true;
    }

    /**
     * We can do the same for vertical words.
     */
    static boolean checkCanStartWordVertical (String [] crossword, int l, int c) {
        if (l - 1 >= 0) {
            if (crossword[l-1].charAt(c) == '-') return false;
        }
        return true;
    }

    /**
     * To get all possible starting points, let's use both of the functions above in all positions of String [] crossword.
     * For each position, we should check if we can start a word horizontally, and vertically. If we can start them in either
     * way, we add it to a list, so that we can iterate through each of these positions later on.
     */
    static ArrayList<Coordinate> getPossibleStartPoints (String[] crossword) {
        ArrayList<Coordinate> list = new ArrayList<>();

        for (int l = 0; l < crossword.length; l++) {
            String currentLine = crossword[l];
            for (int c = 0; c < currentLine.length(); c++) {
                if (currentLine.charAt(c) == '-') {
                    if (checkCanStartWordHorizontal(currentLine, c)) {
                        list.add(new Coordinate(l, c, Coordinate.Direction.HORIZONTAL));
                    }
                    if (checkCanStartWordVertical(crossword, l, c)) {
                        list.add(new Coordinate(l, c, Coordinate.Direction.VERTICAL));
                    }
                }
            }
        }

        return list;
    }

    static String [] getWords(String words) {
        return words.split(";");
    }

    /**
     *  This function returns true if we can, from a starting position, fill the selected word from top to bottom.
     */
    static boolean tryFillWordVertically(StringBuilder[] crossword, String word, int l, int c, int i, HashSet<String> hash) {
        if (l >= 10) {
            if (i == word.length()) {
                // If we went beyond the bounds of our 2D array, we can return true if all the characters of our word have been inserted
                hash.add(word);
                return true;
            }
            // If they have not been inserted, return false
            return false;
        }
        if (crossword[l].charAt(c) == '-') {
            // If the current char is an empty space ('-')...
            // If we have reached the end of the word, and the current space is empty, then we return false, as there
            // are no more chars in our word that we can use to fill the space
            if (i == word.length()) return false;
            char original = crossword[l].charAt(c);
            crossword[l].setCharAt(c, word.charAt(i));
            // If the previous was not the case, then we can try filling the remaining spaces
            boolean canFill = tryFillWordVertically(crossword, word, l+1, c, i+1, hash);
            if (canFill) return true;
            // If we could fill the spaces successfully, return true
            crossword[l].setCharAt(c, original);
            // If not, restore the current char back to '-' and return false
            return false;
        } else {
            // If the current char is not '-', then it can either be '+', or a letter
            if (i == word.length()) {
                // If we could fill all the chars of word, then it doesn't matter whether the current char should be '+' or a letter.
                // So add the word to our hashset, and return true
                hash.add(word);
                return true;
            }
            if (crossword[l].charAt(c) == word.charAt(i)) {
                // If the current char is a letter, and is the same char as the one we are trying to fill currently,
                // skip the current char, and try filling the next ones.
                return tryFillWordVertically(crossword, word, l+1, c, i+1, hash);
            }
            // If the current char is a letter, and is not the one we were expecting, return false.
            return false;
        }
    }

    // This function behaves in the same manner as the previous one, except for the fact that we are trying to fill a horizontal word.
    static boolean tryFillWordHorizontally (StringBuilder [] crossword, String word, int l, int c, int i, HashSet<String> hash) {
        if (c >= 10) {
            if (i == word.length()) {
                hash.add(word);
                return true;
            }
            return false;
        }
        if (crossword[l].charAt(c) == '-') {
            if (i == word.length()) return false;
            char original = crossword[l].charAt(c);
            crossword[l].setCharAt(c, word.charAt(i));
            boolean canFill = tryFillWordHorizontally(crossword, word, l, c+1, i+1, hash);
            if (canFill) return true;
            crossword[l].setCharAt(c, original);
            return false;
        } else {
            if (i == word.length()) {
                hash.add(word);
                return true;
            }
            if (crossword[l].charAt(c) == word.charAt(i)) {
                return tryFillWordHorizontally(crossword, word, l, c+1, i+1, hash);
            }
            return false;
        }
    }

    // Given our words array, get all permutations of it.
    static void getPermutations(String [] words, ArrayList<ArrayList<String>> currentPermutations, int i) {
        System.arraycopy(words, 0, words, 0, words.length);
        if (i == words.length) {
            currentPermutations.add(new ArrayList<>());
            ArrayList<String> current = currentPermutations.get(currentPermutations.size()-1);
            current.addAll(Arrays.asList(words));
        }
        for (int j = i; j < words.length; j++) {
            String temp = words[j];
            words[j] = words[i];
            words[i] = temp;

            getPermutations(words, currentPermutations, i+1);

            temp = words[j];
            words[j] = words[i];
            words[i] = temp;
        }
    }

    static ArrayList<ArrayList<String>> getPermutations (String [] words) {
        ArrayList<ArrayList<String>> permutations = new ArrayList<>();
        getPermutations(words, permutations, 0);
        return permutations;
    }

    // If this boolean is true, we no longer need to search for an answer, as we have already found one.
    static boolean reachedEnd = false;
    static String[] answer;

    // This function essentially does all the steps mentioned in my first comment.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        String[] wordsArr = getWords(words);
        ArrayList<Coordinate> startPoints = getPossibleStartPoints(crossword);
        HashSet<String> wordsUsed = new HashSet<>();
        ArrayList<ArrayList<String>> permutations = getPermutations(wordsArr);

        StringBuilder[] crosswordArr = new StringBuilder[crossword.length];
        answer = new String[crossword.length];

        for (ArrayList<String> permutation : permutations) {
            for (int i = 0; i < crossword.length; i++) {
                crosswordArr[i] = new StringBuilder(crossword[i]);
            }

           helper(crosswordArr, startPoints, permutation, wordsUsed, new HashSet<>(), 0, 0);
        }

        return answer;
    }

    static void helper(StringBuilder[] crossword, ArrayList<Coordinate> startPoints, ArrayList<String> permutation, HashSet<String> wordsUsed, HashSet<Coordinate> startPointsUsed, int currentWordInPermutation, int currentStartPoint) {
        if (reachedEnd) return; // If we found an answer, stop
        if (wordsUsed.size() == permutation.size()) { // If we have used all of our available words, that means we were able to fill up the crosswords, so we can store the answer we've obtained, and stop.
            reachedEnd = true;
            for (int i = 0; i < crossword.length; i++) {
                answer[i] = crossword[i].toString();
            }
        } else {
            for (int i = currentWordInPermutation; i < permutation.size(); i++) {
                String word = permutation.get(i);
                if (!wordsUsed.contains(word)) {
                    for (int start = currentStartPoint; start < startPoints.size(); start++) {
                        Coordinate startPoint = startPoints.get(start);
                        if (startPointsUsed.contains(startPoint)) continue;

                        // Copy our crosswords and hashsets, so that they aren't changed later on.
                        StringBuilder[] newCrossword = new StringBuilder[crossword.length];
                        System.arraycopy(crossword, 0, newCrossword, 0, crossword.length);
                        HashSet<String> newWordsUsed = new HashSet<>(wordsUsed);
                        HashSet<Coordinate> newStartPointsUsed = new HashSet<>();

                        boolean success;
                        if (startPoint.d == Coordinate.Direction.VERTICAL) {
                            success = tryFillWordVertically(newCrossword, word, startPoint.l, startPoint.c, 0, newWordsUsed);
                        } else {
                            success = tryFillWordHorizontally(newCrossword, word, startPoint.l, startPoint.c, 0, newWordsUsed);
                        }
                        if (success) {
                            // If we were able to fill a word, try filling up the next one.
                            newStartPointsUsed.add(startPoint);
                            helper(newCrossword, startPoints, permutation, newWordsUsed, newStartPointsUsed, currentWordInPermutation+1, currentStartPoint+1);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] crosswords = new String[] {
                "++++++++++",
                "+------+++",
                "+++-++++++",
                "+++-++++++",
                "+++-----++",
                "+++-++-+++",
                "++++++-+++",
                "++++++-+++",
                "++++++-+++",
                "++++++++++"
        };
        /*String[] crosswords = new String[] {
                "+-++++++++",
                "+-++++++++",
                "+-------++",
                "+-++++++++",
                "+-++++++++",
                "+------+++",
                "+-+++-++++",
                "+++++-++++",
                "+++++-++++",
                "++++++++++"
        };*/
        /*String[] crosswords = new String[] {
                "+-++++++++",
                "+-++-+++++",
                "+-------++",
                "+-++-+++++",
                "+-++-+++++",
                "+-++-+++++",
                "++++-+++++",
                "++++-+++++",
                "++++++++++",
                "----------"
        };*/

       // System.out.println(list.size());

        String[] response = crosswordPuzzle(crosswords, "POLAND;LHASA;SPAIN;INDIA");
        //String[] response = crosswordPuzzle(crosswords, "AGRA;NORWAY;ENGLAND;GWALIOR");
        //String[] response = crosswordPuzzle(crosswords, "CALIFORNIA;NIGERIA;CANADA;TELAVIV");

        for (String s : response) {
            System.out.println(s);
        }
    }

}
