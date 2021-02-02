import java.util.ArrayList;

public class PickFromBothSides {

    public int solve(ArrayList<Integer> A, int B) {
        int [] prefixSum = getPrefixSum(A);
        int [] sufixSum = getSuffixSum(A);
        int n = A.size();

        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<= B; i++)
        {
            int curSum = 0;

            if(B - i > 0)
            {
                curSum += sufixSum[n-(B - i)];
            }

            if(i > 0){
                curSum += prefixSum[i - 1];
            }

            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    int [] getPrefixSum(ArrayList<Integer> a) {
        int n = a.size();
        int [] result = new int[n];

        result[0] = a.get(0);
        for (int i = 1; i < n; i++) {
            result[i] = a.get(i) + result[i-1];
        }

        return result;
    }

    int [] getSuffixSum(ArrayList<Integer> a) {
        int n = a.size();
        int [] result = new int[n];

        result[n-1] = a.get(n-1);
        for (int i = n-2; i >= 0; i--) {
            result[i] = result[i+1] + a.get(i);
        }

        return result;
    }

}
