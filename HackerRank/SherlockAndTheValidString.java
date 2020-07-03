package Extras.HackerRank;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndTheValidString {

    static String isValid (String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1); // Start by counting the occurrence of each character
        }

        HashMap <Integer, Integer> frequencyOcurrence = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            frequencyOcurrence.put(entry.getValue(), frequencyOcurrence.getOrDefault(entry.getValue(), 0) + 1); // Then, count the frequencies
        }

        if (frequencyOcurrence.size() == 1) { // If there is only one frequency, that means all characters appear the same amount of times
            return "YES";
        }

        if (frequencyOcurrence.size() == 2) { // If there are two frequencies, we need to check:
            int [][] occurrences = new int[2][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : frequencyOcurrence.entrySet()) {
                occurrences[i][0] = entry.getKey();
                occurrences[i++][1] = entry.getValue();
            }
            int minimumOccurrence = occurrences[0][0] < occurrences[1][0] ? 0 : 1;
            if (Math.abs(occurrences[0][0] - occurrences[1][0]) > 1 && occurrences[minimumOccurrence][1] != 1) {
                // Does the amount of frequencies differ by more than one, AND is the least occurred frequency not one? If so, the string is invalid.
                return "NO";
            }
            // Is only one of the frequencies one? If so, it's valid.
            if (occurrences[0][1] == 1 && occurrences[1][1] != 1) {
                return "YES";
            }
            if (occurrences[0][1] != 1 && occurrences[1][1] == 1) {
                return "YES";
            }
            return "NO";

        }

        // If there are more than 2 frequencies, return NO.
        return "NO";
    }

    public static void main(String[] args) {
        String s = "aaaabbcc";
        //String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        System.out.println(isValid(s));
    }

}
