package Extras.Pramp;

import java.util.HashSet;

public class GettingADifferentNumber {

    static int getDifferentNumber (int [] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : arr) {
            hashSet.add(num);
        }
        int i;
        for (i = 0; i < arr.length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int [] input = new int[] {0,1,2,3,4};
        System.out.println(getDifferentNumber(input));
    }

}
