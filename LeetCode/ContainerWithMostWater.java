package Extras.LeetCode;

public class ContainerWithMostWater {

    static private int maxArea(int [] height) {
        int max = 0;
        int p1 = 0, p2 = height.length-1;
        while (p1 < p2) {
            int h = Math.min(height[p1], height[p2]);
            max = Math.max(max, (p2-p1) * h);
            if (height[p1] < height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        // Solução lenta
        /*int slow, fast;
        for (slow = 0; slow < height.length; slow++) {
            for (fast = slow + 1; fast < height.length; fast++) {
                int h = Math.min(height[slow], height[fast]);
                max = Math.max((fast - slow) * h, max);
            }
        }*/
        return max;
    }

    public static void main(String[] args) {
        int [] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
    }

}
