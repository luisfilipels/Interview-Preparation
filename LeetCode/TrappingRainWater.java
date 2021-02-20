import java.util.Stack;

public class TrappingRainWater {

    static class Pair {
        int index;
        int height;

        Pair(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static int trap(int[] height) {
        Stack<Pair> stack = new Stack<>();

        int i = 0;
        int n = height.length;
        int volume = 0;
        while (i < n) {
            Pair current = new Pair(height[i], i); // Right wall
            while (!stack.isEmpty() && current.height > stack.peek().height ) {
                Pair floor = stack.pop(); // This is the floor of this iteration
                Pair leftWall = stack.peek(); // left wall
                if (stack.isEmpty()) break;

                int distance = current.index - leftWall.index - 1;
                int boundedHeight = Math.min(current.height, leftWall.height) - floor.height;
                volume += distance * boundedHeight;
            }
            stack.push(current);
            i++;
        }
        return volume;
    }

    public static void main(String[] args) {
        int [] input = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        //int [] input = new int[] {3, 0, 3};
        //int [] input = new int[] {2, 1, 0, 2};
        System.out.println(trap(input));
    }

}
