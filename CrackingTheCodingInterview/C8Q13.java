import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class C8Q13 {

    static class Box {
        int width, height, depth;

        Box(int number, int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }



    private static int stackOfBoxes (int n, int[]w, int[]h, int[]d) {
        HashSet<Box> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(new Box(i, w[i], h[i], d[i]));
        }
        return helper(new StringBuilder(), null, 0, set, new HashMap<>());
    }

    private static boolean isSmallerThanLast(Box newBox, Box topBox) {
        return (newBox.height < topBox.height && newBox.depth < topBox.depth && newBox.width < topBox.width);
    }

    // No memoization solution.
    /*private static void helper (StringBuilder currentStackString, Box lastBox, int currentHeight, HashSet<Box> remainingBoxes, int[] maxHeight) {
        maxHeight[0] = Math.max(maxHeight[0], currentHeight);
        for (Box b : remainingBoxes) {
            if (lastBox == null || isSmallerThanLast(b, lastBox)) {
                StringBuilder newStackString = new StringBuilder(currentStackString);
                newStackString.append(b.height + "." + b.depth + "." + b.width + " ");
                HashSet<Box> newRemainingBoxes = new HashSet<>(remainingBoxes);
                newRemainingBoxes.remove(b);

                helper(newStackString, b, currentHeight + b.height, newRemainingBoxes, maxHeight);
            }
        }
    }*/

    private static int helper(StringBuilder currentStackString, Box lastBox, int currentHeight, HashSet<Box> remainingBoxes, HashMap<String, Integer> memo) {
        if (memo.containsKey(currentStackString.toString())) {
            return memo.get(currentStackString.toString());
        }
        int currentMax = currentHeight;
        boolean noBoxesPossible = true;
        for (Box b : remainingBoxes) {
            if (lastBox == null || isSmallerThanLast(b, lastBox)) {
                noBoxesPossible = false;
                StringBuilder newStackString = new StringBuilder(currentStackString);
                newStackString.append(b.height + "." + b.depth + "." + b.width + " ");
                HashSet<Box> newRemainingBoxes = new HashSet<>(remainingBoxes);
                newRemainingBoxes.remove(b);

                int result = helper(newStackString, b, currentHeight + b.height, newRemainingBoxes, memo);
                if (result > currentMax) {
                    currentMax = result;
                }
            }
        }
        memo.put(currentStackString.toString(), currentMax);
        if (noBoxesPossible) return currentHeight;
        else return currentMax;
    }

    public static void main(String[] args) {
        int [] w = new int[] {
                5, 7, 6, 6,6, 5, 2, 3, 2, 1
        };
        int [] h = new int[] {
                8, 8, 6, 3,3, 5, 4, 3, 2, 1
        };
        int [] d = new int[] {
                9, 5, 6, 2,2, 5, 2, 3, 2, 1
        };
        System.out.println(stackOfBoxes(w.length, w, h, d));
    }

}
