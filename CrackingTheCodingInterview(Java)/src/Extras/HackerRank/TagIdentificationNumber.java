package Extras.HackerRank;

public class TagIdentificationNumber {

    // Failed in 4/12 test cases

    public static int numOfIds(String pool) {
        char [] charArray = pool.toCharArray();
        int eightNumber = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '8') {
                eightNumber++;
            }
        }
        int remaining = charArray.length - 1;
        int currentTIDCount = 0;
        while (remaining - 10 >= 0 && eightNumber >= 0) {
            remaining -= 10;
            currentTIDCount++;
            eightNumber--;
        }
        return currentTIDCount;
    }


    public static void main(String[] args) {
        System.out.println(numOfIds("8111111111181111111111"));
    }

}
