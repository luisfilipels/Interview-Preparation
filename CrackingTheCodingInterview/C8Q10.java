import java.util.Arrays;

public class C8Q10 {

    static boolean isValid (int [][] image, int l, int c, int desiredColor) {
        return (l >= 0 && l < image.length && c >= 0 && c < image[0].length && image[l][c] == desiredColor);
    }

    static void paintFill (int [][] image, int l, int c, int newColor) {
        int currentColor = image[l][c];
        image[l][c] = newColor;
        if (isValid(image, l+1, c, currentColor)) paintFill(image, l+1, c, newColor);
        if (isValid(image, l-1, c, currentColor)) paintFill(image, l-1, c, newColor);
        if (isValid(image, l, c+1, currentColor)) paintFill(image, l, c+1, newColor);
        if (isValid(image, l, c-1, currentColor)) paintFill(image, l, c-1, newColor);
    }

    public static void main(String[] args) {
        int [][] image = new int[][] {
                {0,0,0,0,1},
                {1,1,1,0,1},
                {0,2,2,0,1},
                {1,2,2,0,1},
                {0,0,0,0,1},
        };
        paintFill(image, 0, 0, 5);
        System.out.println(Arrays.deepToString(image));
    }

}
