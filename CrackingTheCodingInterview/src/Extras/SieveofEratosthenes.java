package Extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SieveofEratosthenes {

    static boolean [] prime;
    static ArrayList<Integer> primeList = new ArrayList<>();

    static void findPrimes (int max) {
        prime = new boolean[max + 1];
        for (int i = 0;  i < prime.length; i++) {
            prime[i] = true;
        }
        prime[0] = false;
        prime[1] = false;
        int current = 2;
        int addedCurrently = 0;
        while (current < max) {
            if (prime[current]) {
                for (int i = 2 * current; i <= max; i += current) {
                    if (prime[i]) {
                        prime[i] = false;
                        addedCurrently++;
                    }
                }
            } else {
                addedCurrently++;
            }
            if (addedCurrently == 0) {
                break;
            }
            current++;
            addedCurrently = 0;
        }
        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                primeList.add(i);
            }
        }
    }

    public static void main(String[] args) {
        findPrimes(20);
        System.out.println(Arrays.toString(prime));
        System.out.println(primeList);
    }

}
