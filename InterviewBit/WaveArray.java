package Extras.InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {

    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> returnArray = new ArrayList<>();
        for (int i = 0; i < A.size(); i += 2) {
            if (i > A.size()-2) {
                break;
            }
            int temp = A.get(i);
            A.set(i, A.get(i+1));
            A.set(i+1, temp);
        }
        return A;

    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 3, 4};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i1 : input) {
            A.add(i1);
        }
        A = wave(A);
        for (Integer integer : A) {
            System.out.print(integer);
            System.out.print(" ");
        }

    }
}
