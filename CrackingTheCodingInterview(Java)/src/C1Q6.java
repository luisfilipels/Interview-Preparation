import java.util.ArrayList;

public class C1Q6 {

    public static class countQueueItem {
        countQueueItem (char character) {
            count = 0;
            this.character = character;
        }
        int count;
        final char character;
    }

    private static String compress(String input) {
        ArrayList<countQueueItem> countQueue = new ArrayList<>();
        countQueue.add(new countQueueItem(input.charAt(0)));
        for (int i = 1; i < input.length(); i++) {
            if (countQueue.get(countQueue.size()-1).character == input.charAt(i)) {
                countQueue.get(countQueue.size()-1).count++;
            } else {
                countQueue.add(new countQueueItem(input.charAt(i)));
            }
        }
        StringBuilder returnString = new StringBuilder();
        while (!countQueue.isEmpty()) {
            returnString.append(String.format("%c%d", countQueue.get(0).character, countQueue.get(0).count + 1));
            countQueue.remove(0);
        }
        if (returnString.length() < input.length()) {
            return returnString.toString();
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        System.out.println(compress("aabccccaaabbb"));
    }
}
