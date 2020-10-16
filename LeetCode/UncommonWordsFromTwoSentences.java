import java.util.*;

public class UncommonWordsFromTwoSentences {

    private static String[] uncommonFromTwoSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");

        HashMap<String, Integer> count = new HashMap<>();
        LinkedList<String> happensOnce = new LinkedList<>();

        for (String s :  wordsA) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        for (String s : wordsB) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String,Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                happensOnce.add(entry.getKey());
            }
        }

        String [] result = new String[happensOnce.size()];
        return happensOnce.toArray(result);
    }

    public static void main(String[] args) {
        String a = "this apple is sweet";
        String b = "this apple is sour";

        System.out.println(Arrays.toString(uncommonFromTwoSentences(a, b)));
    }

}
