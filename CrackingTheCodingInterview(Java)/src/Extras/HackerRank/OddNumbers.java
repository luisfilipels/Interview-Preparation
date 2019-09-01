package Extras.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class OddNumbers {

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> returnList = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 != 0) {
                returnList.add(i);
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        System.out.println(oddNumbers(3, 9));
    }

}
