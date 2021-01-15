import java.util.*;

public class SortCharactersByFrequency {

    class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        char [] arr = s.toCharArray();

        for (char c : arr) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Pair> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list, (x, y) -> {
            return y.count - x.count;
        });

        StringBuilder sb = new StringBuilder();

        for (Pair p : list) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.c);
            }
        }

        return sb.toString();

    }

}
