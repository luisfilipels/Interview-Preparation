import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutations {

    private static void getAllPermutations (char [] arr, int index, List<String> returnList) {
        returnList.add(String.valueOf(arr));
        for (int i = index; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i])) {
                if (Character.isLowerCase(arr[i])) {
                    arr[i] = Character.toUpperCase(arr[i]);
                } else {
                    arr[i] = Character.toLowerCase(arr[i]);
                }
                getAllPermutations(arr, i + 1, returnList);
                if (Character.isLowerCase(arr[i])) {
                    arr[i] = Character.toUpperCase(arr[i]);
                } else {
                    arr[i] = Character.toLowerCase(arr[i]);
                }
            }
        }
    }

    private static void getAllPermutations (String s, int index, StringBuilder currentSB, List<String> returnList) {
        if (index == s.length()) {
            returnList.add(currentSB.toString());
            return;
        }

        char currentChar = s.charAt(index);
        if (Character.isAlphabetic(currentChar)) {
            StringBuilder lower = new StringBuilder(currentSB);
            StringBuilder upper = new StringBuilder(currentSB);

            lower.append(Character.toLowerCase(currentChar));
            upper.append(Character.toUpperCase(currentChar));

            getAllPermutations(s, index+1, lower, returnList);
            getAllPermutations(s, index+1, upper, returnList);
        } else {
            currentSB.append(currentChar);
            getAllPermutations(s, index+1, currentSB, returnList);
        }
    }

    private static List<String> letterCasePermutations (String s) {
        List<String> returnList = new ArrayList<>();

        //getAllPermutations(s, 0, new StringBuilder(), returnList);
        getAllPermutations(s.toCharArray(), 0, returnList);

        return returnList;
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutations("a1b2"));
    }

}
