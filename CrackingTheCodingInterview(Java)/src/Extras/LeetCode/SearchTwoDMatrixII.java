package Extras.LeetCode;

public class SearchTwoDMatrixII {

    private static boolean searchMatrix (int [][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int l = 0;
        int c = matrix[0].length-1;
        while (l < matrix.length && c >= 0) {
            if (matrix[l][c] == target) return true;
            if (matrix[l][c] > target) {
                c--;
            } else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] ints = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(ints, 13));
    }

}
