import java.util.*;

public class FirstUniqueCharInString {

    private static int firstUniqChar3 (String s) {
        if (s.equals("")) return -1;

        Queue<Character> queue = new ArrayDeque<>();
        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, Integer> indexOf = new HashMap<>();

        char [] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (count.get(c) == null) {
                queue.add(c);
                indexOf.put(c, i);
            }
            count.put(c, count.getOrDefault(c, 0) + 1);
            while(queue.peek() != null && count.get(queue.peek()) > 1) {
                queue.poll();
            }
        }
        if (queue.isEmpty()) return -1;
        return indexOf.get(queue.poll());
    }

    static class Tracker {
        char c;
        int count;
        int index;

        Tracker(char c, int count, int index) {
            this.c = c;
            this.count = count;
            this.index = index;
        }
    }

    // Solves in one pass, but takes a bit longer than 2 passes
    private static int firstUniqChar2 (String s) {
        HashMap<Character, Tracker> map = new HashMap<>();

        PriorityQueue<Tracker> q = new PriorityQueue<>((x1, x2) -> {
            if (x1.count - x2.count == 0) {
                return x1.index - x2.index;
            }
            else return x1.count - x2.count;
        });

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (!map.containsKey(c)) {
                Tracker newTracker = new Tracker(c, 1, i);
                map.put(c, newTracker);
                q.add(newTracker);
            } else {
                map.get(c).count++;
                q.remove(map.get(c));
            }
        }
        if (q.isEmpty()) return -1;
        return q.poll().index;
    }

    // Two passes
    private static int firstUniqChar1 (String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.get(c) == 1) return i;
        }

        return -1;
    }

    // One pass. Better time than 2 passes.
    private static int firstUniqChar (String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        if (map.isEmpty()) return -1;
        return map.entrySet().iterator().next().getValue();
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

}
