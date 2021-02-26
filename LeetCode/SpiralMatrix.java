import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // Better solution. O(1) space.
    // Go through everyone in the first layer, than the second, third...
    public List<Integer> spiralOrder(int[][] inputMatrix) {
        int minC = 0, maxC = inputMatrix[0].length-1;
        int minR = 0, maxR = inputMatrix.length-1;

        int[] output = new int[inputMatrix.length * inputMatrix[0].length];
        int i = 0;

        while (i < output.length) {
            for (int c = minC; c <= maxC; c++) {
                output[i++] = inputMatrix[minR][c];
            }
            for (int r = minR+1; r <= maxR; r++) {
                output[i++] = inputMatrix[r][maxC];
            }
            if (minR < maxR && minC < maxC) {
                for (int c = maxC-1; c >= minC; c--) {
                    output[i++] = inputMatrix[maxR][c];
                }
                for (int r = maxR-1; r >= minR+1; r--) {
                    output[i++] = inputMatrix[r][minC];
                }
            }
            minR++;
            maxR--;
            minC++;
            maxC--;
        }

        List<Integer> result = new ArrayList<>();

        for (int s : output) {
            result.add(s);
        }

        return result;
    }

}
