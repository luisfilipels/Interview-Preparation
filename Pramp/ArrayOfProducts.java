package Extras.Pramp;

import java.io.*;
import java.util.*;

class ArrayOfProducts {
    static int[] arrayOfArrayProducts(int[] arr) {
        if (arr.length == 1) {
            return new int[0];
        }
        int [] returnArray = new int[arr.length];
        int [] left = new int[arr.length];
        int [] right = new int[arr.length];
        int acumulator = 1;
        for (int i = 0; i < arr.length; i++) {
            acumulator *= arr[i];
            left[i] = acumulator;
        }
        acumulator = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            acumulator *= arr[i];
            right[i] = acumulator;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                returnArray[i] = right[i+1];
            } else if (i == arr.length - 1) {
                returnArray[i] = left[i-1];
            } else {
                returnArray[i] = right[i+1] * left[i-1];
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {

    }

}


