package Extras.HackerRank;

import java.util.TreeSet;

public class MaximumSubarraySumModuloM {

    // TreeSet can be used in Java in a way similar to the iterator methods in C++ lower_bound and upper_bound
    // https://www.youtube.com/watch?v=u_ft5jCDZXk&feature=emb_logo

    static long maximumSum (long[] a, long m) {
        TreeSet<Long> tree = new TreeSet<>();
        long sum = 0;
        long max = 0;
        for (int i = 0; i < a.length; i++) {
            sum = (sum + a[i]) % m;
            Long higher = tree.higher(sum);
            if (higher == null) {
                max = Math.max(max, sum);
            } else {
                max = Math.max(max, (sum - higher + m) % m);
            }
            tree.add(sum);
        }
        return max;
    }

    public static void main(String[] args) {
        long[] a = new long[] {1,2,3,4,5,6,7,-8,2,12,11};
        long m = 15;

        System.out.println(maximumSum(a,m));
    }

}
