package Extras.HackerRank;

import java.util.HashMap;

public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        if (n <= 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(ar[i])) {
                hashMap.put(ar[i], 1);
            }
            else {
                hashMap.put(ar[i], hashMap.get(ar[i]) + 1);
            }
        }
        int pairs = 0;
        for (int key : hashMap.keySet()) {
            int quotient = hashMap.get(key) / 2;
            pairs += quotient;
        }
        return pairs;

    }

    public static void main(String[] args) {
        int [] list = {1, 2, 1, 1, 2, 1, 3, 2, 3, 3};
        int size = list.length;

        System.out.println(sockMerchant(size, list));
    }

}
