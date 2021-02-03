public class ReverseIntegerInterviewBit {

    int getNumSize(int A) {
        int size = 0;
        while (A > 0) {
            A /= 10;
            size++;
        }

        return size;
    }

    int getDigitAtRevIndex (int A, int index) {
        int currentIndex = -1;
        int val = 0;
        while (currentIndex != index) {
            currentIndex++;
            val = A % 10;
            A /= 10;
        }

        return val;
    }

    public int reverse(int A) {
        int newInt = 0;

        int sign = A < 0 ? -1 : 1;
        A = Math.abs(A);
        int size = getNumSize(A);

        for (int i = 0; i < size; i++) {
            int oldInt = newInt;
            newInt *= 10;

            if (newInt / 10 != oldInt) return 0;

            newInt += getDigitAtRevIndex(A, i);
        }

        return newInt * sign;
    }

}
