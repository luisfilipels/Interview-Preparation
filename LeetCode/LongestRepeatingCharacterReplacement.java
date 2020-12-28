import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestRepeatingCharacterReplacement {

    private static int characterReplacement (String s, int k) {
        int n = s.length();
        int [] counts = new int[26];

        int i = 0;
        int maxCount = 0, maxLength = 0;

        // No need for a priority queue! We can update the char that most occurs in the window with the maxCount variable!
        // Say we have s = "AABBB". When j reaches the third char, maxCount will still be two! Once we reach the last char, however,
        // it will be 3.
        for (int j = 0; j < n; j++) {
            counts[s.charAt(j) - 'A']++;
            int currentCharCount = counts[s.charAt(j) - 'A'];
            maxCount = Math.max(maxCount, currentCharCount);

            while (j - i - maxCount + 1 > k) {
                counts[s.charAt(i++) - 'A']--;
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }

    /*private static int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((x1, x2) -> {
            return count.getOrDefault(x2, 0) - count.getOrDefault(x1, 0);
        });

        for (char c = 'A'; c <= 'Z'; c++) {
            pq.offer(c);
        }

        int i = 0, j = 0;
        int n = s.length();
        int maxSize = 0;
        while (j < n) {
            while (j < n) {
                char currentChar = s.charAt(j);
                count.put(currentChar, count.getOrDefault(currentChar, 0) + 1);
                pq.remove(currentChar);
                pq.add(currentChar);
                int countTop = count.get(pq.peek());
                int size = j - i + 1;
                if (size - countTop > k) {
                    break;
                }
                maxSize = Math.max(maxSize, size);
                j++;
            }
            while (j < n && (j-i+1) - count.getOrDefault(pq.peek(), 0) > k) {
                char currentAtI = s.charAt(i++);
                if (++j >= n) break;
                char currentAtJ = s.charAt(j);

                count.put(currentAtI, count.get(currentAtI) - 1);
                count.put(currentAtJ, count.getOrDefault(currentAtJ, 0) + 1);

                pq.remove(currentAtI);
                pq.remove(currentAtJ);
                pq.add(currentAtI);
                pq.add(currentAtJ);
            }
            if (j < n) {
                maxSize = Math.max(maxSize, j - i + 1);
            } else {
                maxSize = Math.max(maxSize, n - i);
            }
            j++;
        }

        return maxSize;
    }*/

    public static void main(String[] args) {
        String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int k = 4;

        System.out.println(characterReplacement(s, k));
    }

}
