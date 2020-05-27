package Extras.HackerRank;

public class DavisStaircase {

    static int stepPerms (int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
        }
        int [] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr[n];
    }

    public static void main(String[] args) {

    }

}
