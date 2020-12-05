import java.util.Arrays;

public class LargestNumber {

    private static String largestNumber (int[] nums) {
        String[] numsStr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numsStr, (s1, s2) -> {
            String a = s1 + s2;
            String b = s2 + s1;

            return b.compareTo(a);
        });

        if (numsStr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();

        for (String s : numsStr) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                3, 30, 34, 9
        };

        System.out.println(largestNumber(nums));
    }

}
