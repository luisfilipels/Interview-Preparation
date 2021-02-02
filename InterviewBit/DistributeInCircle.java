public class DistributeInCircle {

    public int solve(int A, int B, int C) {

        if (C + A - 1 <= B) {
            return C + A - 1;
        }

        int dif = C - 1;
        A += dif;

        return A % B;

    }

}
