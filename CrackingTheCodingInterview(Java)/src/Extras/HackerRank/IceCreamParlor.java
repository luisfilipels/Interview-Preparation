package Extras.HackerRank;

import java.util.HashMap;

public class IceCreamParlor {

    static void whatFlavors (int [] cost, int money) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (hash.containsKey(cost[i])) {
                System.out.println((hash.get(cost[i])+1) + " " + (i+1));
            }
            hash.put(money - cost[i], i);
        }
    }

    public static void main(String[] args) {
        int [] cost = new int[] {2, 2, 4, 3};
        int money = 4;
        whatFlavors(cost, money);
    }

}
