import java.util.HashMap;

public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        int count = 0;

        for (int answer : answers) {
            hash.put(answer, hash.getOrDefault(answer, 0) + 1);
            if (hash.get(answer) == 1) count += answer + 1;
            if (hash.get(answer) > answer) hash.remove(answer);
        }

        return count;
    }

}
