public class TotalMovesForBishop {

    public int solve(int A, int B) {

        int total = 0;

        int compA = 8 - A;
        int compB = 8 - B;

        total += Math.min(A-1, B-1);
        total += Math.min(A-1, compB);
        total += Math.min(compA,B-1);
        total += Math.min(compA,compB);

        return total;
    }

}
