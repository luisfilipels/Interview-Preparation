package Extras.LeetCode;

import java.util.Arrays;

public class ReadNCharactersGivenRead4 {

    static int read4(char[]buff) {
        // Implementation not given.
        return 0;
    }

    private static int read (char[] buff, int n) {
        int charsRead = 0;
        char [] buf = new char[4];
        int readBytes = 0;
        while (charsRead < n) {
            int readNow = read4(buff);
            charsRead += readNow;
            int bytes = Math.min(n - readBytes, charsRead);
            System.arraycopy(buff, 0 ,buf, readBytes, bytes);
            if (readNow < 4) break;
        }
        return charsRead;
    }

    public static void main(String[] args) {

    }

}
