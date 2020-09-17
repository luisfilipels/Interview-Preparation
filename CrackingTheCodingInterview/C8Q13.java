import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class C8Q13 {

    static class Box {
        int number, width, height, depth;

        Box(int number, int width, int height, int depth) {
            this.number = number;
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
        int[] maxHeight = new int[1];
        helper(new StringBuilder(), null, 0, set, maxHeight);
        return maxHeight[0];
    }

    private static boolean isSmallerThanLast(Box newBox, Box topBox) {
        return (newBox.height < topBox.height && newBox.depth < topBox.depth && newBox.width < topBox.width);
    }

    private static void helper (StringBuilder currentStackString, Box lastBox, int currentHeight, HashSet<Box> remainingBoxes, int[] maxHeight) {
        maxHeight[0] = Math.max(maxHeight[0], currentHeight);
        for (Box b : remainingBoxes) {
            if (lastBox == null || isSmallerThanLast(b, lastBox)) {
                StringBuilder newStackString = new StringBuilder(currentStackString);
                newStackString.append(b.number + " ");
                HashSet<Box> newRemainingBoxes = new HashSet<>(remainingBoxes);
                newRemainingBoxes.remove(b);

                helper(newStackString, b, currentHeight + b.height, newRemainingBoxes, maxHeight);
            }
        }
    }

    public static void main(String[] args) {
        int [] w = new int[] {
                1, 2, 3, 4, 5, 6, 6, 8, 9
        };
        int [] h = new int[] {
                1, 2, 3, 4, 5, 6, 6, 8, 9
        };
        int [] d = new int[] {
                1, 2, 3, 4, 5, 6, 6, 8, 9
        };
        System.out.println(stackOfBoxes(w.length, w, h, d));
    }

}
